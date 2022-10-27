package util;

public class MapGen {

	private String codMapHeader = "iwmap 4\r\n"
			+ "\"000_Global\" flags  active\r\n"
			+ "\"The Map\" flags \r\n"
			+ "// entity 0\r\n"
			+ "{\r\n"
			+ "\"classname\" \"worldspawn\"";
	private String brushes = "";
	private int game;
	private boolean addStartZone;
	private boolean addZomSpawns;
	
	/** Generates the map code using the given parameters.
	 * 
	 * @param brushes			The components of each Brush as a string. Use FileUtilBo2 to generate this string
	 * @param game				0 or 1, 0 represents Call of Duty: World at War. 1 represents Call of Duty: Black Ops III
	 * @param addStartZone		Determines whether to generate the start zone for the zombie map.
	 * @param addZomSpawns		Determines whether to generate the zombie and dog spawners for the map
	 */	
	public MapGen(String brushes, int game, boolean addStartZone, boolean addZomSpawns) {
		this.brushes = brushes;
		this.game = game;
		this.addStartZone = addStartZone;	//add functionality
		this.addZomSpawns = addZomSpawns;	//add functionality
	}
	
	public String generateMap() {
		if (this.game == 1) {//bo3
			String gen = getBo3Header();	//uses worldspawn classname
			if (this.addStartZone) {
				gen += getBo3Sky();			//uses worldspawn classname
			}
			gen += brushes + "\n}";			//uses worldspawn classname
			if (this.addZomSpawns) {
				gen += getBo3Spawners();	//uses *other* classnames
			}
			if (this.addStartZone) {
				gen += getBo3StartZone(); 	//uses *other* classnames
			}
			return gen;
		}
		if (this.game == 0) {
			String gen = codMapHeader + brushes + "\n}";
			return gen;
		}
		return "";
	}
	
	
	
