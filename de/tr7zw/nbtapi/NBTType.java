/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

public enum NBTType {
    NBTTagEnd(0),
    NBTTagByte(1),
    NBTTagShort(2),
    NBTTagInt(3),
    NBTTagLong(4),
    NBTTagFloat(5),
    NBTTagDouble(6),
    NBTTagByteArray(7),
    NBTTagIntArray(11),
    NBTTagString(8),
    NBTTagList(9),
    NBTTagCompound(10);

    private final int id;

    private NBTType(int i2) {
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public static NBTType valueOf(int id) {
        for (NBTType t2 : NBTType.values()) {
            if (t2.getId() != id) continue;
            return t2;
        }
        return NBTTagEnd;
    }
}

