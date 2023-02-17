package me.souprpk.gameapi.enums;

import me.souprpk.gameapi.api.loot.LootItem;
import org.bukkit.Material;

public class LootEnum {

    public static LootItem[] DEFAULT_ITEMS = {
            // Weapons
            new LootItem(Material.WOODEN_SWORD, 1, 1, 0.6),
            new LootItem(Material.WOODEN_AXE, 1, 1, 0.6),
            new LootItem(Material.STONE_SWORD, 1, 1, 0.4),
            new LootItem(Material.STONE_AXE, 1, 1, 0.4),
            new LootItem(Material.IRON_SWORD, 1, 1, 0.2),
            new LootItem(Material.IRON_AXE, 1, 1, 0.15),
            new LootItem(Material.BOW, 1, 1, 0.15),
            new LootItem(Material.FISHING_ROD, 1, 1, 0.1),

            // Armor
            new LootItem(Material.LEATHER_BOOTS, 1, 1, 0.5),
            new LootItem(Material.LEATHER_LEGGINGS, 1, 1, 0.5),
            new LootItem(Material.LEATHER_CHESTPLATE, 1, 1, 0.5),
            new LootItem(Material.LEATHER_HELMET, 1, 1, 0.5),
            new LootItem(Material.IRON_BOOTS, 1, 1, 0.25),
            new LootItem(Material.IRON_LEGGINGS, 1, 1, 0.25),
            new LootItem(Material.IRON_CHESTPLATE, 1, 1, 0.25),
            new LootItem(Material.IRON_HELMET, 1, 1, 0.25),
            new LootItem(Material.GOLDEN_BOOTS, 1, 1, 0.15),
            new LootItem(Material.GOLDEN_LEGGINGS, 1, 1, 0.15),
            new LootItem(Material.GOLDEN_CHESTPLATE, 1, 1, 0.15),
            new LootItem(Material.GOLDEN_HELMET, 1, 1, 0.15),
            new LootItem(Material.CHAINMAIL_BOOTS, 1, 1, 0.1),
            new LootItem(Material.CHAINMAIL_LEGGINGS, 1, 1, 0.1),
            new LootItem(Material.CHAINMAIL_CHESTPLATE, 1, 1, 0.1),
            new LootItem(Material.CHAINMAIL_HELMET, 1, 1, 0.1),

            // Misc
            new LootItem(Material.SNOWBALL, 4, 16, 0.6),
            new LootItem(Material.EGG, 4, 16, 0.6),
            new LootItem(Material.ARROW, 8, 16, 0.25),
            new LootItem(Material.ENDER_PEARL, 1, 2, 0.15),
            new LootItem(Material.STICK, 1, 4, 0.6),
            new LootItem(Material.EXPERIENCE_BOTTLE, 1, 10, 0.2),
            new LootItem(Material.IRON_INGOT, 1, 4, 0.25),
            new LootItem(Material.GOLD_INGOT, 1, 3, 0.15),
            new LootItem(Material.DIAMOND, 1, 2, 0.05),
            new LootItem(Material.STRING, 1, 4, 0.2),
            new LootItem(Material.FLINT, 1, 4, 0.4),
            new LootItem(Material.FEATHER, 1, 4, 0.4),

            // Food
            new LootItem(Material.COOKED_BEEF, 1, 4, 0.3),
            new LootItem(Material.PORKCHOP, 1, 4, 0.3),
            new LootItem(Material.GOLDEN_APPLE, 1, 2, 0.05),
            new LootItem(Material.APPLE, 2, 4, 0.4),
            new LootItem(Material.BOWL, 1, 4, 0.2),
            new LootItem(Material.BROWN_MUSHROOM, 1, 4, 0.2),
            new LootItem(Material.RED_MUSHROOM, 1, 4, 0.2),
            new LootItem(Material.MUSHROOM_STEW, 1, 1, 0.1),
            new LootItem(Material.COOKED_CHICKEN, 1, 4, 0.2),
            new LootItem(Material.CHICKEN, 1, 4, 0.2),
            new LootItem(Material.BAKED_POTATO, 1, 4, 0.2),
            new LootItem(Material.PUMPKIN_PIE, 1, 4, 0.2),


            // pearls, sticks, iron, gold, diamonds, mushrooms, bowls, stone tools, gold armor, diamond tools,
            // exp bottles, cooked chicken, chain armor, strings, TNT, SUPER ITEMS like SUGAR ( SPEED ), SOUPS ( bonus effects )

    };

    public static LootItem[] NULL = {
            new LootItem(Material.AIR, 0, 1, 1)
    };
}
