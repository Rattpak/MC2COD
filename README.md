# MC2COD
Minecraft Map to Call of Duty Map Converter

## Usage
Run the .jar file by double-clicking or via command line.
### File Input
Choose the file you want to convert (.bo2 format)

### File Output
Choose the output folder for the converted .map file. You may lave it blank for same directory as input.
Use the Map Name input field to name the outputted .map file

### Settings
Choose the game to convert the map for 
- World at War
- Black Ops 3
Choose brush generation options
- Inlude Grass Blocks
  - Use this if your map is not heavy on grass blocks
- Auto CSG Merge
  - Merges neighboring blocks, first on X-axis, then Y-axis. (Z-axis not yet implemented)
  - It is recomended to use this to significantly reduce brush count
Map Options 
- Add Start Zone
  - Adds all boilerplate features to make a zombies level function such as skyboxes, volume_sun, umbra_volume, volume_fpstool, and the info_volume(start zone)
- Add Zombie Spawners
  - Adds 2 actor_spawner_zm_factory_zomb (zombie/dog), 2 riser locations (linked to start_zone), 2 dog spawners (linked to start_zone), 2 intermission points (end game camera), and all player spawns (solo and muliplayer)
Generate Map
 - Generated the .map file using the given settings


## Converting minecraft maps/schematics to .bo2 files
This program requires use of .bo2 minecraft format. The best tool to do this is with [cubical.xyz](https://beta.cubical.xyz/). Use File > Export File > Legacy Formats > Terrain Control bo2.

## Known Issues
