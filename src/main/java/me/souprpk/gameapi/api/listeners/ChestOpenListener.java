package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.managers.ChestManager;
import me.souprpk.gameapi.api.managers.PlayerManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;

public class ChestOpenListener implements Listener {

    @EventHandler
    public void onChest(InventoryOpenEvent event){
        GamePlayer player = PlayerManager.getGamePlayer((OfflinePlayer) event.getPlayer());
        if(player.isInGame() && player.getGame().getGameSettings().doesRandomizeLoot()){

            InventoryHolder holder = event.getInventory().getHolder();
            ChestManager chestManager = player.getGame().getChestManager();;

            if(holder instanceof Chest){
                Chest chest = (Chest) holder;
                if(chestManager.hasBeenOpened(chest.getLocation())) return;

                chestManager.markAsOpened(chest.getLocation());
                chestManager.fill(chest.getBlockInventory());
            }
        }
    }
}
