/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item;

public enum SpecificItemType {
    SWORD(false),
    WAND(false),
    HELMET(false),
    CHESTPLATE(false),
    LEGGINGS(false),
    BOOTS(false),
    BOW(false),
    COSMETIC(false),
    ACCESSORY(false),
    AXE(false),
    PICKAXE(false),
    SHOVEL(false),
    HOE(false),
    SHEARS(false),
    LONGSWORD(false),
    DUNGEON_ITEM,
    NONE,
    ROD(false),
    ARROW_POISON;

    private final boolean stackable;

    private SpecificItemType(boolean stackable) {
        this.stackable = stackable;
    }

    private SpecificItemType() {
        this(true);
    }

    public String getName() {
        return this.name().replaceAll("_", " ");
    }

    public boolean isStackable() {
        return this.stackable;
    }
}

