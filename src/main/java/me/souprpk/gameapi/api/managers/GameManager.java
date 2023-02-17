package me.souprpk.gameapi.api.managers;

import me.souprpk.gameapi.GameAPI;
import me.souprpk.gameapi.api.core.Arena;
import me.souprpk.gameapi.api.core.ArenaSettings;
import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.core.GameSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameManager {

    private static HashMap<String, Game> games = new HashMap<String, Game>();

    public static void registerGame(Game game){
        games.put(game.getID(), game);
        GameAPI.logInfo(game.getRegisteringPlugin().getName() + " registered game " + game.getID() + ".");

    }

    public static List<Game> getGames(){
        List<Game> games = new ArrayList<Game>();
        Iterator<Game> gIt = GameManager.games.values().iterator();
        while(gIt.hasNext()){
            games.add(gIt.next());
        }
        return games;
    }

    public static Game getGame(String ID){
        return games.get(ID);
    }

    // NOT NEEDED DO NOT USE
    private static void restartGame(Game game){
        Arena arena = game.getArena();
        ArenaSettings arenaSettings = arena.getArenaSettings();
        GameSettings gameSettings = game.getGameSettings();
        String id = game.getID();

        Game newGame = new Game(id, arena, game.getGameType(), GameAPI.getPlugin());
        //games.replace(game.getID(), new Game());
    }
}
