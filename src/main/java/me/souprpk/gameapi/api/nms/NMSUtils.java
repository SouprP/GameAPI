package me.souprpk.gameapi.api.nms;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.souprpk.gameapi.GameAPI;
import me.souprpk.gameapi.api.core.GamePlayer;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class NMSUtils {

    public static Body spawnCorpse(Player deadPerson) {

        Body body = new Body();
        body.setWhoDied(deadPerson.getUniqueId());
        body.setWhenDied(System.currentTimeMillis());

        CraftPlayer craftPlayer = (CraftPlayer) deadPerson;

        //NMS representation of the MC server
        MinecraftServer server = craftPlayer.getHandle().getServer();
        //NMS representation of the MC world
        ServerLevel level = craftPlayer.getHandle().getLevel();

        //Create a new NPC named Billy Bob, with a new GameProfile to uniquely identify them
        ServerPlayer npc = new ServerPlayer(server, level, new GameProfile(UUID.randomUUID(), ChatColor.stripColor(" ")));
        //Set their position. They will be here when we call the packets below to spawn them

        //find the proper place to put the body
        Location pl = deadPerson.getLocation().getBlock().getLocation().clone();
        while (pl.getBlock().getType() == Material.AIR) {
            pl = pl.subtract(0, 1, 0);
        }

        npc.setPos(deadPerson.getLocation().getX(), pl.getY() + 1, deadPerson.getLocation().getZ());
        npc.setPose(Pose.SLEEPING);

        ArmorStand armorStand = (ArmorStand) deadPerson.getWorld().spawnEntity(npc.getBukkitEntity().getLocation(), EntityType.ARMOR_STAND);
        armorStand.setSmall(true);
        armorStand.setInvulnerable(true);
        armorStand.setInvisible(true);
        ArmorStand armorStand2 = (ArmorStand) deadPerson.getWorld().spawnEntity(npc.getBukkitEntity().getLocation().subtract(1, 0, 0), EntityType.ARMOR_STAND);
        armorStand2.setSmall(true);
        armorStand2.setInvulnerable(true);
        armorStand2.setInvisible(true);
        ArmorStand armorStand3 = (ArmorStand) deadPerson.getWorld().spawnEntity(npc.getBukkitEntity().getLocation().subtract(2, 0, 0), EntityType.ARMOR_STAND);
        armorStand3.setSmall(true);
        armorStand3.setInvulnerable(true);
        armorStand3.setInvisible(true);

        GameProfile gameProfile = ((CraftPlayer) deadPerson).getHandle().getGameProfile();
        Property property = (Property) gameProfile.getProperties().get("textures").toArray()[0];

        String signature = property.getSignature();
        String texture = property.getValue();

        npc.getGameProfile().getProperties().put("textures", new Property("textures", texture, signature));

        PlayerTeam team = new PlayerTeam(new Scoreboard(), npc.getName().getString());
        team.setNameTagVisibility(Team.Visibility.NEVER);
        team.getPlayers().add(npc.getName().getString());

        //Send the packets to artificially spawn this entity, only the clients we are sending the packet to will know of its existence
        Bukkit.getOnlinePlayers().forEach(player -> {
            ServerGamePacketListenerImpl ps = ((CraftPlayer) player).getHandle().connection;
            ps.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.ADD_PLAYER, npc));
            ps.send(new ClientboundAddPlayerPacket(npc));
            ps.send(new ClientboundSetEntityDataPacket(npc.getId(), npc.getEntityData(), true));

            //remove the team
            ps.send(ClientboundSetPlayerTeamPacket.createRemovePacket(team));
            //add the team
            ps.send(ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(team, true));

            new BukkitRunnable() {
                @Override
                public void run() {
                    ps.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.REMOVE_PLAYER, npc));

                }
            }.runTaskLaterAsynchronously(GameAPI.getPlugin(), 20L);

        });

        body.setNpc(npc);
        body.getArmorStands().add(armorStand);
        body.getArmorStands().add(armorStand2);
        body.getArmorStands().add(armorStand3);

        return body;
    }

}
