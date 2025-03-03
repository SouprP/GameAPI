package me.souprpk.gameapi.api.managers;

import me.souprpk.gameapi.api.core.GamePlayer;
import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private static HashMap<UUID, GamePlayer> playerMap = new HashMap<UUID, GamePlayer>();

    /**
     * Get the GamePlayer given a Bukkit Player. GamePlayers are initiated once per server session, and are saved whether or not a player is online.
     * @param player
     * @return GamePlayer, should never be null
     */
    public static GamePlayer getGamePlayer(OfflinePlayer player){
        GamePlayer pl = null;
        if(playerMap.containsKey(player.getUniqueId())){
            pl = playerMap.get(player.getUniqueId());
        }else{
            GamePlayer gpl = new GamePlayer(player);
            playerMap.put(player.getUniqueId(), gpl);
            pl = gpl;
        }
        return pl;
    }
}
