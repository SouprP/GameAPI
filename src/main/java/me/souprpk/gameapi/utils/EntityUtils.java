package me.souprpk.gameapi.utils;

import me.souprpk.gameapi.api.core.GamePlayer;
import me.souprpk.gameapi.api.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityUtils {

    public static boolean isPlayerDamager(EntityDamageByEntityEvent e){
        return getDamager(e) != null;
    }

    public static GamePlayer getDamager(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            return PlayerManager.getGamePlayer(((Player) e.getDamager()));
        }else if(e.getDamager() instanceof Projectile){
            Projectile a = (Projectile) e.getDamager();
            if(a.getShooter() != null){
                if(a.getShooter() instanceof Player){
                    return PlayerManager.getGamePlayer((Player)a.getShooter());
                }
            }
        }
        return null;
    }
}
