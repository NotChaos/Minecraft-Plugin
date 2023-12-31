package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Teleport implements Listener {

    @EventHandler
    public void event(PlayerTeleportEvent event) {
        World to = event.getTo().getWorld();
        World from = event.getPlayer().getWorld();
        Player p = event.getPlayer();
        PlayerTeleportEvent.TeleportCause cause = event.getCause();

        String toName = to.getName();
        String fromName = from.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        if (String.valueOf(cause).equals("COMMAND")) {
            Embed embed = new Embed(Main.link);
            embed.setTts(false);
            try {
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Teleport")
                        .addField(":person_in_tuxedo: Player", p.getName(), false)
                        .addField("to world", toName, false)
                        .addField("from world", fromName, false)
                        .addField("location", x + " " + y + " " + z, false)
                        .setFooter(Main.name, "")
                        .setColor(Color.BLUE));
                embed.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Log.log(p.getName() + " teleported ( from " + fromName + " to " + toName + " " + x + " " + y + " " + z + ")");

        } else {
            Embed embed = new Embed(Main.link);
            embed.setTts(false);
            try {
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Portal use")
                        .addField(":person_in_tuxedo: Player", p.getName(), false)
                        .addField("to world", toName, false)
                        .addField("from world", fromName, false)
                        .addField("location", x + " " + y + " " + z, false)
                        .setFooter(Main.name, "")
                        .setColor(Color.BLUE));
                embed.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Log.log(p.getName() + " used a portal ( from " + fromName + " to " + toName + " " + x + " " + y + " " + z + ")");
        }
    }
}
