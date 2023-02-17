package me.souprpk.gameapi.api.kits;

import me.souprpk.gameapi.enums.InventorySlot;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitItem {

    private ItemStack item;
    private final Material material;
    private final int amount;
    private Enchantment enchantment = null;
    private int level;
    private InventorySlot slot;
    public KitItem(Material material, int amount, Enchantment enchantment, int level, InventorySlot slot){
        this.material = material;
        this.amount = amount;
        this.enchantment = enchantment;
        this.level = level;
        this.slot = slot;
        make();
    }

    public KitItem(Material material, int amount, InventorySlot slot){
        this.material = material;
        this.amount = amount;
        this.slot = slot;
        make();
    }

    public KitItem(ItemStack item, int amount, InventorySlot slot){
        this.material = item.getType();
        this.amount = amount;
        this.slot = slot;

        this.item = item;
        make();
    }

    public void make(){
        if(item != null) return;

        item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if(enchantment != null)
            meta.addEnchant(enchantment, level, false);

        item.setItemMeta(meta);
    }

    public InventorySlot getSlot(){
        return this.slot;
    }

    public ItemStack getKitItem(){
        return this.item;
    }
}