	private static String getBo3Sky() {
		System.out.println("Generating Black Ops 3 Sky");
		return "// brush 0\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B41-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2744 6396 2292 ) ( -3768 6396 2292 ) ( -3768 2300 2292 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3736 2300 3444 ) ( -3736 6396 3444 ) ( -2712 6396 3444 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3768 2268 3412 ) ( -2744 2268 3412 ) ( -2744 2268 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -1688 2300 3444 ) ( -1688 6396 3444 ) ( -1688 6396 2420 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -5848 6396 3412 ) ( -5848 2300 3412 ) ( -5848 2300 2388 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -2744 2300 3412 ) ( -3768 2300 3412 ) ( -2744 2300 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ "}\r\n"
				+ "// brush 1\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B42-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2744 6396 2292 ) ( -3768 6396 2292 ) ( -3768 2300 2292 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3736 2300 3444 ) ( -3736 6396 3444 ) ( -2712 6396 3444 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3768 2268 3412 ) ( -2744 2268 3412 ) ( -2744 2268 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -2744 6428 3412 ) ( -3768 6428 3412 ) ( -3768 6428 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -5848 6396 3412 ) ( -5848 2300 3412 ) ( -5848 2300 2388 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -5816 2300 3348 ) ( -5816 6396 3348 ) ( -5816 2300 2324 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ "}\r\n"
				+ "// brush 2\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B43-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -3736 2300 3444 ) ( -3736 6396 3444 ) ( -2712 6396 3444 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3768 2268 3412 ) ( -2744 2268 3412 ) ( -2744 2268 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -1688 2300 3444 ) ( -1688 6396 3444 ) ( -1688 6396 2420 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -2744 6428 3412 ) ( -3768 6428 3412 ) ( -3768 6428 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -5848 6396 3412 ) ( -5848 2300 3412 ) ( -5848 2300 2388 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -3736 6396 3412 ) ( -3736 2300 3412 ) ( -2712 6396 3412 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ "}\r\n"
				+ "// brush 3\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B44-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2744 6396 2292 ) ( -3768 6396 2292 ) ( -3768 2300 2292 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3768 2268 3348 ) ( -2744 2268 3348 ) ( -2744 2268 2324 ) sky 16 16 -3768 -2324 0 0 lightmap_gray 16384 16384 -3768 -2324 0 0\r\n"
				+ " ( -1688 2300 3380 ) ( -1688 6396 3380 ) ( -1688 6396 2356 ) sky 16 16 4348 -2324 0 0 lightmap_gray 16384 16384 4348 -2324 0 0\r\n"
				+ " ( -2744 6428 3348 ) ( -3768 6428 3348 ) ( -3768 6428 2324 ) sky 16 16 -3768 -2324 0 0 lightmap_gray 16384 16384 -3768 -2324 0 0\r\n"
				+ " ( -5848 6396 3348 ) ( -5848 2300 3348 ) ( -5848 2300 2324 ) sky 16 16 4348 -2324 0 0 lightmap_gray 16384 16384 4348 -2324 0 0\r\n"
				+ " ( -3768 6396 2324 ) ( -2744 6396 2324 ) ( -3768 2300 2324 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ "}\r\n"
				+ "// brush 4\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B45-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2744 6396 2292 ) ( -3768 6396 2292 ) ( -3768 2300 2292 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3736 2300 3444 ) ( -3736 6396 3444 ) ( -2712 6396 3444 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3768 2268 3412 ) ( -2744 2268 3412 ) ( -2744 2268 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -1688 2300 3444 ) ( -1688 6396 3444 ) ( -1688 6396 2420 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -2744 6428 3412 ) ( -3768 6428 3412 ) ( -3768 6428 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -1720 6396 3380 ) ( -1720 2300 3380 ) ( -1720 6396 2356 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ "}\r\n"
				+ "// brush 5\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B46-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2744 6396 2292 ) ( -3768 6396 2292 ) ( -3768 2300 2292 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -3736 2300 3444 ) ( -3736 6396 3444 ) ( -2712 6396 3444 ) sky 16 16 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -1688 2300 3444 ) ( -1688 6396 3444 ) ( -1688 6396 2420 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -2744 6428 3412 ) ( -3768 6428 3412 ) ( -3768 6428 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ " ( -5848 6396 3412 ) ( -5848 2300 3412 ) ( -5848 2300 2388 ) sky 16 16 4348 -2388 0 0 lightmap_gray 16384 16384 4348 -2388 0 0\r\n"
				+ " ( -3768 6396 3412 ) ( -2744 6396 3412 ) ( -3768 6396 2388 ) sky 16 16 -3768 -2388 0 0 lightmap_gray 16384 16384 -3768 -2388 0 0\r\n"
				+ "}";
	}
	
	private static String getBo3Header() {
		System.out.println("Generating Black Ops 3 Map Header");
		return "iwmap 4\r\n"
				+ "\"script_startingnumber\" 0\r\n"
				+ "\"000_Global\" flags  active\r\n"
				+ "\"The Map\" flags expanded \r\n"
				+ "// entity 0\r\n"
				+ "{\r\n"
				+ "\"classname\" \"worldspawn\"\r\n"
				+ "\"fsi\" \"default\"\r\n"
				+ "\"gravity\" \"800\"\r\n"
				+ "\"lodbias\" \"default\"\r\n"
				+ "\"lutmaterial\" \"luts_t7_default\"\r\n"
				+ "\"numOmniShadowSlices\" \"24\"\r\n"
				+ "\"numSpotShadowSlices\" \"64\"\r\n"
				+ "\"sky_intensity_factor0\" \"1\"\r\n"
				+ "\"sky_intensity_factor1\" \"1\"\r\n"
				+ "\"state_alias_1\" \"State 1\"\r\n"
				+ "\"state_alias_2\" \"State 2\"\r\n"
				+ "\"state_alias_3\" \"State 3\"\r\n"
				+ "\"state_alias_4\" \"State 4\"";
	}
	
	private static String getBo3Spawners() {
		System.out.println("Generating Black Ops 3 Zombie Spawners");
		return "// entity 1\r\n"
				+ "{\r\n"
				+ "guid \"{753A4286-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"info_player_start\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5204 -448 2884\"\r\n"
				+ "}\r\n"
				+ "// entity 2\r\n"
				+ "{\r\n"
				+ "guid \"{753A4289-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"angles\" \"0 180 0\"\r\n"
				+ "\"origin\" \"-4628 192 2844\"\r\n"
				+ "\"script_noteworthy\" \"riser_location\"\r\n"
				+ "\"script_string\" \"find_flesh\"\r\n"
				+ "\"targetname\" \"start_zone_spawners\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 3\r\n"
				+ "{\r\n"
				+ "guid \"{753A428F-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"angles\" \"0 360 0\"\r\n"
				+ "\"origin\" \"-5780 192 2844\"\r\n"
				+ "\"script_noteworthy\" \"riser_location\"\r\n"
				+ "\"script_string\" \"find_flesh\"\r\n"
				+ "\"targetname\" \"start_zone_spawners\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 4\r\n"
				+ "{\r\n"
				+ "guid \"{753A4295-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5204 -384 2872\"\r\n"
				+ "\"radius\" \"2000\"\r\n"
				+ "\"script_int\" \"2000\"\r\n"
				+ "\"script_noteworthy\" \"start_room\"\r\n"
				+ "\"script_string\" \"zclassic_start_room zcleansed_start_room zgrief_start_room\"\r\n"
				+ "\"target\" \"initial_spawn_points\"\r\n"
				+ "\"targetname\" \"player_respawn_point\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 5\r\n"
				+ "{\r\n"
				+ "guid \"{753A4298-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 1 0\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5268 -256 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"2\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 6\r\n"
				+ "{\r\n"
				+ "guid \"{753A429B-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 0 1\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5268 -320 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 7\r\n"
				+ "{\r\n"
				+ "guid \"{753A429E-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 1 0\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5140 -256 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"2\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 8\r\n"
				+ "{\r\n"
				+ "guid \"{753A42A1-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 0 1\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5140 -320 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 9\r\n"
				+ "{\r\n"
				+ "guid \"{753A42A4-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 1 0\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5012 -256 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"2\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 10\r\n"
				+ "{\r\n"
				+ "guid \"{753A42A7-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 0 1\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5012 -320 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 11\r\n"
				+ "{\r\n"
				+ "guid \"{753A42AA-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 1 0\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5396 -256 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"2\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 12\r\n"
				+ "{\r\n"
				+ "guid \"{753A42AD-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"_color\" \"1 0 1\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5396 -320 2872\"\r\n"
				+ "\"radius\" \"32\"\r\n"
				+ "\"script_int\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"initial_spawn\"\r\n"
				+ "\"script_string\" \"zcleansed_start_room\"\r\n"
				+ "\"targetname\" \"initial_spawn_points\"\r\n"
				+ "}\r\n"
				+ "// entity 13\r\n"
				+ "{\r\n"
				+ "guid \"{753A42B0-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"origin\" \"-5204 0 2844\"\r\n"
				+ "\"script_noteworthy\" \"dog_location\"\r\n"
				+ "\"targetname\" \"start_zone_spawners\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 14\r\n"
				+ "{\r\n"
				+ "guid \"{753A42B3-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"origin\" \"-5268 -584 2948\"\r\n"
				+ "\"target\" \"intermission_b\"\r\n"
				+ "\"targetname\" \"intermission\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 15\r\n"
				+ "{\r\n"
				+ "guid \"{753A42B6-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"angles\" \"0 29.9999 0\"\r\n"
				+ "\"origin\" \"-5932 -32 2948\"\r\n"
				+ "\"targetname\" \"intermission_b\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 16\r\n"
				+ "{\r\n"
				+ "guid \"{753A42BB-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"actor_spawner_zm_factory_zombie\"\r\n"
				+ "\"ALERTONSPAWN\" \"0\"\r\n"
				+ "\"MAKEROOM\" \"1\"\r\n"
				+ "\"SCRIPT_FORCESPAWN\" \"1\"\r\n"
				+ "\"angles\" \"0 270 0\"\r\n"
				+ "\"count\" \"9999\"\r\n"
				+ "\"export\" \"1\"\r\n"
				+ "\"origin\" \"-5108 659 3052\"\r\n"
				+ "\"script_disable_bleeder\" \"1\"\r\n"
				+ "\"script_forcespawn\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"zombie_spawner\"\r\n"
				+ "\"SPAWNER\" \"1\"\r\n"
				+ "\"_color\" \"1 0.25 0\"\r\n"
				+ "\"engageMaxDist\" \"700\"\r\n"
				+ "\"engageMinDist\" \"250\"\r\n"
				+ "\"model\" \"c_zom_test_body1\"\r\n"
				+ "\"script_dropammo\" \"1\"\r\n"
				+ "\"sm_active_count_max\" \"3\"\r\n"
				+ "\"sm_active_count_min\" \"3\"\r\n"
				+ "\"spawnflags\" \"19\"\r\n"
				+ "}\r\n"
				+ "// entity 17\r\n"
				+ "{\r\n"
				+ "guid \"{970A69A6-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"script_struct\"\r\n"
				+ "\"origin\" \"-5160 200 2848\"\r\n"
				+ "\"script_noteworthy\" \"dog_location\"\r\n"
				+ "\"targetname\" \"start_zone_spawners\"\r\n"
				+ "\"_color\" \"1 0 0\"\r\n"
				+ "}\r\n"
				+ "// entity 18\r\n"
				+ "{\r\n"
				+ "guid \"{970A69A9-D4BC-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"actor_spawner_zm_factory_zombie_dog\"\r\n"
				+ "\"ALERTONSPAWN\" \"0\"\r\n"
				+ "\"MAKEROOM\" \"1\"\r\n"
				+ "\"angles\" \"0 90 0\"\r\n"
				+ "\"export\" \"3\"\r\n"
				+ "\"origin\" \"-5095.4 213.1 2847.9\"\r\n"
				+ "\"script_forcespawn\" \"1\"\r\n"
				+ "\"script_noteworthy\" \"zombie_dog_spawner\"\r\n"
				+ "\"targetname\" \"special_dog_spawner\"\r\n"
				+ "\"SPAWNER\" \"1\"\r\n"
				+ "\"_color\" \"1 0.25 0\"\r\n"
				+ "\"count\" \"1\"\r\n"
				+ "\"engageMaxDist\" \"768\"\r\n"
				+ "\"engageMinDist\" \"256\"\r\n"
				+ "\"model\" \"zombie_wolf\"\r\n"
				+ "\"script_dropammo\" \"1\"\r\n"
				+ "\"sm_active_count_max\" \"3\"\r\n"
				+ "\"sm_active_count_min\" \"3\"\r\n"
				+ "\"spawnflags\" \"3\"\r\n"
				+ "}";
	}
	
	private static String getBo3StartZone() {
		System.out.println("Generating Black Ops 3 Start Zone");
		return "// entity 1\r\n"
				+ "{\r\n"
				+ "guid \"{D5395B49-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"info_volume\"\r\n"
				+ "\"script_noteworthy\" \"player_volume\"\r\n"
				+ "\"target\" \"start_zone_spawners\"\r\n"
				+ "\"targetname\" \"start_zone\"\r\n"
				+ "// brush 0\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B48-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -2232 4860 2388 ) ( -2232 2812 2388 ) ( -2232 2812 2708 ) volume 64 64 6148 -2524 0 0 lightmap_gray 16384 16384 2303.5 -2679.5 0 0\r\n"
				+ " ( -3000 5756 2388 ) ( -5240 5756 2388 ) ( -5240 3708 2388 ) volume 64 64 -4016 -6148 0 0 lightmap_gray 16384 16384 -4016 -6148 0 0\r\n"
				+ " ( -3000 3708 2708 ) ( -5240 3708 2708 ) ( -5240 5756 2708 ) volume 64 64 -4016 -6148 0 0 lightmap_gray 16384 16384 -4016 -6148 0 0\r\n"
				+ " ( -2232 2812 2708 ) ( -2232 2812 2388 ) ( -4472 2812 2388 ) volume 64 64 -4016 -2524 0 0 lightmap_gray 16384 16384 -4016 -2524 0 0\r\n"
				+ " ( -5304 5884 2708 ) ( -5304 3836 2708 ) ( -5304 3836 2388 ) volume 64 64 6148 -2524 0 0 lightmap_gray 16384 16384 6148 -2524 0 0\r\n"
				+ " ( -5304 5884 2708 ) ( -5304 5884 2388 ) ( -3064 5884 2388 ) volume 64 64 -4016 -2524 0 0 lightmap_gray 16384 16384 -4016 -2524 0 0\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "// entity 2\r\n"
				+ "{\r\n"
				+ "guid \"{D5395B4C-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"volume_sun\"\r\n"
				+ "\"ssi\" \"default_day\"\r\n"
				+ "\"global_fill_color\" \"0 0 0\"\r\n"
				+ "\"global_fill_intensity\" \"1\"\r\n"
				+ "\"grid_density\" \"32\"\r\n"
				+ "\"respectLightLods\" \"1\"\r\n"
				+ "\"shadowBiasScale\" \"1\"\r\n"
				+ "\"shadowSplitDistance\" \"2000\"\r\n"
				+ "\"shadowVistaDetail\" \"1\"\r\n"
				+ "\"ssi1\" \"default_day\"\r\n"
				+ "\"streamLighting\" \"1\"\r\n"
				+ "// brush 0\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B4B-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -5816 2300 2324 ) ( -1720 2300 2324 ) ( -1720 6396 2324 ) sun_volume 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5816 6396 3284 ) ( -1720 6396 3284 ) ( -1720 2300 3284 ) sun_volume 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5816 2428 2388 ) ( -5816 2428 3412 ) ( -1720 2428 3412 ) sun_volume 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -1848 6396 2388 ) ( -1848 2300 2388 ) ( -1848 2300 3412 ) sun_volume 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ " ( -1720 6268 2388 ) ( -1720 6268 3412 ) ( -5816 6268 3412 ) sun_volume 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -5688 6396 3412 ) ( -5688 2300 3412 ) ( -5688 2300 2388 ) sun_volume 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "// entity 3\r\n"
				+ "{\r\n"
				+ "guid \"{D5395B4F-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"umbra_volume\"\r\n"
				+ "// brush 0\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B4E-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -5304 3580 2324 ) ( -3000 3580 2324 ) ( -3000 4860 2324 ) umbra_volume 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5304 4860 3220 ) ( -3000 4860 3220 ) ( -3000 3580 3220 ) umbra_volume 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5304 2556 2132 ) ( -5304 2556 2900 ) ( -3000 2556 2900 ) umbra_volume 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -1976 4860 2388 ) ( -1976 3580 2388 ) ( -1976 3580 3156 ) umbra_volume 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ " ( -3000 6140 2388 ) ( -3000 6140 3156 ) ( -5304 6140 3156 ) umbra_volume 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -5560 4860 3156 ) ( -5560 3580 3156 ) ( -5560 3580 2388 ) umbra_volume 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "// entity 4\r\n"
				+ "{\r\n"
				+ "guid \"{D5395B52-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ "\"classname\" \"volume_fpstool\"\r\n"
				+ "// brush 0\r\n"
				+ "{\r\n"
				+ " guid \"{D5395B51-D4B6-11EC-889C-E0D55E26EEFD}\"\r\n"
				+ " ( -5304 2812 2324 ) ( -3000 2812 2324 ) ( -3000 4860 2324 ) volume_fpstool 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5304 4860 3156 ) ( -3000 4860 3156 ) ( -3000 2812 3156 ) volume_fpstool 32 32 -3768 -4348 0 0 lightmap_gray 16384 16384 -3768 -4348 0 0\r\n"
				+ " ( -5304 2812 2388 ) ( -5304 2812 3156 ) ( -3000 2812 3156 ) volume_fpstool 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -2232 4604 2388 ) ( -2232 2556 2388 ) ( -2232 2556 3156 ) volume_fpstool 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ " ( -3000 5884 2388 ) ( -3000 5884 3156 ) ( -5304 5884 3156 ) volume_fpstool 32 32 -3768 -2452 0 0 lightmap_gray 16384 16384 -3768 -2452 0 0\r\n"
				+ " ( -5304 4860 3156 ) ( -5304 2812 3156 ) ( -5304 2812 2388 ) volume_fpstool 32 32 4348 -2452 0 0 lightmap_gray 16384 16384 4348 -2452 0 0\r\n"
				+ "}\r\n"
				+ "}";
	}
}