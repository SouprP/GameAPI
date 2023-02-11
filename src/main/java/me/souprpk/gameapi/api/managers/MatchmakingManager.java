package me.souprpk.gameapi.api.managers;

import me.souprpk.gameapi.api.core.Game;
import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.enums.GameState;
import me.souprpk.gameapi.enums.GameType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatchmakingManager {

    /*
    * Chooses the game with the biggest amount of players
    * if it cant find such game, it chooses a random available game
     */
    public static void matchmaking(Player player, GameType gameType){
        GamePlayer gamePlayer = PlayerManager.getGamePlayer(player);

        if(gamePlayer.isInGame())
            return;

        // Choose the game with the biggest amount of players
        // i = amount of players
        int i = 0;
        Game selectedGame = GameManager.getGames().get(0);
        for(Game game : GameManager.getGames())
            if(game.getGameType() == gameType)
                if(game.getGameStatus() == GameState.STARTING)
                    if(game.getPlayers().size() >= i){
                        i = game.getPlayers().size();
                        selectedGame = game;
                    }

        // If selected game has 0 players, get all games of the same type
        if(selectedGame.getPlayers().size() == 0){
            List<Game> correctGameTypeList = new ArrayList<>();
            for(Game game : GameManager.getGames())
                if(game.getGameType() == gameType && game.getGameStatus() == GameState.STARTING)
                    correctGameTypeList.add(game);

            // Choose a random game from the list
            int x = new Random().nextInt(correctGameTypeList.size());
            selectedGame = correctGameTypeList.get(x);
        }

        selectedGame.addPlayer(gamePlayer);
    }
}
