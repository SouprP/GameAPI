package me.souprpk.gameapi.api.events;

import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.core.GamePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BodyInteractEvent extends Event{

    private static final HandlerList handlers = new HandlerList();
    private Game game;
    private GamePlayer player;

    public BodyInteractEvent(GamePlayer gamePlayer, Game game){
        this.player = gamePlayer;
        this.game = game;
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
