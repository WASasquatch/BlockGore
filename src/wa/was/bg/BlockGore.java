package wa.was.bg;

import wa.was.bg.events.BloodEffect;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockGore extends JavaPlugin {
	
    @Override
    public void onEnable() {
    	createConfig();
    	getConfig();
    	getServer().getPluginManager().registerEvents(new BloodEffect(this), this);
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
