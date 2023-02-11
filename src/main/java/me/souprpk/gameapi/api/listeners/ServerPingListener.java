package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.managers.GameManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPingListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent e){
        boolean motdSet = false;
        boolean playerCountSet = false;
        for(Game g : GameManager.getGames()){
            if(g.getGameSettings().doesSetMOTD() && !motdSet){
                e.setMotd(StringUtils.capitalize(StringUtils.lowerCase(g.getGameStatus().toString())));
                motdSet = true;
            }
            if(g.getGameSettings().doesSetListPlayerCount() && !playerCountSet){
                e.setMaxPlayers(g.getGameSettings().getMaximumPlayers());
                playerCountSet = true;
            }

        }
    }

}
