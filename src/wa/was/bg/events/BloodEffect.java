package wa.was.bg.events;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodEffect implements Listener {
	
	private JavaPlugin plugin;
	private boolean isValidWorld = false;
	
	public BloodEffect(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onAttack(EntityDamageByEntityEvent e) {
		try {
			if ( e.isCancelled() ) return;
			if ( e.getEntity().isValid() ) {
				List<String> validWorlds = plugin.getConfig().getStringList("valid-worlds");
				for ( String world : validWorlds ) {
					if ( e.getEntity().getWorld().getName() == world )
						isValidWorld = true;
				}
				if ( ! ( isValidWorld ) ) return;
				for( String tag : plugin.getConfig().getConfigurationSection("Entities").getKeys(false) ) {
					if ( EntityType.valueOf(tag.toUpperCase()) != null 
							&& Effect.valueOf(plugin.getConfig().getString("Entities."+tag+".type")) != null ) {
						// Entity Gore Effect
						EntityType entity = EntityType.valueOf(tag.toUpperCase());
						Effect type = Effect.valueOf(plugin.getConfig().getString("Entities."+tag+".type").toUpperCase());
						if ( e.getEntity().getType() == entity ) {
							e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), type, 
									plugin.getConfig().getInt("Entities."+tag+".id")); 
							return;
						}
					}
				}
				// Default gore type
				Effect type = Effect.valueOf(plugin.getConfig().getString("default-type").toUpperCase());
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), type, 
						plugin.getConfig().getInt("default-type")); 
				return;
			}
		} catch ( Exception exc ) {
			System.out.print(exc);
			return;
		}
	}
	
}