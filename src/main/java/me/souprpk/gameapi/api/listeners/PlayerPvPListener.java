package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.events.PlayerDamagePlayerEvent;
import me.souprpk.gameapi.api.events.PlayerKillPlayerEvent;
import me.souprpk.gameapi.api.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerPvPListener implements Listener {


    @EventHandler
    public void playerDamagePlayer(EntityDamageByEntityEvent e){
        GamePlayer player = null;
        GamePlayer damager = null;
        if(e.getEntity() instanceof Player && (e.getDamager() instanceof Arrow || e.getDamager() instanceof Player)){
            player = PlayerManager.getGamePlayer((Player) e.getEntity());
            if(e.getDamager() instanceof Arrow){
                Arrow arrow = (Arrow) e.getDamager();
                if(arrow.getShooter() instanceof Player){
                    damager = PlayerManager.getGamePlayer((OfflinePlayer) arrow.getShooter());
                }
            }else{
                damager = PlayerManager.getGamePlayer((Player) e.getDamager());
            }
        }
        if(player != null && damager != null){
            if(player.isInGame() && damager.isInGame()){
                if(
                        !e.isCancelled() &&
                                player.getGame().equals(damager.getGame())){
                    if((player.getOnlinePlayer().getHealth() - e.getFinalDamage() <= 0)){
                        PlayerKillPlayerEvent ev = new PlayerKillPlayerEvent(damager, player, damager.getGame());
                        Bukkit.getPluginManager().callEvent(ev);
                        if(!ev.isCancelled()){
                            damager.getGame().increaseKills(damager, 1);
                        }else{
                            e.setCancelled(true);
                        }
                    }else{
                        PlayerDamagePlayerEvent ev = new PlayerDamagePlayerEvent(damager, player, damager.getGame());
                        Bukkit.getPluginManager().callEvent(ev);
                        e.setCancelled(ev.isCancelled());
                    }
                }
            }
        }
    }

}
