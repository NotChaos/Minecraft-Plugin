package Core.Events;

import Core.Main;
import Core.Sending.Embed;
import Core.Sending.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.ServerLoadEvent;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Core.Sending.Webhook.sendToWebhook;

public class Stop implements Listener {

    @EventHandler
    public void onServerStop(PluginDisableEvent event) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String date = now.format(dateFormatter);
        String time = now.format(timeFormatter);

        long timestamp = Instant.now().getEpochSecond();

        Embed webhook = new Embed(Main.link);
        webhook.setTts(false);
        webhook.addEmbed(new Embed.EmbedObject()
                .setTitle("Server stopped")
                .setColor(Color.RED)
                .addField("Date", date, false)
                .addField("Time", time, false)
                .addField("Time of crash", "<t:" + timestamp + ":R>", false)
                .setFooter(Main.name, "")
                .setColor(Color.RED));
        try {
            webhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendToWebhook(Main.link, "||@everyone||");
    }
}
