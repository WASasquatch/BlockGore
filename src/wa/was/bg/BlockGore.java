package wa.was.bg;

import wa.was.bg.events.BloodEffect;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockGore extends JavaPlugin {
	
	public static JavaPlugin plugin;
	public static FileConfiguration config;

	public BlockGore() {
    	plugin = this;
    	
	}
	
    @Override
    public void onEnable() {
    	createConfig();
    	config = getConfig();
    	getServer().getPluginManager().registerEvents(new BloodEffect(), plugin);
    }
    
    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating it for you!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
	
}
