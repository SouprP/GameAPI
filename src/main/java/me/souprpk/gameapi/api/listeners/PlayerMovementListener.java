package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.Area;
import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.events.AreaEvent;
import me.souprpk.gameapi.api.events.PlayerEnterAreaEvent;
import me.souprpk.gameapi.api.events.PlayerLeaveAreaEvent;
import me.souprpk.gameapi.api.managers.PlayerManager;
import me.souprpk.gameapi.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
        if(player.isInGame()){
            for(Area area : player.getGame().getAreas()){
                Location f = e.getFrom();
                Location t = e.getTo();
                Location l1 = area.getLocation1();
                Location l2 = area.getLocation2();
                boolean fromIsIn = false;
                boolean toIsIn = false;
                if(LocationUtils.isInArea(f, l1, l2)){
                    fromIsIn = true;
                }
                if(LocationUtils.isInArea(t, l1, l2)){
                    toIsIn = true;
                }
                AreaEvent ev = null;
                if(fromIsIn && !toIsIn){
                    ev = new PlayerLeaveAreaEvent(player, area);
                }else if(!fromIsIn && toIsIn){
                    ev = new PlayerEnterAreaEvent(player, area);
                }
                if(ev != null){
                    Bukkit.getPluginManager().callEvent(ev);
                    e.setCancelled(ev.isCancelled());
                }
            }
        }
    }

}
