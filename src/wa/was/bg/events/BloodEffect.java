package wa.was.bg.events;

import org.bukkit.Effect;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodEffect implements Listener {
	
	private JavaPlugin plugin;
	
	public BloodEffect(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onAttack(EntityDamageByEntityEvent e) {
		try {
			if ( e.isCancelled() ) return;
			if ( e.getEntity().isValid() ) {
				for( String tag : plugin.getConfig().getConfigurationSection("Entities").getKeys(false) ) {
					if ( EntityType.valueOf(tag.toUpperCase()) != null 
							&& Effect.valueOf(plugin.getConfig().getString("Entities."+tag+".type")) != null ) {
						EntityType entity = EntityType.valueOf(tag.toUpperCase());
						Effect type = Effect.valueOf(plugin.getConfig().getString("Entities."+tag+".type"));
						if ( e.getEntity().getType() == entity ) {
							e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), type, 
									plugin.getConfig().getInt("Entities."+tag+".id")); 
							return;
						}
					}
				}
				// Default gore type
				Effect type = Effect.valueOf(plugin.getConfig().getString("default-type"));
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