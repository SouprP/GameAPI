package me.souprpk.gameapi.api.listeners;

import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.managers.GameManager;
import me.souprpk.gameapi.api.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
        player.setPlayer(e.getPlayer());

        for(Game game : GameManager.getGames()){


            if(game.getGameSettings().usesBungee()){

                game.addPlayer(player);

                break;
            }
        }
        if(player.getGame() != null && player.getGame().getGameSettings().shouldDisableVanillaJoinLeaveMessages()){
            e.setJoinMessage("");
        }

    }

}
