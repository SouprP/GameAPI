package me.souprpk.gameapi.enums;

public enum InventorySlot {
    FIRST_SLOT(0),
    SECOND_SLOT(1),
    THIRD_SLOT(2),
    FOURTH_SLOT(3),
    FIFTH_SLOT(4),
    SIXTH_SLOT(5),
    SEVENTH_SLOT(6),
    EIGHTH_SLOT(7),
    NINTH_SLOT(8),
    BACKPACK(9),
    SHIELD_SLOT(40),
    ARMOR_HELMET(39),
    ARMOR_CHESTPLATE(38),
    ARMOR_LEGGINGS(37),
    ARMOR_BOOTS(36);

    private final int index;
    InventorySlot(int index) {
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
