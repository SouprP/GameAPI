package me.souprpk.gameapi.enums;

import me.souprpk.gameapi.api.kits.KitItem;
import org.bukkit.Material;

public class KitEnums {
    public static KitItem[] PVP_STANDARD = {
            // Items
            new KitItem(Material.IRON_SWORD, 1, InventorySlot.FIRST_SLOT),
            new KitItem(Material.BOW, 1, InventorySlot.SECOND_SLOT),
            new KitItem(Material.ARROW, 32, InventorySlot.BACKPACK),
            new KitItem(Material.GOLDEN_APPLE, 3, InventorySlot.NINTH_SLOT),

            // Armor
            new KitItem(Material.IRON_HELMET, 1, InventorySlot.ARMOR_HELMET),
            new KitItem(Material.IRON_CHESTPLATE, 1, InventorySlot.ARMOR_CHESTPLATE),
            new KitItem(Material.IRON_LEGGINGS, 1, InventorySlot.ARMOR_LEGGINGS),
            new KitItem(Material.IRON_BOOTS, 1, InventorySlot.ARMOR_BOOTS)
    };

    public static KitItem[] NULL = {
            new KitItem(Material.AIR, 1, InventorySlot.FIRST_SLOT)
    };
}
