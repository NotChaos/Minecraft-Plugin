package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import java.awt.*;
import java.io.IOException;

public class Kick implements Listener {

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player p = event.getPlayer();
        String reason = event.getReason();
        String cause = String.valueOf(event.getCause());

        World world = p.getWorld();
        String worldName = world.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        if (cause == "KICKED") {
            return;
        }

        Embed embed = new Embed(Main.link);
        embed.setTts(false);
        try {
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Kick")
                    .addField(":person_in_tuxedo: Player", p.getName(), false)
                    .addField("Reason",  reason, false)
                    .setFooter(Main.name, "")
                    .setColor(Color.RED));
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Location")
                    .addField(":earth_africa:", "World: " + worldName + " coordinates " + x + " " + y + " " + z, false)
                    .setColor(Color.gray)
            );

            embed.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.log(p.getName() + " got kicked  with the reason " + reason + "( at " + worldName + " " + x + " " + y + " " + z + ")");
    }
}
