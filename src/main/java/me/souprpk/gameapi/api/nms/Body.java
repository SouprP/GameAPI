package me.souprpk.gameapi.api.nms;

import net.minecraft.server.level.ServerPlayer;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Body {

    private UUID whoDied;
    private ServerPlayer npc;
    private List<ArmorStand> armorStands;
    private long whenDied; //epoch time as long in ms

    public Body() {
        this.armorStands = new ArrayList<>();
    }

    /**
     * No real use actually
     * @param whoDied
     * @param npc
     * @param armorStands
     * @param whenDied
     */
    public Body(UUID whoDied, ServerPlayer npc, List<ArmorStand> armorStands, long whenDied) {
        this.whoDied = whoDied;
        this.npc = npc;
        this.armorStands = armorStands;
        this.whenDied = whenDied;
    }

    public List<ArmorStand> getArmorStands() {
        return armorStands;
    }

    public void setArmorStands(List<ArmorStand> armorStands) {
        this.armorStands = armorStands;
    }

    public ServerPlayer getNpc() {
        return npc;
    }

    public void setNpc(ServerPlayer npc) {
        this.npc = npc;
    }

    public UUID getWhoDied() {
        return whoDied;
    }

    public void setWhoDied(UUID whoDied) {
        this.whoDied = whoDied;
    }

    public long getWhenDied() {
        return whenDied;
    }

    public void setWhenDied(long whenDied) {
        this.whenDied = whenDied;
    }

    public void removeArmorStands(){
        for(ArmorStand as : armorStands)
            as.remove();
    }
}
