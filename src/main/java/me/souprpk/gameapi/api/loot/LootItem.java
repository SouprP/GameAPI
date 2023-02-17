package me.souprpk.gameapi.api.loot;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LootItem {

    private ItemStack item = null;
    private final Material material;
    private final int minAmount;
    private final int maxAmount;
    private final double chance;
    private Enchantment enchantment = null;
    private int level;
    private String name = null;
    private List<String> lore = null;

    public LootItem(Material material, int minAmount, int maxAmount, double chance){
        this.material = material;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chance = chance;
    }

    public LootItem(Material material, Enchantment ench, int level, int minAmount, int maxAmount, double chance){
        this.material = material;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chance = chance;

        this.enchantment = ench;
        this.level = level;
    }

    public LootItem(Material material, String name, int minAmount, int maxAmount, double chance){
        this.material = material;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chance = chance;

        this.name = name;
    }

    public LootItem(Material material, String name, List<String> lore,int minAmount, int maxAmount, double chance){
        this.material = material;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chance = chance;

        this.name = name;
        this.lore = lore;
    }

    public LootItem(ItemStack item, int minAmount, int maxAmount, double chance){
        this.material = item.getType();
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chance = chance;

        this.item = item;
        this.name = item.getItemMeta().getDisplayName();
        this.lore = item.getItemMeta().getLore();
    }

    public boolean shouldFill(Random random){
        return random.nextDouble() < chance;
    }

    public ItemStack make(ThreadLocalRandom random){
        int amount = random.nextInt(minAmount, maxAmount + 1);
        if(item != null) return item;

        item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if(name != null)
            meta.setDisplayName(name);

        if(lore != null)
            meta.setLore(lore);

        if(enchantment != null)
            meta.addEnchant(enchantment, level, false);

        item.setItemMeta(meta);
        return item;
    }
}
