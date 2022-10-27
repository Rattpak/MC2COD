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
		ArrayList<Brush> csgList = new ArrayList<>(brushList);
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
				System.out.println("\tCreating brush of size " + csgSizeX + " on X axis");
				if (csgSizeX > 1) {					
					csgList.add(new Brush((csgStartX+1), b.getY(), b.getZ(), ((csgStartX+1) + (csgSizeX-1)), b.getY(), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "X", (csgSizeX)));
				}
				else {
					System.out.println("CSGX Error?");
					csgList.add(new Brush((csgStartX+1), b.getY(), b.getZ(), (b.getX() + csgSizeX), b.getY(), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "X", (csgSizeX)));
				}	
				doMergeX = false;
			}					
			
		}
		
		
		//==============================================================
		//--------------------------------------------------------------
		//--------------------- CSG MERGE Y AXIS -----------------------
		//--------------------------------------------------------------
		//==============================================================
		//Merge blocks that are still to be used in the brushList
		
		boolean doMergeY = false;
		//ArrayList<Brush> csgListY = new ArrayList<>(csgList);
		for (Brush b : brushList) {
			int csgSizeY = 1;
			int csgStartY = b.getY();
			csgTexture = b.getTexture();	
			csgType = b.getType();
			if (b.getGenerateBlock()) {
				for (Brush b2 : brushList) {
					//CSG on Y axis
					if (b2.getX() == b.getX() && b2.getY() == (b.getY() + csgSizeY) && b2.getZ() == b.getZ() && Texture.checkTextureEquality(csgTexture, b2.getTexture()) && b.getType() == b2.getType() && b2.getGenerateBlock()) {
						b.setGenerateBlock(false);
						b2.setGenerateBlock(false);								
						doMergeY = true;
						csgSizeY++;
					}
				}
			}
			if (doMergeY) {
				System.out.println("\tCreating brush of size " + csgSizeY + " on Y axis");
				if (csgSizeY > 1) {
					csgList.add(new Brush(b.getX(), (csgStartY), b.getZ(), b.getX(), ((csgStartY+1) + (csgSizeY-1)), b.getZ(), csgTexture, -2, 44, "CSG" + csgType + "Y", (csgSizeY+1)));
				}
				else {
					System.out.println("CSGY Error?");
					csgList.add(new Brush(b.getX(), (csgStartY+1), b.getZ(), b.getX(), (b.getY() + csgSizeY), b.getZ(), csgTexture, -1, 44, "CSG" + csgType + "Y", (csgSizeY)));
				}	
				doMergeY = false;
			}					
		}
		
		
		
		
		
		
		return csgList;
	}
}
