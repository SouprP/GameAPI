package me.souprpk.gameapi.api.managers;

import me.souprpk.gameapi.api.core.Arena;
import me.souprpk.gameapi.api.loot.LootItem;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChestManager implements Listener {

    private final Arena arena;
    Set<Location> openedChests = new HashSet<>();
    private final List<LootItem> lootItemList = new ArrayList<>();

    public ChestManager(Arena arena, LootItem[] items){
        lootItemList.addAll(Arrays.asList(items));
        this.arena = arena;
    }

    public void fill(Inventory inv){
        inv.clear();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Set<LootItem> used = new HashSet<>();

        for(int slotIndex = 0; slotIndex < inv.getSize(); slotIndex++){
            LootItem randomItem = lootItemList.get(random.nextInt(
                    lootItemList.size()));

            if(used.contains(randomItem)) continue;
            used.add(randomItem);

            if(randomItem.shouldFill(random)){
                ItemStack item = randomItem.make(random);
                inv.setItem(slotIndex, item);
            }
        }
    }

    public void markAsOpened(Location loc){
        openedChests.add(loc);
    }

    public boolean hasBeenOpened(Location loc){
        return openedChests.contains(loc);
    }

    public void resetChests(){
        openedChests.clear();
    }

    @EventHandler
    public void onChest(InventoryOpenEvent event){
        if(!arena.getName().equals(event.getPlayer().getWorld().getName())) return;

        InventoryHolder holder = event.getInventory().getHolder();

        if(holder instanceof Chest){
            Chest chest = (Chest) holder;
            if(hasBeenOpened(chest.getLocation())) return;

            markAsOpened(chest.getLocation());
            fill(chest.getBlockInventory());
        }
    }
}
