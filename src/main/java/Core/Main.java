package Core;

import Core.Events.*;
import Core.Sending.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public static String link;
    public static String command_link;
    public static String name = "ChaosLogger";

    private Log logManager;

    public Main() {
        link = getConfig().getString("webhook_url");
        command_link = getConfig().getString("webhook_url_spam");
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Death(), this);
        getServer().getPluginManager().registerEvents(new GamemodeChange(), this);
        getServer().getPluginManager().registerEvents(new Kick(), this);
        getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLogout(), this);
        getServer().getPluginManager().registerEvents(new Advancement(), this);
        getServer().getPluginManager().registerEvents(new Teleport(), this);
        getServer().getPluginManager().registerEvents(new Stop(), this);
        getServer().getPluginManager().registerEvents(new Start(), this);
        getServer().getPluginManager().registerEvents(new BlockInteractions(), this);
        getServer().getPluginManager().registerEvents(new Command(), this);

        getConfig().options().copyDefaults(true);
        saveConfig();

        Log.log("Plugin enabled.");
    }

    @Override
    public void onDisable() {
    }
}


    /*
    @EventHandler
    public void playerlogin(PlayerPreLoginEvent event) {
        String player = event.getName();

        if (BanList.Type.NAME.equals(player)) { //doesnt work it needs to check if it CONTAINS the player
            String reason = String.valueOf(BanList.Type.NAME.describeConstable());

            Embed embed = new Embed(Main.link);
            embed.setTts(false);
            try {
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Ban")
                        .addField("<:Players:1061006964773109781> Player", player, false)
                        .addField("Reason",  reason, false)
                        .setFooter(Main.name, "")
                        .setColor(Color.RED));
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Location")

                        .setColor(Color.gray)
                );

                embed.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (BanList.Type.NAME.equals(player)) {
            String reason = String.valueOf(BanList.Type.NAME.describeConstable());

            World world = player.getWorld();
            String worldName = world.getName();
            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();

            Embed embed = new Embed(Main.link);
            embed.setTts(false);
            try {
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Kick")
                        .addField("<:Players:1061006964773109781> Player", player.getName(), false)
                        .addField("Reason",  reason, false)
                        .setFooter(Main.name, "")
                        .setColor(Color.RED));
                embed.addEmbed(new Embed.EmbedObject()
                        .setTitle("Location")
                        .addField("<:server:1081578253657063565>", "World: " + worldName + " coordinates " + x + " " + y + " " + z, false)
                        .setColor(Color.gray)
                );

                embed.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    */