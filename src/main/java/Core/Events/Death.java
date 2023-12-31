package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.awt.*;
import java.io.IOException;

public class Death implements Listener {



    @EventHandler
    public void onDeath(PlayerDeathEvent event) throws IOException {
        Player p = event.getEntity();
        String reason = event.getDeathMessage();

        World world = p.getWorld();
        String worldName = world.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        Embed embed = new Embed(Main.link);
        embed.setTts(false);
        try {
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Death")
                    .addField(":person_in_tuxedo: Player", p.getName(), false)
                    .addField(":earth_americas: World",  world.getName(), false)
                    .addField(":regional_indicator_x:", String.valueOf(x), true)
                    .addField(":regional_indicator_y:", String.valueOf(y), true)
                    .addField(":regional_indicator_z:", String.valueOf(z), true)
                    .addField(":earth_africa: Command", "/execute in " + worldName + " run tp @s " + x + " " + y + " " + z, false)
                    .setFooter(Main.name, "")
                    .setColor(Color.BLUE));
                embed.addEmbed(new Embed.EmbedObject()
                .addField("Cause", reason, false)
            );

            embed.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.log(p.getName() + reason + " ( at " + worldName + " " + x + " " + y + " " + z + ")");
    }
}
