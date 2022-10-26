package util;

import datatypes.Texture;

public class BlockUtil {
	private boolean includeGrassBlock;
	
	public BlockUtil(boolean includeGrassBlock) {
		this.includeGrassBlock = includeGrassBlock;
		
		System.out.println("TextureUtil Created");
	}
	
	// bottom, top, back, right, front, left
	public String[] getTexture(String id) {
		if (id.equals("3")) {
			return new Texture("dirt").getTexture();
		}
		if (id.equals("1")) {
			return new Texture("stone").getTexture();
		}
		if (id.equals("18.2")) {
			return new Texture("birch_leaves").getTexture();
		}
		if (id.equals("161")) {
			return new Texture("acacia_leaves").getTexture();
		}
		if (id.equals("161.1") || id.equals("161.5")) {
			return new Texture("dark_oak_leaves").getTexture();
		}
		if (id.equals("18.3")) {
			return new Texture("jungle_leaves").getTexture();
		}
		if (id.equals("5.5") || id.equals("125.5") || id.equals("126.5") || id.equals("164") || id.equals("126.13") || id.equals("191")) {
			return new Texture("dark_oak_planks").getTexture();
		}
		if (id.equals("44.6") || id.equals("44.14") || id.equals("43.6") || id.equals("112") || id.equals("113")) {
			return new Texture("nether_bricks").getTexture();
		}
		if (id.equals("44.15") || id.equals("44.7") || id.equals("43.7") || id.equals("155")) {
			return new Texture("quartz_block_side").getTexture();
		}
		if (id.equals("17.1")) {	//spruce logs
			return new Texture("spruce_log_top", "spruce_log_top", "spruce_log").getTexture();
		}
		if (id.equals("17")) {
			return new Texture("oak_log_top", "oak_log_top", "oak_log").getTexture();
		}
		if (id.equals("17.2")) {
			return new Texture("birch_log_top", "birch_log_top", "birch_log").getTexture();
		}
		if (id.equals("17.3")) {
			return new Texture("jungle_log_top", "jungle_log_top", "jungle_log").getTexture();
		}
		if (id.equals("162") || id.equals("162.12")) {
			return new Texture("acacia_log_top", "acacia_log_top", "acacia_log").getTexture();
		}
		if (id.equals("162.1")) {
			return new Texture("dark_oak_log_top", "dark_oak_log_top", "dark_oak_log").getTexture();
		}
		if (id.equals("44.12") || id.equals("44.4") || id.equals("45") || id.equals("43.4")) {
			return new Texture("bricks").getTexture();
		}
		if (id.equals("18.1") || id.equals("18.5")) { 	//spruce leaves
			return new Texture("spruce_leaves").getTexture();
		}
		if (id.equals("5.1") || id.equals("125.1") || id.equals("126.1") || id.equals("134") || id.equals("126.9") || id.equals("188")) { //spruce plank texture
			return new Texture("spruce_planks").getTexture();
		}
		if (id.equals("126.10") || id.equals("126.2") || id.equals("189")) {
			return new Texture("birch_planks").getTexture();
		}
		if (id.equals("123")) { 	//redstone lamp off
			return new Texture("redstone_lamp").getTexture();
		}
		if (id.equals("124")) { 	//redstone lamp on
			return new Texture("redstone_lamp_on").getTexture();
		}
		if (id.equals("251")) { 	//white concrete
			return new Texture("white_concrete").getTexture();
		}
		if (id.equals("4") || id.equals("44.3") || id.equals("44.11") || id.equals("43.3") || id.equals("139")) {	//cobblestone texture
			return new Texture("cobblestone").getTexture();
		}
		if (id.equals("43.5") || id.equals("44.5") || id.equals("98") || id.equals("109") || id.contains("109.")   || id.equals("44.13")) {	//stonebrick texture
			return new Texture("stone_bricks").getTexture();
		}
		if (id.equals("126.8") || id.equals("126") || id.equals("85") || id.equals("5")) {
			return new Texture("oak_planks").getTexture();
		}
		if (id.equals("126.11") || id.equals("126.3") || id.equals("190")) {
			return new Texture("jungle_planks").getTexture();
		}
		if (id.equals("126.12") || id.equals("126.4") || id.equals("192")) {
			return new Texture("acacia_planks").getTexture();
		}
		if (id.equals("251.3")) {	//light blue concrete
			return new Texture("light_blue_concrete").getTexture();
		}
		if (id.equals("251.4")) { //yellow concrete
			return new Texture("yellow_concrete").getTexture();
		}
		if (id.equals("2")) {	//grass block 
			return new Texture("dirt", "grass_block_top", "grass_block_side").getTexture();
		}
		if (id.equals("159.8")) { //light gray terracotta
			return new Texture("light_gray_terracotta").getTexture();
		}
		if (id.equals("159")) { 	//white terracotta
			return new Texture("white_terracotta").getTexture();
		}
		if (id.equals("18") || id.equals("18.4") ) {	//oak leaves
			return new Texture("oak_leaves").getTexture();
		}
		if (id.equals("251.7")) {
			return new Texture("gray_concrete").getTexture();
		}
		if (id.equals("251.8")) {
			return new Texture("light_gray_concrete").getTexture();
		}
		if (id.equals("251.14")) {
			return new Texture("red_concrete").getTexture();
		}
		if (id.equals("35.4")) {
			return new Texture("yellow_wool").getTexture();
		}
		if (id.equals("251.1")) {
			return new Texture("orange_concrete").getTexture();
		}
		if (id.equals("251.15")) {
			return new Texture("black_concrete").getTexture();
		}
		if (id.equals("251.11")) {
			return new Texture("blue_concrete").getTexture();
		}
		if (id.equals("251.12")) {
			return new Texture("brown_concrete").getTexture();
		}
		if (id.equals("251.9")) {
			return new Texture("cyan_concrete").getTexture();
		}
		if (id.equals("251.13")) {
			return new Texture("green_concrete").getTexture();
		}
		if (id.equals("251.5")) {
			return new Texture("lime_concrete").getTexture();
		}
		if (id.equals("251.2")) {
			return new Texture("magenta_concrete").getTexture();
		}
		if (id.equals("251.6")) {
			return new Texture("pink_concrete").getTexture();
		}
		if (id.equals("251.10")) {
			return new Texture("purple_concrete").getTexture();
		}
		if (id.equals("101")) {
			return new Texture("iron_bars").getTexture();
		}
		if (id.equals("13")) {
			return new Texture("gravel").getTexture();
		}
		if (id.equals("1.6")) {
			return new Texture("polished_andesite").getTexture();
		}
		if (id.equals("1.4")) {
			return new Texture("polished_diorite").getTexture();
		}
		if (id.equals("89")) {
			return new Texture("glowstone").getTexture();
		}
		if (id.equals("102") || id.equals("20")) {
			return new Texture("glass").getTexture();
		}
		if (id.equals("160") || id.equals("95")) {
			return new Texture("white_stained_glass").getTexture();
		}
		if (id.equals("160.1") || id.equals("95.1")) {
			return new Texture("orange_stained_glass").getTexture();
		}
		if (id.equals("160.2") || id.equals("95.2")) {
			return new Texture("magenta_stained_glass").getTexture();
		}
		if (id.equals("160.3") || id.equals("95.3")) {
			return new Texture("light_blue_stained_glass").getTexture();
		}
		if (id.equals("160.4") || id.equals("95.4")) {
			return new Texture("yellow_stained_glass").getTexture();
		}
		if (id.equals("160.5") || id.equals("95.5")) {
			return new Texture("lime_stained_glass").getTexture();
		}
		if (id.equals("160.6") || id.equals("95.6")) {
			return new Texture("pink_stained_glass").getTexture();
		}
		if (id.equals("160.7") || id.equals("95.7")) {
			return new Texture("gray_stained_glass").getTexture();
		}
		if (id.equals("160.8") || id.equals("95.8")) {
			return new Texture("light_gray_stained_glass").getTexture();
		}
		if (id.equals("160.9") || id.equals("95.9")) {
			return new Texture("cyan_stained_glass").getTexture();
		}
		if (id.equals("160.10") || id.equals("95.10")) {
			return new Texture("purple_stained_glass").getTexture();
		}
		if (id.equals("160.11") || id.equals("95.11")) {
			return new Texture("blue_stained_glass").getTexture();
		}
		if (id.equals("160.12") || id.equals("95.12")) {
			return new Texture("brown_stained_glass").getTexture();
		}
		if (id.equals("160.13") || id.equals("95.13")) {
			return new Texture("green_stained_glass").getTexture();
		}
		if (id.equals("160.14") || id.equals("95.14")) {
			return new Texture("red_stained_glass").getTexture();
		}
		if (id.equals("160.15") || id.equals("95.15")) {
			return new Texture("black_stained_glass").getTexture();
		}
		if (id.equals("155.2")) {
			return new Texture("quartz_pillar_top", "quartz_pillar_top", "quartz_pillar").getTexture();
		}
		if (id.equals("155.1")) {
			return new Texture("chiseled_quartz_block").getTexture();
		}
		if (id.equals("98.3") || id.equals("97.5")) {
			return new Texture("chiseled_stone_bricks").getTexture();
		}
		if (id.equals("43.9")) {
			return new Texture("sandstone_top").getTexture();
		}
		if (id.equals("159.3")) {
			return new Texture("light_blue_terracotta").getTexture();
		}
		if (id.equals("159.9")) {
			return new Texture("cyan_terracotta").getTexture();
		}
		if (id.equals("42")) {
			return new Texture("iron_block").getTexture();
		}
		if (id.equals("3.2")) {
			return new Texture("dirt", "podzol_top", "podzol_side").getTexture();
		}
		if(id.equals("35")) {
			return new Texture("white_wool").getTexture();
		}
		if(id.equals("35.1")) {
			return new Texture("orange_wool").getTexture();
		}
		if(id.equals("35.2")) {
			return new Texture("magenta_wool").getTexture();
		}
		if (id.equals("35.3")) {
			return new Texture("light_blue_wool").getTexture();
		}
		if (id.equals("35.4")) {
			return new Texture("yello_wool").getTexture();
		}
		if (id.equals("35.5")) {
			return new Texture("lime_wool").getTexture();
		}
		if (id.equals("35.6")) {
			return new Texture("pink_wool").getTexture();
		}
		if (id.equals("35.7")) {
			return new Texture("gray_wool").getTexture();
		}
		if (id.equals("35.8")) {
			return new Texture("light_gray_wool").getTexture();
		}
		if (id.equals("35.9")) {
			return new Texture("cyan_wool").getTexture();
		}
		if (id.equals("35.10")) {
			return new Texture("purple_wool").getTexture();
		}
		if (id.equals("35.11")) {
			return new Texture("blue_wool").getTexture();
		}
		if (id.equals("35.12")) {
			return new Texture("brown_wool").getTexture();
		}
		if (id.equals("35.13")) {
			return new Texture("green_wool").getTexture();
		}
		if (id.equals("35.14")) {
			return new Texture("red_wool").getTexture();
		}
		if (id.equals("35.15")) {
			return new Texture("black_wool").getTexture();
		}
		
		
		return new Texture("caulk").getTexture(); //default
	}
	
	
	public boolean getBlockPlaceable(String id) {
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
		if (id.equals("186")) {		//dark oak gate
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
