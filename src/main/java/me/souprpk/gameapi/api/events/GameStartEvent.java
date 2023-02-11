package me.souprpk.gameapi.api.events;

import me.souprpk.gameapi.api.core.Game;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

public class GameStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Game game;

    public GameStartEvent(Game game){
        this.game = game;
    }

    /**
     * Get the game this event refers to.
     * @return Game
     */
    public Game getGame(){
        return this.game;
    }

    @Override
    public HandlerList getHandlers() {
        for(RegisteredListener listener : handlers.getRegisteredListeners()){
            if(!listener.getPlugin().equals(game.getRegisteringPlugin())){
                handlers.unregister(listener);
            }
        }
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

}
