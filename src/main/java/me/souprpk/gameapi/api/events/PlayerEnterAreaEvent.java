package me.souprpk.gameapi.api.events;

import me.souprpk.gameapi.api.core.Area;
import me.souprpk.gameapi.api.core.GamePlayer;

public class PlayerEnterAreaEvent extends AreaEvent {

    public PlayerEnterAreaEvent(GamePlayer player, Area area) {
        super(player, area);
    }

}

