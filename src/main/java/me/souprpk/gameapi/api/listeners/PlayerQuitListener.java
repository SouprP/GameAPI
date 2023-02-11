package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void playerQuit(PlayerQuitEvent e){
        GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
        if(player.getGame() != null){
            if(player.getGame().getGameSettings().shouldDisableVanillaJoinLeaveMessages()){
                e.setQuitMessage("");
            }
            if(player.getGame().getGameSettings().shouldLeavePlayerOnDisconnect()){
                player.getGame().removePlayer(player);
            }
        }
    }

}
