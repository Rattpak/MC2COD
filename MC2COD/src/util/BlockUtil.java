package util;

import datatypes.Texture;

public class BlockUtil {
	private boolean includeGrassBlock;
	
	public BlockUtil(boolean includeGrassBlock) {
		this.includeGrassBlock = includeGrassBlock;
		
		System.out.println("BlockUtil Created");
	}
	
	// bottom, top, back, right, front, left
	public String[] getTexture(String id) {
		if (id.equals("3")) {
			return Texture.texture("dirt");
		}
		if (id.equals("1")) {
			return Texture.texture("stone");
		}
		if (id.equals("12")) {//sand
			return Texture.texture("sand");
		}
		if (id.equals("18.2")) {
			return Texture.texture("birch_leaves");
		}
		if (id.equals("161")) {
			return Texture.texture("acacia_leaves");
		}
		if (id.equals("161.1") || id.equals("161.5")) {
			return Texture.texture("dark_oak_leaves");
		}
		if (id.equals("18.3")) {
			return Texture.texture("jungle_leaves");
		}
		if (id.equals("5.5") || id.equals("125.5") || id.equals("126.5") || id.equals("164") || id.equals("126.13") || id.equals("191")) {
			return Texture.texture("dark_oak_planks");
		}
		if (id.equals("44.6") || id.equals("44.14") || id.equals("43.6") || id.equals("112") || id.equals("113")) {
			return Texture.texture("nether_bricks");
		}
		if (id.equals("44.15") || id.equals("44.7") || id.equals("43.7") || id.equals("155")) {
			return Texture.texture("quartz_block_side");
		}
		if (id.equals("17.1")) {	//spruce logs
			return Texture.texture("spruce_log_top", "spruce_log_top", "spruce_log");
		}
		if (id.equals("17")) {
			return Texture.texture("oak_log_top", "oak_log_top", "oak_log");
		}
		if (id.equals("17.2")) {
			return Texture.texture("birch_log_top", "birch_log_top", "birch_log");
		}
		if (id.equals("17.3")) {
			return Texture.texture("jungle_log_top", "jungle_log_top", "jungle_log");
		}
		if (id.equals("162") || id.equals("162.12")) {
			return Texture.texture("acacia_log_top", "acacia_log_top", "acacia_log");
		}
		if (id.equals("162.1")) {
			return Texture.texture("dark_oak_log_top", "dark_oak_log_top", "dark_oak_log");
		}
		if (id.equals("44.12") || id.equals("44.4") || id.equals("45") || id.equals("43.4")) {
			return Texture.texture("bricks");
		}
		if (id.equals("18.1") || id.equals("18.5")) { 	//spruce leaves
			return Texture.texture("spruce_leaves");
		}
		if (id.equals("5.1") || id.equals("125.1") || id.equals("126.1") || id.equals("134") || id.equals("126.9") || id.equals("188")) { //spruce plank texture
			return Texture.texture("spruce_planks");
		}
		if (id.equals("126.10") || id.equals("126.2") || id.equals("189") || id.equals("5.2")) {
			return Texture.texture("birch_planks");
		}
		if (id.equals("123")) { 	//redstone lamp off
			return Texture.texture("redstone_lamp");
		}
		if (id.equals("124")) { 	//redstone lamp on
			return Texture.texture("redstone_lamp_on");
		}
		if (id.equals("251")) { 	//white concrete
			return Texture.texture("white_concrete");
		}
		if (id.equals("4") || id.equals("44.3") || id.equals("44.11") || id.equals("43.3") || id.equals("139")) {	//cobblestone texture
			return Texture.texture("cobblestone");
		}
		if (id.equals("43.5") || id.equals("44.5") || id.equals("98") || id.equals("109") || id.contains("109.")   || id.equals("44.13")) {	//stonebrick texture
			return Texture.texture("stone_bricks");
		}
		if (id.equals("126.8") || id.equals("126") || id.equals("85") || id.equals("5")) {
			return Texture.texture("oak_planks");
		}
		if (id.equals("126.11") || id.equals("126.3") || id.equals("190")) {
			return Texture.texture("jungle_planks");
		}
		if (id.equals("126.12") || id.equals("126.4") || id.equals("192") || id.equals("5.4")) {
			return Texture.texture("acacia_planks");
		}
		if (id.equals("251.3")) {	//light blue concrete
			return Texture.texture("light_blue_concrete");
		}
		if (id.equals("251.4")) { //yellow concrete
			return Texture.texture("yellow_concrete");
		}
		if (id.equals("2")) {	//grass block 
			return Texture.texture("dirt", "grass_block_top", "grass_block_side");
		}
		if (id.equals("18") || id.equals("18.4") ) {	//oak leaves
			return Texture.texture("oak_leaves");
		}
		if (id.equals("251.7")) {
			return Texture.texture("gray_concrete");
		}
		if (id.equals("251.8")) {
			return Texture.texture("light_gray_concrete");
		}
		if (id.equals("251.14")) {
			return Texture.texture("red_concrete");
		}
		if (id.equals("35.4")) {
			return Texture.texture("yellow_wool");
		}
		if (id.equals("251.1")) {
			return Texture.texture("orange_concrete");
		}
		if (id.equals("251.15")) {
			return Texture.texture("black_concrete");
		}
		if (id.equals("251.11")) {
			return Texture.texture("blue_concrete");
		}
		if (id.equals("251.12")) {
			return Texture.texture("brown_concrete");
		}
		if (id.equals("251.9")) {
			return Texture.texture("cyan_concrete");
		}
		if (id.equals("251.13")) {
			return Texture.texture("green_concrete");
		}
		if (id.equals("251.5")) {
			return Texture.texture("lime_concrete");
		}
		if (id.equals("251.2")) {
			return Texture.texture("magenta_concrete");
		}
		if (id.equals("251.6")) {
			return Texture.texture("pink_concrete");
		}
		if (id.equals("251.10")) {
			return Texture.texture("purple_concrete");
		}
		if (id.equals("101")) {
			return Texture.texture("iron_bars");
		}
		if (id.equals("13")) {
			return Texture.texture("gravel");
		}
		if (id.equals("1.6")) {
			return Texture.texture("polished_andesite");
		}
		if (id.equals("1.4")) {
			return Texture.texture("polished_diorite");
		}
		if (id.equals("89")) {
			return Texture.texture("glowstone");
		}
		if (id.equals("102") || id.equals("20")) {
			return Texture.texture("glass");
		}
		if (id.equals("160") || id.equals("95")) {
			return Texture.texture("white_stained_glass");
		}
		if (id.equals("160.1") || id.equals("95.1")) {
			return Texture.texture("orange_stained_glass");
		}
		if (id.equals("160.2") || id.equals("95.2")) {
			return Texture.texture("magenta_stained_glass");
		}
		if (id.equals("160.3") || id.equals("95.3")) {
			return Texture.texture("light_blue_stained_glass");
		}
		if (id.equals("160.4") || id.equals("95.4")) {
			return Texture.texture("yellow_stained_glass");
		}
		if (id.equals("160.5") || id.equals("95.5")) {
			return Texture.texture("lime_stained_glass");
		}
		if (id.equals("160.6") || id.equals("95.6")) {
			return Texture.texture("pink_stained_glass");
		}
		if (id.equals("160.7") || id.equals("95.7")) {
			return Texture.texture("gray_stained_glass");
		}
		if (id.equals("160.8") || id.equals("95.8")) {
			return Texture.texture("light_gray_stained_glass");
		}
		if (id.equals("160.9") || id.equals("95.9")) {
			return Texture.texture("cyan_stained_glass");
		}
		if (id.equals("160.10") || id.equals("95.10")) {
			return Texture.texture("purple_stained_glass");
		}
		if (id.equals("160.11") || id.equals("95.11")) {
			return Texture.texture("blue_stained_glass");
		}
		if (id.equals("160.12") || id.equals("95.12")) {
			return Texture.texture("brown_stained_glass");
		}
		if (id.equals("160.13") || id.equals("95.13")) {
			return Texture.texture("green_stained_glass");
		}
		if (id.equals("160.14") || id.equals("95.14")) {
			return Texture.texture("red_stained_glass");
		}
		if (id.equals("160.15") || id.equals("95.15")) {
			return Texture.texture("black_stained_glass");
		}
		if (id.equals("155.2")) {
			return Texture.texture("quartz_pillar_top", "quartz_pillar_top", "quartz_pillar");
		}
		if (id.equals("155.1")) {
			return Texture.texture("chiseled_quartz_block");
		}
		if (id.equals("98.3") || id.equals("97.5")) {
			return Texture.texture("chiseled_stone_bricks");
		}
		if (id.equals("43.9")) {
			return Texture.texture("sandstone_top");
		}
		if (id.equals("159.3")) {
			return Texture.texture("light_blue_terracotta");
		}
		if (id.equals("159.9")) {
			return Texture.texture("cyan_terracotta");
		}
		if (id.equals("42")) {
			return Texture.texture("iron_block");
		}
		if (id.equals("3.2")) {
			return Texture.texture("dirt", "podzol_top", "podzol_side");
		}
		if(id.equals("35")) {
			return Texture.texture("white_wool");
		}
		if(id.equals("35.1")) {
			return Texture.texture("orange_wool");
		}
		if(id.equals("35.2")) {
			return Texture.texture("magenta_wool");
		}
		if (id.equals("35.3")) {
			return Texture.texture("light_blue_wool");
		}
		if (id.equals("35.4")) {
			return Texture.texture("yello_wool");
		}
		if (id.equals("35.5")) {
			return Texture.texture("lime_wool");
		}
		if (id.equals("35.6")) {
			return Texture.texture("pink_wool");
		}
		if (id.equals("35.7")) {
			return Texture.texture("gray_wool");
		}
		if (id.equals("35.8")) {
			return Texture.texture("light_gray_wool");
		}
		if (id.equals("35.9")) {
			return Texture.texture("cyan_wool");
		}
		if (id.equals("35.10")) {
			return Texture.texture("purple_wool");
		}
		if (id.equals("35.11")) {
			return Texture.texture("blue_wool");
		}
		if (id.equals("35.12")) {
			return Texture.texture("brown_wool");
		}
		if (id.equals("35.13")) {
			return Texture.texture("green_wool");
		}
		if (id.equals("35.14")) {
			return Texture.texture("red_wool");
		}
		if (id.equals("35.15")) {
			return Texture.texture("black_wool");
		}
		//Glazed Terracotta
		if (id.equals("235")) {
			return Texture.texture("white_glazed_terracotta");
		}
		if (id.equals("236")) {
			return Texture.texture("orange_glazed_terracotta");
		}
		if (id.equals("237")) {
			return Texture.texture("magenta_glazed_terracotta");
		}
		if (id.equals("238")) {
			return Texture.texture("light_blue_glazed_terracotta");
		}
		if (id.equals("239")) {
			return Texture.texture("yellow_glazed_terracotta");
		}
		if (id.equals("240")) {
			return Texture.texture("lime_glazed_terracotta");
		}
		if (id.equals("241")) {
			return Texture.texture("pink_glazed_terracotta");
		}
		if (id.equals("242")) {
			return Texture.texture("gray_glazed_terracotta");
		}
		if (id.equals("243")) {
			return Texture.texture("light_gray_glazed_terracotta");
		}
		if (id.equals("244")) {
			return Texture.texture("cyan_glazed_terracotta");
		}
		if (id.equals("245")) {
			return Texture.texture("purple_glazed_terracotta");
		}
		if (id.equals("246")) {
			return Texture.texture("blue_glazed_terracotta");
		}
		if (id.equals("247")) {
			return Texture.texture("brown_glazed_terracotta");
		}
		if (id.equals("248")) {
			return Texture.texture("green_glazed_terracotta");
		}
		if (id.equals("249")) {
			return Texture.texture("red_glazed_terracotta");
		}
		if (id.equals("250")) {
			return Texture.texture("black_glazed_terracotta");
		}
		//terracotta
		if (id.equals("159")) { 	
			return Texture.texture("white_terracotta");
		}
		if (id.equals("159.1")) { 	
			return Texture.texture("orange_terracotta");
		}
		if (id.equals("159.2")) { 	
			return Texture.texture("magenta_terracotta");
		}
		if (id.equals("159.3")) { 	
			return Texture.texture("light_blue_terracotta");
		}
		if (id.equals("159.4")) { 	
			return Texture.texture("yellow_terracotta");
		}
		if (id.equals("159.5")) { 	
			return Texture.texture("lime_terracotta");
		}
		if (id.equals("138")) {
			return Texture.texture("blue_glazed_terracotta"); //BEACON TEMP TEXTURE
		}
		if (id.equals("159.6")) { 	
			return Texture.texture("pink_terracotta");
		}
		if (id.equals("159.7")) { 	
			return Texture.texture("gray_terracotta");
		}
		if (id.equals("159.8")) { 
			return Texture.texture("light_gray_terracotta");
		}
		if (id.equals("159.9")) { 
			return Texture.texture("cyan_terracotta");
		}
		if (id.equals("159.10")) { 
			return Texture.texture("purple_terracotta");
		}
		if (id.equals("159.11")) { 
			return Texture.texture("blue_terracotta");
		}
		if (id.equals("159.12")) { 
			return Texture.texture("brown_terracotta");
		}
		if (id.equals("159.13")) { 
			return Texture.texture("green_terracotta");
		}
		if (id.equals("159.14")) { 
			return Texture.texture("red_terracotta");
		}
		if (id.equals("159.15")) { 
			return Texture.texture("black_terracotta");
		}
		if (id.equals("80")) {
			return Texture.texture("snow");
		}
		if (id.equals("162") ) { //acacia log wood
			return Texture.texture("acacia_log");
		}
		if (id.equals("162.1") ) { //dark oak log wood
			return Texture.texture("dark_oak_log");
		}
		if (id.contains(".") && id.substring(0, id.length() - 1).equals("162.1") ) {	//rest of dark oak log wood
			return Texture.texture("dark_oak_log");
		}
		if (id.equals("58")) { 
			return Texture.texture("oak_planks");//String bottom, String top, String back, String right, String front, String left
		}
		
		
		return Texture.texture("caulk"); //default
	}
	
	
	public boolean getBlockPlaceable(String id) {
		if (id.equals("156")) { //quartz stair 
			return false;
		}
		if (id.equals("131")) { //tripwire hook
			return false;
		}
		if (id.equals("132")) { //tripwire
			return false;
		}
		if (id.equals("31.1")) {	//grass (not the block)
			return false;
		}
		if (id.equals("38.8")) { 	//Oxeye Daisy
			return false;
		}
		if (id.equals("66") || id.equals("66.1") || id.equals("66.2") || id.equals("66.3") || id.equals("66.4") || id.equals("66.5") || id.equals("66.6") || id.equals("66.7") || id.equals("66.8") || id.equals("66.9")) {		//rail
			return false;
		}
		if (id.equals("38") || id.equals("38.1") || id.equals("38.2") || id.equals("38.3") || id.equals("38.4") || id.equals("38.5") || id.equals("38.6") || id.equals("38.7")) {		//other flowers
			return false;
		}
		if (id.equals("37")) {		//Dandelion
			return false;
		}
		if (id.equals("93") || id.equals("94") || id.equals("149") || id.equals("150")) {		//redstone repeater and comparator
			return false;
		}
		if (id.equals("194")) {	//Birch Door Block
			return false;
		}
		if (id.equals("166")) {	//barriers
			return false;
		}
		if (id.equals("71")) {		//Iron Door Block
			return false;
		}
		if (id.equals("28") || id.equals("28.1")) {		//detector rail
			return false;
		}
		if (id.equals("27") || id.equals("27.1") || id.equals("27.2") || id.equals("27.3")) {		//powered rail
			return false;
		}
		if (id.equals("107")) {	//oak fence gate
			return false;
		}
		if (id.equals("77") || id.equals("77.1") || id.equals("77.4") || id.equals("77.2") || id.equals("77.3") || id.equals("77.5")) {		//stone button
			return false;
		}
		if (id.equals("143")) {	//wooden button
			return false;
		}
		if (id.equals("63")) {		//standing sign block
			return false;
		}
		if (id.equals("68") || id.equals("68.1") || id.equals("68.2") || id.equals("68.3") || id.equals("68.4") || id.equals("68.5")) {		//wall-mounted sign block
			return false;
		}
		if (id.equals("323") || id.equals("68.3")) {	//sign
			return false;
		}
		if (id.equals("69")) {		//lever
			return false;
		}
		if (id.equals("183")) { //spruce gate
			return false;
		}
		if (id.equals("83")) { //sugar canes
			return false;
		}
		if (id.equals("186")) {		//dark oak gate
			return false;		
		}
		if (id.equals("65")) { //ladder
			return false;
		}
		if (id.equals("78")) {
			return false;
		}
		if (id.contains(".") && id.substring(0, id.indexOf('.')).equals("78")) { //snow layer //any decimal variations of 78
			return false;
		}
		if (id.equals("30")) { //cobweb
			return false;
		}
<<<<<<< HEAD
		if (id.equals("8") || id.equals("9")) { //water & flowing water
			return false;
		}
		if (id.equals("10") || id.equals("11")) { //lava & flowing lava
=======
		if (id.equals("6") || id.equals("6.1") || id.equals("6.2") || id.equals("6.3") || id.equals("6.4") || id.equals("6.5")) { //sapplings
			return false;
		}
		if (id.equals("31") || id.equals("31.1") || id.equals("31.2") || id.equals("32")) { //deadbushes and ferns
>>>>>>> 3ac31f78f46c010b21d0b65c07bc249e8d2383d8
			return false;
		}
		if (!this.includeGrassBlock) {
			if (id.equals("2")) {
				return false;
			}
		}
		return true;
	}
	
	
	public String getBlockType(String id) {
		if (id.equals("44.5") || id.equals("44.3") || id.equals("126") || id.equals("126.1") || id.equals("126.3") 
				|| id.equals("126.4") || id.equals("126.5") || id.equals("126.2") || id.equals("44.6") || id.equals("44.4") || id.equals("44.7")) {	
			return "slab";
		}
		if (id.equals("44.13") || id.equals("44.11") || id.equals("126.8") || id.equals("126.9") || id.equals("126.10") || id.equals("126.11") 
				|| id.equals("126.12") || id.equals("126.13") || id.equals("126.10") || id.equals("44.14") || id.equals("44.12") || id.equals("44.15")) {
			return "uslab";
		}
		if (id.equals("102") || id.equals("101") || id.equals("160") ||  id.equals("160.1") ||  id.equals("160.2") ||  id.equals("160.3") ||  id.equals("160.4") || 
				 id.equals("160.5") ||  id.equals("160.6") ||  id.equals("160.7") ||  id.equals("160.8") || id.equals("160.9") || id.equals("160.10") || id.equals("160.11") || id.equals("160.12") || 
				 id.equals("160.13") || id.equals("160.14") || id.equals("160.15")) {
			return "pane";
		}
		if (id.equals("85") || id.equals("113") || id.equals("188") || id.equals("189") || id.equals("190") || id.equals("191") || id.equals("192")) {
			return "fence";
		}
		
		
 		return "full";
	}
}
