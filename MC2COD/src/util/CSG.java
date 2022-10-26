package util;

import java.util.ArrayList;

import datatypes.Brush;
import datatypes.Texture;

public class CSG {
	//not to be instantiated
	
	public static ArrayList<Brush> runCSGX(ArrayList<Brush> brushList) {
		System.out.println("Running CSG Merge");
		int csgSizeX = 1;
		int csgStartX = -1;
		//Texture caulk = new Texture();
		String[] csgTexture = Texture.getEmptyBlock();
		String csgType = "";
		ArrayList<Brush> csgListX = new ArrayList<>(brushList);
		boolean doMergeX = false;
		//boolean doMergeZ = false;
		
		//==============================================================
		//--------------------------------------------------------------
		//--------------------- CSG MERGE X AXIS -----------------------
		//--------------------------------------------------------------
		//==============================================================
		
		for (Brush b : brushList) {
			csgSizeX = 1;
			csgStartX = b.getX();
			csgTexture = b.getTexture();	
			csgType = b.getType();
			if (b.getGenerateBlock()) {
				for (Brush b2 : brushList) {
					//CSG on X axis
					if (b2.getX() == (b.getX() + csgSizeX) && b2.getY() == b.getY() && b2.getZ() == b.getZ() && Texture.checkTextureEquality(csgTexture, b2.getTexture()) && b.getType() == b2.getType() && b2.getGenerateBlock()) {
						b.setGenerateBlock(false);
						b2.setGenerateBlock(false);								
						doMergeX = true;
						csgSizeX++;
					}
				}
			}
			if (doMergeX) {
				System.out.println("\tCreating brush of size " + csgSizeX);
				if (csgSizeX > 1) {					
					csgListX.add(new Brush((csgStartX+1), b.getY(), b.getZ(), ((csgStartX+1) + (csgSizeX-1)), b.getY(), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "X", (csgSizeX)));
					System.out.println("Merging Brush on X Axis");
				}
				else {
					csgListX.add(new Brush((csgStartX+1), b.getY(), b.getZ(), (b.getX() + csgSizeX), b.getY(), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "X", (csgSizeX)));
					System.out.println("Merging Brush on X Axis");
				}	
				doMergeX = false;
			}					
		}
		
		//==============================================================
		//--------------------------------------------------------------
		//--------------------- CSG MERGE Y AXIS -----------------------
		//--------------------------------------------------------------
		//==============================================================
				
		//Take from csgList (make it csgListX) and create a getter for Brush datatypes so we can compare start and end of brush.
		//if start and end are the same (length), then run regular csg checks.
		
		//TODO disable csg x for further testing on csg y
		
		/*boolean doMergeY = false;
		ArrayList<Brush> csgListY = new ArrayList<>(csgListX);
		for (Brush b : csgListX) {
			int csgSizeY = 1;
			int csgStartY = b.getY();
			csgTexture = b.getTexture();	
			csgType = b.getType();
			if (b.getGenerateBlock()) {
				for (Brush b2 : csgListX) {
					
					//CSG on Y axis //also checks for csgX size equality
					if (b2.getX() == b.getX() && b2.getY() == b.getY() && b2.getZ() == b.getZ() && Texture.checkTextureEquality(csgTexture, b2.getTexture()) && b.getType() == b2.getType() && b2.getGenerateBlock() && b.getCSGSizeX() == b2.getCSGSizeX()) {
						b.setGenerateBlock(false);
						b2.setGenerateBlock(false);								
						doMergeY = true;
						csgSizeY++;
					}
				}
			}
			if (doMergeY) {
				System.out.println("\tCreating brush of size " + csgSizeY);
				if (csgSizeY > 1) {					
					csgListY.add(new Brush((b.getX()+1), b.getY(), b.getZ(), ((b.getX()+1) + (b.getCSGSizeX()-1)), (b.getY()+1 + b.getCSGSizeY()), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "Y", (csgSizeY)));
					System.out.println("Merging Brush on Y Axis");
				}
				else {
					csgListY.add(new Brush((b.getX()+1), b.getY(), b.getZ(), ((b.getX()) + (b.getCSGSizeX()-1)), (b.getY() + b.getCSGSizeY()), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "Y", (csgSizeY)));
					//csgListY.add(new Brush((csgStartX+1), b.getY(), b.getZ(), (b.getX() + csgSizeX), b.getY(), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "Y", (csgSizeX)));
					System.out.println("Merging Brush on Y Axis");
				}	
				doMergeY = false;
			}					
		}*/
		
		
		
		for (Brush c : csgListX) {
			brushList.add(c);
		}
		
		return csgListX;
	}
}
