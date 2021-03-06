package filasik.assistant;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Assistant extends JavaPlugin implements Listener {
    //#todo - inlude bstats
    String currentVersionString = "0.2.2b";

    private void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onEnable() {
        getLogger().info("---------------------------");
        getLogger().info("Assistant config loaded!");
        getLogger().info("Your version: " + currentVersionString);
        getLogger().info("Assistant has been enabled!");
        getLogger().info("---------------------------");
        this.getCommand("assistant").setExecutor(new CommandAssistant());
        this.getCommand("web").setExecutor(new CommandWebsite());
        this.getCommand("discord").setExecutor(new CommandDiscord());
        this.getCommand("teamspeak").setExecutor(new CommandTeamspeak());
        this.getCommand("facebook").setExecutor(new CommandFacebook());
        this.getCommand("ip").setExecutor(new CommandIP());
        loadConfiguration();
        updateChecker.start();
    }

    @Override
    public void onDisable() {
        getLogger().info("Assistant has been disabled!");
    }

    private Thread updateChecker = new Thread() {
        @Override
        public void run() {
            URL url = null;
            try {
                url = new URL("https://api.spigotmc.org/legacy/update.php?resource=71410");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            URLConnection conn = null;
            try {
                assert url != null;
                conn = url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                assert conn != null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                //#todo - doesnt work - allways shows the else condition
                if (reader.readLine().equals(currentVersionString)) {
                    System.out.println("[ServerAssistant] We are UP TO DATE! No updates available. Your version: " + currentVersionString);
                } else {
                    System.out.println("[ServerAssistant] There is an update! Download it at https://www.spigotmc.org/resources/server-assistant.71410/");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
