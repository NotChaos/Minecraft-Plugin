package Core.Sending;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static final Logger logger = Logger.getLogger("Minecraft");
    private static FileHandler fileHandler;

    public static void setup(Plugin plugin) {
        File logsFolder = new File(plugin.getDataFolder(), "logs");
        if (!logsFolder.exists()) {
            logsFolder.mkdirs();
        }

        try {
            fileHandler = new FileHandler(logsFolder.getPath() + File.separator + "log_" + dateFormat.format(new Date()) + ".log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        logger.log(Level.INFO, message);
    }

    public static void close() {
        if (fileHandler != null) {
            fileHandler.close();
        }
    }
}
