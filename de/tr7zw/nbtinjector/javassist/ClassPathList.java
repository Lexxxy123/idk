/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist;

import de.tr7zw.nbtinjector.javassist.ClassPath;

final class ClassPathList {
    ClassPathList next;
    ClassPath path;

    ClassPathList(ClassPath p2, ClassPathList n2) {
        this.next = n2;
        this.path = p2;
    }
}

