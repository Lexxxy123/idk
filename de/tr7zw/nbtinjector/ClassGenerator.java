/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import de.tr7zw.nbtinjector.INBTWrapper;
import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtField;
import de.tr7zw.nbtinjector.javassist.CtMethod;
import de.tr7zw.nbtinjector.javassist.CtNewConstructor;
import de.tr7zw.nbtinjector.javassist.LoaderClassPath;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class ClassGenerator {
    private static final String GENERATOR_PACKAGE = "de.tr7zw.nbtinjector.generated";

    private ClassGenerator() {
    }

    protected static Class<?> wrapNbtClass(ClassPool classPool, Class<?> originalClass, String writeMethod, String readMethod, String extraDataKey) throws NotFoundException, CannotCompileException, IOException {
        classPool.insertClassPath(new LoaderClassPath(ClassGenerator.class.getClassLoader()));
        CtClass generated = classPool.makeClass("de.tr7zw.nbtinjector.generated." + originalClass.getSimpleName());
        CtClass wrapperInterface = classPool.get(INBTWrapper.class.getName());
        generated.setInterfaces(new CtClass[]{wrapperInterface});
        generated.setSuperclass(classPool.get(originalClass.getName()));
        classPool.importPackage("net.minecraft.server." + MinecraftVersion.getVersion().name().replace("MC", "v"));
        classPool.importPackage(NBTCompound.class.getPackage().getName());
        classPool.importPackage(GENERATOR_PACKAGE);
        generated.addField(CtField.make("public NBTCompound $extraCompound = new NBTContainer();", generated));
        generated.addMethod(CtMethod.make("public NBTCompound getNbtData() {\n  return this.$extraCompound;\n}", generated));
        generated.addMethod(CtMethod.make("public NBTTagCompound readExtraCompound(NBTTagCompound root) {\n  NBTTagCompound compound = root.getCompound(\"" + extraDataKey + "\");\n  this.$extraCompound = new NBTContainer(compound);\n  return root;}", generated));
        generated.addMethod(CtMethod.make("public NBTTagCompound writeExtraCompound(NBTTagCompound root) {\n  NBTBase compound = (NBTBase) this.$extraCompound.getCompound();\n  NBTTagCompound newRoot = new NBTTagCompound();\n  newRoot.set(\"" + extraDataKey + "\", compound);\n  root.a(newRoot);\n  return root;}", generated));
        generated.addMethod(CtMethod.make(writeMethod, generated));
        generated.addMethod(CtMethod.make(readMethod, generated));
        for (Constructor<?> constructor : originalClass.getConstructors()) {
            String paramString = "";
            String paramNameString = "";
            int c2 = 0;
            for (Class<?> clazz : constructor.getParameterTypes()) {
                if (c2 != 0) {
                    paramString = paramString + ",";
                    paramNameString = paramNameString + ",";
                }
                paramString = paramString + clazz.getName() + " param" + c2;
                paramNameString = paramNameString + "param" + c2;
                ++c2;
            }
            generated.addConstructor(CtNewConstructor.make("public " + originalClass.getSimpleName() + "(" + paramString + ") {\n  super(" + paramNameString + ");\n}", generated));
        }
        generated.writeFile("nbtinjector_generated");
        return generated.toClass(INBTWrapper.class.getClassLoader(), INBTWrapper.class.getProtectionDomain());
    }

    protected static Class<?> createEntityTypeWrapper(ClassPool classPool, Class<?> targetClass) throws NotFoundException, CannotCompileException, IOException {
        classPool.insertClassPath(new LoaderClassPath(ClassGenerator.class.getClassLoader()));
        CtClass generated = classPool.makeClass("de.tr7zw.nbtinjector.generated.entityCreator." + targetClass.getSimpleName());
        CtClass wrapperInterface = classPool.get(ClassWrapper.NMS_ENTITYTYPES.getClazz().getName() + "$b");
        generated.setInterfaces(new CtClass[]{wrapperInterface});
        classPool.importPackage("net.minecraft.server." + MinecraftVersion.getVersion().name().replace("MC", "v"));
        classPool.importPackage(GENERATOR_PACKAGE);
        generated.addMethod(CtMethod.make("public Entity create(EntityTypes var1, World var2) {\n  return new " + targetClass.getName() + "(var1, var2);\n}", generated));
        generated.writeFile("nbtinjector_generated");
        return generated.toClass(INBTWrapper.class.getClassLoader(), INBTWrapper.class.getProtectionDomain());
    }

    protected static Class<?> wrapEntity(ClassPool classPool, Class<?> originalClass, String extraDataKey) throws NotFoundException, CannotCompileException, IOException {
        String writeReturn = MinecraftVersion.getVersion().getVersionId() > MinecraftVersion.MC1_10_R1.getVersionId() ? "NBTTagCompound" : "void";
        String writeName = ReflectionMethod.NMS_ENTITY_GET_NBT.getMethodName();
        String readName = ReflectionMethod.NMS_ENTITY_SET_NBT.getMethodName();
        if (MinecraftVersion.getVersion().getVersionId() < MinecraftVersion.MC1_11_R1.getVersionId()) {
            writeName = "b";
            readName = "f";
        }
        String writeMethod = "public " + writeReturn + " " + writeName + "(NBTTagCompound compound) {\n  super." + writeName + "(compound);\n  compound = writeExtraCompound(compound);\n  " + (!"void".equals(writeReturn) ? "return compound;" : "") + "}";
        String readMethod = "public void " + readName + "(NBTTagCompound compound) {\n  super." + readName + "(compound);\n  readExtraCompound(compound);\n}";
        return ClassGenerator.wrapNbtClass(classPool, originalClass, writeMethod, readMethod, extraDataKey);
    }

    protected static Class<?> wrapTileEntity(ClassPool classPool, Class<?> originalClass, String extraDataKey) throws NotFoundException, CannotCompileException, IOException {
        String writeReturn = MinecraftVersion.getVersion().getVersionId() > MinecraftVersion.MC1_9_R1.getVersionId() ? "NBTTagCompound" : "void";
        String writeName = ReflectionMethod.TILEENTITY_GET_NBT.getMethodName();
        String readName = ReflectionMethod.TILEENTITY_SET_NBT.getMethodName();
        if (MinecraftVersion.getVersion().getVersionId() < MinecraftVersion.MC1_16_R1.getVersionId()) {
            readName = ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1151.getMethodName();
        }
        String writeMethod = "public " + writeReturn + " " + writeName + "(NBTTagCompound compound) {\n  compound = writeExtraCompound(compound);\n  " + (!"void".equals(writeReturn) ? "return " : "") + "super." + writeName + "(compound);\n}";
        String readMethod = "public void " + readName + "(NBTTagCompound compound) {\n  super." + readName + "(compound);\n  readExtraCompound(compound);\n}";
        return ClassGenerator.wrapNbtClass(classPool, originalClass, writeMethod, readMethod, extraDataKey);
    }
}

