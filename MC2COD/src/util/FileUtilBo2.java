package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import datatypes.Brush;
import datatypes.Texture;

public class FileUtilBo2 {
	private File iFile;
	private String text = "";
	private boolean includeGrassBlock;
	private int blockSize;
	private boolean runCSGMerge;
	private ArrayList<Brush> bl = new ArrayList<Brush>();
	private BlockUtil bu;
	private boolean printCSGFailureInfo = false;
	
	/** Constructor for the FileUtilBo2 class
	 * @param	File to be parsed and used for conversion
	 * @param	boolean whether GrassBlocks should be generated as brushes or skipped
	 * @param	int the size of the blocks in the COD grid. 44 is ideal, others are untested
	 * @param	boolean whether the map should attempt to merge neighboring blocks of same type and texture (indev)
	 */
	public FileUtilBo2(File iFile,  boolean includeGrassBlock, int blockSize, boolean runCSGMerge) {
			this.iFile = iFile;
			this.includeGrassBlock = includeGrassBlock;
			this.blockSize = blockSize;
			this.runCSGMerge = runCSGMerge;
			this.bu = new BlockUtil(this.includeGrassBlock);
			
	}	
	
	/**
	 * Gets the file name passed into the object on creation
	 * @return		The name of the file
	 */
	public String getFileName() {
		return this.iFile.getName();
	}
	
	/** This function converts the input (.bo2) file into a list of brushes
	 * @return		String of COD formatted brushes.
	 */
	public String convertToCod() { //TODO error & null checking
		String returnString = "";
		int brushnum = 0;
		Texture caulk = new Texture();
		this.getTextFromFile();
		this.text = this.removeHeader();
		if (this.text.equals("invalid"))
			return "Invalid .bo2 file";
		
		Scanner scanner = new Scanner(this.text);	
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();  
			String[] strArr = line.split(",");
			int index = 0;
			int x = 0;
			int y = 0;
			int z = 0;
			String id = "";
			for (String s : strArr) { //TODO find better way to do this
				if (index == 0) {
					x = Integer.parseInt(s);
				}
				if (index == 1) {
					y = Integer.parseInt(s);
				}
				if (index == 2) {
					z = Integer.parseInt(s.substring(0,s.indexOf(':')));
					s = s.substring(s.indexOf(":") +1, s.length());
					id = s;
				}
				index++;
			}
			
			if (bu.getBlockPlaceable(id)) {	//if block should be placed	
				bl.add(new Brush(x,y,z,bu.getTexture(id),brushnum,blockSize,bu.getBlockType(id))); //arraylists maintain insertion order	
			} 
			else {
				System.out.println("Skipping block with ID: " + id);
			}
			brushnum++;
		}
		scanner.close();
		
		//----------------------------------------------------------------------
		//-------------------- CSG Merges Called from Here ---------------------
		//----------------------------------------------------------------------
		if (this.runCSGMerge) {
			bl = CSG.runCSGX(bl);
		}
		
		//----------------------------------------------------------------------
		//-------------------- brushes generated here --------------------------
		//----------------------------------------------------------------------
		int brushCount = 0;
		for (int i = 0; i < bl.size(); i++) {
			if (bl.get(i).getGenerateBlock()) {
				System.out.println("Generating datatypes.Brush " + brushCount);
				returnString += bl.get(i).genBrush();
				brushCount++;
			}	
		}
		return returnString;
	}
	
	/**
	 * Gets the text line by line from the classes .bo2 file and stores it in the field this.text
	 * 
	 */
	private void getTextFromFile() {
		try {
		      Scanner myReader = new Scanner(this.iFile);
		      while (myReader.hasNextLine()) {
		        this.text += myReader.nextLine() + "\n";
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * Removes the header from the text of the .bo2 file. The file is defied upon this objects creation.
	 * Text is stored in field variable this.text
	 * @return		The trimmed and formatted .bo2 file text, containing only block info
	 */
	private String removeHeader() {
		if (!this.text.isBlank() && this.text.contains("[DATA]")) {
			String tempText = this.text.substring(this.text.indexOf("[DATA]"), this.text.length());
			tempText = tempText.replace("[DATA]", "");
			return tempText.trim();
		}
		
		return "invalid";
	}	
}
