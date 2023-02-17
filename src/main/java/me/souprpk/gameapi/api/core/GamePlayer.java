package me.souprpk.gameapi.api.core;

import me.souprpk.gameapi.api.kits.KitItem;
import me.souprpk.gameapi.api.kits.PlayerKit;
import me.souprpk.gameapi.enums.InventorySlot;
import me.souprpk.gameapi.utils.LocationUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {

    private OfflinePlayer player;

    private Team team;

    private Game game;

    private PlayerKit kit;

    public GamePlayer(OfflinePlayer player){
        this.player = player;
    }


    public void setPlayer(OfflinePlayer player){
        this.player = player;
    }

    /**
     * Set the game this player is in.
     * Used by the internal API, bad things might happen if you set this yourself!
     * @param game Game to be set.
     */
    protected void setGame(Game game){
        this.game = game;
    }


    /**
     * Get the Bukkit (offline) player.
     * For the online player, use getOnlinePlayer(). Make sure you check if the player is online with isOnline()!
     * @return OfflinePlayer
     */
    public OfflinePlayer getPlayer(){
        return player;
    }

    /**
     * Get the online Bukkit Player.
     * @return Player if online, null if otherwise.
     */
    public Player getOnlinePlayer(){
        return player.getPlayer();
    }

    /**
     * Checks whether the player is online.
     * @return boolean online
     */
    public boolean isOnline(){
        return getOnlinePlayer() != null;
    }

    /**
     * Set the team this player is in. This is an internal API method, bad things might happen if you set this yourself!
     * @param team Team to be set.
     */
    protected void setTeam(Team team){
        Team oldTeam = this.team;
        this.team = team;
        if(oldTeam != null){
            oldTeam.removePlayer(this);
        }
    }

    /**
     * Get the team this player is in. If the player is not in a team, returns null.
     * @return Team object or null.
     */
    public Team getTeam(){
        return team;
    }

    /**
     * Get the game the player is in.
     * @return Game object if the player is in a game, null otherwise (see GamePlayer.isInGame())
     */
    public Game getGame(){
        return game;
    }

    /**
     * Returns whether the player is in a game.
     * @return true if in a game, false otherwise.
     */
    public boolean isInGame(){
        return this.game != null;
    }

    /**
     * Get the list of areas this player is in.
     * @return List<Area> of areas. Only null if the player is not in a game, or is offline.
     */
    public List<Area> getAreas(){
        if(!this.isInGame()) return null;
        if(!this.isOnline()) return null;
        List<Area> areas = new ArrayList<Area>();
        for(Area area : this.getGame().getAreas()){
            if(LocationUtils.isInArea(this.getOnlinePlayer().getLocation(), area.getLocation1(), area.getLocation2()))
                areas.add(area);

        }
        return areas;
    }

    public void setKit(PlayerKit kit){
        this.kit = kit;
    }

    public void giveKit(){
        Player p = getOnlinePlayer();
        int i = InventorySlot.BACKPACK.getIndex();
        for(KitItem item : kit.getKitItems()){
            if(item.getSlot() == InventorySlot.BACKPACK){
                p.getInventory().setItem(i, item.getKitItem());
                i++;
            }
            else{
                p.getInventory().setItem(item.getSlot().getIndex(), item.getKitItem());
            }
        }
    }
}
