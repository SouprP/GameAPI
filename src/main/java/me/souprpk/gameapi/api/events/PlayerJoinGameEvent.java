package me.souprpk.gameapi.api.events;

import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.enums.GamePlayerState;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerJoinGameEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private GamePlayer player;
    private Game game;
    private GamePlayerState type;

    public PlayerJoinGameEvent(GamePlayer player, Game game){
        this.player = player;
        this.game = game;
        this.type = GamePlayerState.ALIVE;
    }

    public void setGamePlayerType(GamePlayerState type){
        this.type = type;
    }

    public GamePlayerState getGamePlayerState(){
        return this.type;
    }

    public GamePlayer getPlayer(){
        return this.player;
    }

    public Game getGame(){
        return this.game;
    }

    public HandlerList getHandlers() {


        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

}
