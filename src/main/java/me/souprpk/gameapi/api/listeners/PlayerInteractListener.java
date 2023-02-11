package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.events.BodyInteractEvent;
import me.souprpk.gameapi.api.managers.PlayerManager;
import me.souprpk.gameapi.api.nms.Body;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        GamePlayer player = PlayerManager.getGamePlayer(event.getPlayer());
        if(player.isInGame())
            if(event.getRightClicked() instanceof ArmorStand){

                for(Body body : player.getGame().getBodies().keySet())
                    if(body.getArmorStands().contains(event.getRightClicked())){
                        BodyInteractEvent ev = new BodyInteractEvent(player, player.getGame());
                        Bukkit.getPluginManager().callEvent(ev);
                    }
            }
    }
}
