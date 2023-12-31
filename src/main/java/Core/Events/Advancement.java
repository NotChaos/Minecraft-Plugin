package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import java.awt.*;
import java.io.IOException;

public class Advancement implements Listener {

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
        Player p = event.getPlayer();
        org.bukkit.advancement.Advancement advancement = event.getAdvancement();

        World world = p.getWorld();
        String worldName = world.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        String key = event.getAdvancement().getKey().getKey();
        if (key.contains("recipe/") || key.contains("recipes/")) return;

        if (advancement == null || p == null) return;

        String advancement1 = event.getAdvancement().getKey().getKey();

        Embed embed = new Embed(Main.link);
        embed.setTts(false);
        try {
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Advancement")
                    .addField(":person_in_tuxedo: Player", p.getName(), false)
                    .addField(":trophy: Advancement", advancement1, false)
                    .setFooter(Main.name, "")
                    .setColor(Color.BLUE));
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Location")
                    .addField(":earth_africa:", "World: " + worldName + " coordinates " + x + " " + y + " " + z, false)
                    .setColor(Color.gray)
            );

            embed.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.log(p.getName() + " got the advancement ( at " + worldName + " " + x + " " + y + " " + z + ")");
    }
}
