package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.awt.*;
import java.io.IOException;

public class Command implements Listener {

    @EventHandler
    public void onPlayerCommandSendEvent(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String cmd = e.getMessage();

        World world = p.getWorld();
        String worldName = world.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        Embed embed = new Embed(Main.command_link);
        embed.setTts(false);
        try {
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Command")
                    .addField(":person_in_tuxedo: Player", p.getName(), false)
                    .addField(":keyboard: Command", cmd, false)
                    .setFooter(Main.name, "")
                    .setColor(Color.MAGENTA));
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Location")
                    .addField(":earth_africa:", "World: " + worldName + " coordinates " + x + " " + y + " " + z, false)
                    .setColor(Color.gray)
            );

            embed.execute();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        Log.log(p.getName() + " used the command " + cmd + " ( at " + worldName + " " + x + " " + y + " " + z + ")");
    }
}
