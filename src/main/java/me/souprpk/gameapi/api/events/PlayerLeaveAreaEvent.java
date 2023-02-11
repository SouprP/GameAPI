package me.souprpk.gameapi.api.events;

import me.souprpk.gameapi.api.core.Area;
import me.souprpk.gameapi.api.core.GamePlayer;

public class PlayerLeaveAreaEvent extends AreaEvent {

    public PlayerLeaveAreaEvent(GamePlayer player, Area area) {
        super(player, area);
    }

}
