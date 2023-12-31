package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.awt.*;
import java.io.IOException;

public class GamemodeChange implements Listener {

    @EventHandler
    public void GamemodeChangeEvent(PlayerGameModeChangeEvent event) {
        Player p = event.getPlayer();
        GameMode gamemode = event.getNewGameMode();
        String cause = String.valueOf(event.getCause());

        World world = p.getWorld();
        String worldName = world.getName();
        int x = (int) p.getLocation().getX();
        int y = (int) p.getLocation().getY();
        int z = (int) p.getLocation().getZ();

        Embed embed = new Embed(Main.link);
        embed.setTts(false);
        try {
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Gamemode change")
                    .addField(":person_in_tuxedo: Player", p.getName(), false)
                    .addField("new Gamemode", String.valueOf(gamemode), false)
                    .addField("cause", cause, false)
                    .setFooter(Main.name, "")
                    .setColor(Color.ORANGE));
            embed.addEmbed(new Embed.EmbedObject()
                    .setTitle("Location")
                    .addField(":earth_africa:", "World: " + worldName + " coordinates " + x + " " + y + " " + z, false)
                    .setColor(Color.gray)
            );

            embed.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Log.log(p.getName() + " changed the gamemode to " + String.valueOf(gamemode) + " with the cause of " + cause + " ( at " + worldName + " " + x + " " + y + " " + z + ")");
    }
}
