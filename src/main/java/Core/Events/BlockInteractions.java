package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.*;
import java.io.IOException;

public class BlockInteractions implements Listener {

    @EventHandler
    public void ChestOpen(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) {
            return;
        }

        Material block = event.getClickedBlock().getType();
        World location_world = event.getClickedBlock().getLocation().getWorld();
        int location_x = event.getClickedBlock().getLocation().getBlockX();
        int location_y = event.getClickedBlock().getLocation().getBlockY();
        int location_z = event.getClickedBlock().getLocation().getBlockZ();
        Player p = event.getPlayer();

        if (block == Material.CHEST) {

            Embed webhook = new Embed(Main.link);
            webhook.setTts(false);
            webhook.addEmbed(new Embed.EmbedObject()
                    .setTitle("Chest opened")
                    .addField("World", location_world.getName(), false)
                    .addField("Coordinates", location_x + " " + location_y + " " + location_z, false)
                    .addField("Player", p.getName(), false)
                    .setColor(Color.BLUE)
                    .setFooter(Main.name, ""));
            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.log(p.getName() + " opened a chest ( at " + location_world + " " + location_x + " " + location_y + " " + location_z + ")");
        }

        if (block == Material.TRAPPED_CHEST) {

            Embed webhook = new Embed(Main.link);
            webhook.setTts(false);
            webhook.addEmbed(new Embed.EmbedObject()
                    .setTitle("trapped Chest opened")
                    .addField("World", location_world.getName(), false)
                    .addField("Coordinates", location_x + " " + location_y + " " + location_z, false)
                    .addField("Player", p.getName(), false)
                    .setColor(Color.BLUE)
                    .setFooter(Main.name, ""));
            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.log(p.getName() + " opened a trapped chest ( at " + location_world + " " + location_x + " " + location_y + " " + location_z + ")");
        }

        if (block == Material.ENDER_CHEST) {

            Embed webhook = new Embed(Main.link);
            webhook.setTts(false);
            webhook.addEmbed(new Embed.EmbedObject()
                    .setTitle("Enderchest opened")
                    .addField("World", location_world.getName(), false)
                    .addField("Coordinates", location_x + " " + location_y + " " + location_z, false)
                    .addField("Player", p.getName(), false)
                    .setColor(Color.BLUE)
                    .setFooter(Main.name, ""));
            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.log(p.getName() + " opened a enderchest ( at " + location_world + " " + location_x + " " + location_y + " " + location_z + ")");
        }

        if (block == Material.BARREL) {

            Embed webhook = new Embed(Main.link);
            webhook.setTts(false);
            webhook.addEmbed(new Embed.EmbedObject()
                    .setTitle("Barrel opened")
                    .addField("World", location_world.getName(), false)
                    .addField("Coordinates", location_x + " " + location_y + " " + location_z, false)
                    .addField("Player", p.getName(), false)
                    .setColor(Color.BLUE)
                    .setFooter(Main.name, ""));
            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Log.log(p.getName() + " opened a barrel ( at " + location_world + " " + location_x + " " + location_y + " " + location_z + ")");
        }
    }
}
