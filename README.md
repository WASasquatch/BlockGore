[logo]: https://www.spigotmc.org/attachments/blockgore-png.220304/ "BlockGORE"
Dyanmically create custom blood effects for entities! 
**Spigot Version** 1.11 **Developer** WASasquatch

## Configuration

In BlockGORE we can customize the type of effect played when an entity is attacked, and the id the block corresponding to the color of the blood. 

You can play around with this for different blood effects or attack effects.

### **Currently the configuration allows:**

  - Setting default worlds the plugin is active in.
  - Default blood effects for all non-listed entities

### Entities

| Effect Rules                                                                             | Description                                                                          |
|:---------------------------------------------------------------------------------------- |:------------------------------------------------------------------------------------ |
| [EntityType](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/EntityType.html) | EntityType is the type of entity effected by this rule                               |
| [id](http://minecraft-ids.grahamedgecombe.com/)                                          | Block id of the effect color. You cannot use meta data.                              |
| [type](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html)                  | EffectType is the corresponding effect played when an entity is attacked.            |

It is important you follow YAML Configuration File rules. Do not use tabs, and follow the correct indentation shown below. 

```YAML
# Valid Worlds to Activate blockGORE
valid-worlds:
 - survival_world
# All Entities NOT defined below will receive this effect
default-id: 152
default-type: STEP_SOUND
# Custom Blood Effects
#  Zombie: <-- EntityType see: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/EntityType.html
#    id: <-- Block ID to use for Color Note: You cannot use meta IDs eg: 35:14
#    type: <-- Effect Type see: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html
Entities:
  Zombie:
    id: 199
    type: STEP_SOUND
  Skeleton:
    id: 1
    type: SMOKE
  Spider:
    id: 179
    type: STEP_SOUND
  Player:
    id: 152
    type: STEP_SOUND
```
