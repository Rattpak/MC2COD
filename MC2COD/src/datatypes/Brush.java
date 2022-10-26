package datatypes;

public class Brush {

	private int x;
	private int y;
	private int z;
	private int x2;	//csg merge only
	private int y2;	//csg merge only
	private int z2;	//csg merge only
	private int csgSizeX;
	private int csgSizeY;
	private String[] texture;
	private int brushNum;
	private int bs;
	private String type;
	private String genString = "";
	private boolean generateBlock = true;


	/**
	 * Standard brush
	 * @param x
	 * @param y
	 * @param z
	 * @param texture
	 * @param brushNum
	 * @param bs
	 * @param type
	 */
	public Brush(int x, int y , int z, String[] texture, int brushNum, int bs, String type) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.texture = texture;
		this.brushNum = brushNum;
		this.bs = bs;
		this.type = type;
	}
	
	/**
	 * CSG X Merge Only
	 * @param x
	 * @param y
	 * @param z
	 * @param x2
	 * @param y2
	 * @param z2
	 * @param texture
	 * @param brushNum
	 * @param bs
	 * @param type
	 */
	public Brush(int x, int y, int z, int x2, int y2, int z2, String[] texture, int brushNum, int bs, String type, int csgSizeX) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		this.texture = texture;
		this.brushNum = brushNum;
		this.bs = bs;
		this.type = type;
		this.csgSizeX = csgSizeX;
	}
	
	/**
	 * CSG XY Merge Only
	 * @param x
	 * @param y
	 * @param z
	 * @param x2
	 * @param y2
	 * @param z2
	 * @param texture
	 * @param brushNum
	 * @param bs
	 * @param type
	 */
	public Brush(int x, int y, int z, int x2, int y2, int z2, String[] texture, int brushNum, int bs, String type, int csgSizeX, int csgSizeY) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		this.texture = texture;
		this.brushNum = brushNum;
		this.bs = bs;
		this.type = type;
		this.csgSizeX = csgSizeX;
		this.csgSizeY = csgSizeY;
	}
	
	public void setCSGSizeX(int size) {
		this.csgSizeX = size;
	}
	
	public int getCSGSizeX() {
		return this.csgSizeX;
	}
	
	public int getCSGSizeY() {
		return this.csgSizeY;
	}
	
	/**
	 * CSG Flag
	 * Used to determine if this block should be generated after CSG
	 * @return true or false
	 */
	public boolean getGenerateBlock() {
		return this.generateBlock;
	}
	
	/**
	 * CSG Flag
	 * Used to tell CSG Functions whether to generate this block
	 * @param s true or false
	 */
	public void setGenerateBlock(boolean s) {
		this.generateBlock = s;
	}

	/**
	 * Gets the texture string array
	 * @return
	 */
	public String[] getTexture() {
		return texture;
	}
	
	/**
	 * get x coordinate of this brush
	 * @return (int) x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * get x coordinate of this brush
	 * @return (int) y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * get x coordinate of this brush
	 * @return (int) z coordinate
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Gets the number of the brush in generation. Useful for debugging
	 * @return
	 */
	public int getBrushNum() {
		return brushNum;
	}
	
	/**
	 * Determines the type of the block
	 * "full", "slab", "uslab", "pane", "fence", "CSGfull"
	 * @return String type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Sets the string of the brush to add to the map file
	 * @param n
	 */
	public void setGenString(String n) {
		this.genString = n;
	}
	
	/**
	 * Generates the current brush based on its type and CSG settings
	 * @return String of the brush to add to the map file
	 */
	public String genBrush() {

		if (this.type.equals("full")) {
			return genBlockBrush();
		}
		if (this.type.equals("slab")) {
			return genSlabBrush();
		}
		if (this.type.equals("uslab")) {
			return genUSlabBrush();
		}
		if (this.type.equals("pane")) {
			return genPane();
		}
		if (this.type.equals("fence")) {
			return genFence(); //returns 3 brushes in 1 string
		}
		if (this.type.equals("CSGfullX")) {
			return genCSGBlockBrushX();
		}
		if (this.type.equals("CSGfullY")) {
			return genCSGBlockBrushY();
		}

		return "";
	}
	
	//full block
	private String genBlockBrush() {
		
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ bs*x +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ bs*x +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*(z+1))-8) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[4] +append; 			//line 5
		genString += "\n ( "+ bs*x +" "+ ((bs*(y+1))-8) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ (-16+(bs*y)) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ (-16+(bs*y)) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		return genString;
	}
		
	private String genCSGBlockBrushX()  {
		
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ bs*x +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ bs*x +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*(z+1))-8) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[4] +append; 			//line 5
		genString += "\n ( "+ bs*(x-1) +" "+ ((bs*(y+1))-8) +" "+ bs*(z+1) +" ) ( "+ bs*(x-1) +" "+ (-16+(bs*y)) +" "+ bs*(z+1) +" ) ( "+ bs*(x-1) +" "+ (-16+(bs*y)) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		return genString;
	}
	
	//Implement CSGX arithmetic into CSGY merge?
	private String genCSGBlockBrushY()  {
		
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) ( "+ bs*x +" "+ bs*(y-1) +" "+ ((bs*z)) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ bs*x +" "+ (bs*(y-1)+4) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ (bs*(y-1)+4) +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ (bs*(y-1)+4) +" "+ bs*(z+1) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ bs*x +" "+ bs*(y-1) +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ bs*(x+1) +" "+bs*(y-1) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*(y-1) +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*(x+(csgSizeX-1)) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ bs*(x+1) +" "+ bs*(x+(csgSizeY)) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(x+(csgSizeY)) +" "+ bs*(z+1) +" ) ( "+ bs*x +" "+ bs*(x+(csgSizeY)) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[4] +append; 			//line 5
		genString += "\n ( "+ bs*(x-1) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ bs*(x-1) +" "+ bs*(y-1) +" "+ bs*(z+1) +" ) ( "+ bs*(x-1) +" "+ bs*(y-1) +" "+ ((bs*(z+1))-8) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		return genString;
	}
	
	//lower slab
	private String genSlabBrush() {
		int ss = (int)bs/2; //slab size
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ (bs*(x)+8) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) ( "+ (bs*x) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ (bs*(x)+2) +" "+ bs*y +" "+ ((bs*(z))+ss) +" ) ( "+ (bs*(x)+2) +" "+ (bs*(y)+8) +" "+ ((bs*(z))+ss) +" ) ( "+ ((bs*(x))+10) +" "+ (bs*(y)+8) +" "+ ((bs*(z))+ss) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y)+8) +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ (bs*(x)+8) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[4] + append; 			//line 5
		genString += "\n ( "+ (bs*x) +" "+ (bs*(y)+8) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		
		return genString;
	}
	
	//upper slab
	private String genUSlabBrush() {
		int ss = (int)bs/2; //slab size
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ (bs*(x+1)+16) +" "+ (bs*(y+1)+20) +" "+ (bs*(z)+ss) +" ) ( "+ (bs*(x)-4) +" "+ (bs*(y+1)+20) +" "+ (bs*(z)+ss) +" ) ( "+ (bs*(x)-4) +" "+ bs*y +" "+ (bs*(z)+ss) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ (bs*x) +" "+ bs*y +" "+ (bs*(z+1)) +" ) ( "+ (bs*(x)+2) +" "+ (bs*(y+1)+20) +" "+ (bs*(z+1)) +" ) ( "+ ((bs*(x))+10) +" "+ (bs*(y+1)+20) +" "+ (bs*(z+1)) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ (bs*(x+1)+20) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+1) +" "+ (bs*(y)-16) +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y+1)+4) +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y+1)+4) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ (bs*(x+1)-4) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ ((bs*x)-24) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ ((bs*x)-24) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[4] + append; 			//line 5
		genString += "\n ( "+ (bs*x) +" "+ (bs*(y+1)+20) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		
		return genString;
	}
	
	private String genPane() {
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ ((bs*x)+24) +" "+ bs*(y+1) +" "+ bs*z +" ) ( "+ ((bs*x)+20) +" "+ bs*(y+1) +" "+ bs*z +" ) ( "+ ((bs*x)+20) +" "+ bs*y +" "+ bs*z +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ ((bs*x)+20) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+20) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+24) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ ((bs*x)+20) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+24) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+24) +" "+ bs*y +" "+ bs*z +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ ((bs*x)+24) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+24) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+24) +" "+ bs*(y+1) +" "+ bs*z +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ ((bs*x)+24) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+20) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+20) +" "+ bs*(y+1) +" "+ bs*z +" ) " + this.texture[4] + append; 			//line 5
		genString += "\n ( "+ ((bs*x)+20) +" "+ bs*(y+1) +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+20) +" "+ bs*y +" "+ bs*(z+1) +" ) ( "+ ((bs*x)+20) +" "+ bs*y +" "+ bs*z +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		return genString;
	}
	
	private String genFence() {
		String append =  " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		//top bar-----------------------------------------
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))+17) +		" "+ (bs*(z+1)-11) +	" ) ( "+ (bs*x) +" "+ ((bs*(y+1))+17) +" "+ (bs*(z+1)-11) +					" ) ( "+ (bs*x) +" "+ ((bs*y)+1) +					" "+ (bs*(z+1)-11) +				" ) " + this.texture[1] + append;						//line 1
		genString += "\n ( "+ ((bs*x)-4) +" "+ ((bs*y)-19.25) +				" "+ (bs*(z+1)-2.5) +	" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-3.25) +" "+ (bs*(z+1)-2.5) +			" ) ( "+ ((bs*(x+1))+16) +" "+ ((bs*(y+1))-3.25) +	" "+ (bs*(z+1)-2.5) +			" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*x) +" "+ ((bs*(y+1))-24.75) +				" "+ (bs*(z+1)-39.5) +" ) ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))-24.75) +" "+ (bs*(z+1)-39.5) +	" ) ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))-24.75) +	" "+ (bs*(z+1)-43.5) +				" ) " + this.texture[1] + append; 					//line 3
		genString += "\n ( "+ (bs*(x+1)) +" "+ bs*y +						" "+ (bs*(z+1)-40.5) +" ) ( "+ (bs*(x+1)) +" "+ (bs*(y+1)+16) +" "+ (bs*(z+1)-40.5) +			" ) ( "+ (bs*(x+1)) +" "+ (bs*(y+1)+16) +			" "+ (bs*(z+1)-44.5) +				" ) " + this.texture[1] + append; 				//line 4
		genString += "\n ( "+ ((bs*(x+1))+16) +" "+ ((bs*(y+1))-19.25) +	" "+ (bs*(z+1)-42.5) +" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-19.25) +" "+ (bs*(z+1)-42.5) +		" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-19.25) +		" "+ (bs*(z+1)-46.5) +				" ) " + this.texture[1] + append; 			//line 5
		genString += "\n ( "+ (bs*x) +" "+ (bs*(y+1)+16) +					" "+ (bs*(z+1)-40.5) +" ) ( "+ (bs*x) +" "+ (bs*y) +" "+ (bs*(z+1)-40.5) +						" ) ( "+ (bs*x) +" "+ (bs*y) +						" "+ (bs*(z+1)-44.5) +				" ) " + this.texture[1] + append;	//line 6
		genString += "\n}\n";

		//bottom bar-----------------------------------------
		genString +="// brush " + this.brushNum + ".1\n";
		genString += "{";
		genString += "\n ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))+17) +		" "+ (bs*(z+1)-27.5) +	" ) ( "+ (bs*x) +" "+ ((bs*(y+1))+17) +" "+ (bs*(z+1)-27.5) +					" ) ( "+ (bs*x) +" "+ ((bs*y)+1) +				" "+ (bs*(z+1)-27.5) +	" ) " + this.texture[1] + append;						//line 1
		genString += "\n ( "+ ((bs*x)-4) +" "+ ((bs*y)-19.25) +				" "+ (bs*(z+1)-19) +	" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-3.25) +" "+ (bs*(z+1)-19) +			" ) ( "+ ((bs*(x+1))+16) +" "+ ((bs*(y+1))-3.25) +	" "+ (bs*(z+1)-19) +	" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*x) +" "+ ((bs*(y+1))-24.75) +				" "+ (bs*(z+1)-56) +" ) ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))-24.75) +" "+ (bs*(z+1)-56) +	" ) ( "+ ((bs*(x+1))+20) +" "+ ((bs*(y+1))-24.75) +				" "+ (bs*(z+1)-60) +	" ) " + this.texture[1] + append; 					//line 3
		genString += "\n ( "+ (bs*(x+1)) +" "+ bs*y +						" "+ (bs*(z+1)-57) +" ) ( "+ (bs*(x+1)) +" "+ (bs*(y+1)+16) +" "+ (bs*(z+1)-57) +			" ) ( "+ (bs*(x+1)) +" "+ (bs*(y+1)+16) +						" "+ (bs*(z+1)-61) +	" ) " + this.texture[1] + append; 				//line 4
		genString += "\n ( "+ ((bs*(x+1))+16) +" "+ ((bs*(y+1))-19.25) +	" "+ (bs*(z+1)-59) +" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-19.25) +" "+ (bs*(z+1)-59) +		" ) ( "+ ((bs*x)-4) +" "+ ((bs*(y+1))-19.25) +					" "+ (bs*(z+1)-63) +	" ) " + this.texture[1] + append; 			//line 5
		genString += "\n ( "+ (bs*x) +" "+ (bs*(y+1)+16) +					" "+ (bs*(z+1)-57) +" ) ( "+ (bs*x) +" "+ (bs*y) +" "+ (bs*(z+1)-57) +						" ) ( "+ (bs*x) +" "+ (bs*y) +									" "+ (bs*(z+1)-61) +	" ) " + this.texture[1] + append;	//line 6
		genString += "\n}\n";
		
		//post-----------------------------------------
		genString +="// brush " + this.brushNum + ".2\n";
		genString += "{";
		genString += "\n ( "+ (bs*(x+1)+36) +" "+ (bs*(y+1)+17) +		" "+ (bs*z) +	  " ) ( "+ (bs*(x+1)-28) +" "+ (bs*(y+1)+17) +" "+ (bs*z) +				" ) ( "+ (bs*(x+1)-28) +" "+ (bs*(y+1)-43) +		" "+ (bs*z) +	" ) " + this.texture[1] + append;						//line 1
		genString += "\n ( "+ (bs*(x+1)-34) +" "+ ((bs*y)-19.25) +		" "+ (bs*(z+1)) + " ) ( "+ (bs*(x+1)-34) +" "+ ((bs*y)+40.75) +" "+ (bs*(z+1)) +		" ) ( "+ (bs*(x+1)+30) +" "+ ((bs*y)+40.75) +		" "+ (bs*(z+1)) +	" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*(x+1)-28.5) +" "+ ((bs*y)+16.5) +		" "+ ((bs*z)-12) +" ) ( "+ (bs*(x+1)+35.5) +" "+ ((bs*y)+16.5) +" "+ ((bs*z)-12) +		" ) ( "+ (bs*(x+1)+35.5) +" "+ ((bs*y)+16.5) +		" "+ ((bs*z)-16) +	" ) " + this.texture[1] + append; 					//line 3
		genString += "\n ( "+ (bs*(x+1)-17) +" "+ ((bs*y)-2.25) +		" "+ ((bs*z)-13) +" ) ( "+ (bs*(x+1)-17) +" "+ ((bs*y)+57.75) +" "+ ((bs*z)-13) +		" ) ( "+ (bs*(x+1)-17) +" "+ ((bs*y)+57.75) +		" "+ ((bs*z)-17) +	" ) " + this.texture[1] + append; 				//line 4
		genString += "\n ( "+ (bs*(x+1)+32) +" "+ ((bs*y)+27.5) +		" "+ ((bs*z)-15) +" ) ( "+ (bs*(x+1)-32) +" "+ ((bs*y)+27.5) +" "+ ((bs*z)-15) +		" ) ( "+ (bs*(x+1)-32) +" "+ ((bs*y)+27.5) +		" "+ ((bs*z)-19) +	" ) " + this.texture[1] + append; 			//line 5
		genString += "\n ( "+ (bs*(x+1)-28) +" "+ (bs*(y+1)+16) +		" "+ ((bs*z)-13) +" ) ( "+ (bs*(x+1)-28) +" "+ (bs*y) +" "+ ((bs*z)-13) +				" ) ( "+ (bs*(x+1)-28) +" "+ (bs*y) +				" "+ ((bs*z)-17) +	" ) " + this.texture[1] + append;	//line 6
		genString += "\n}\n";
		return genString;
	}	
	
	private String genStair0() {
		//-------------The bottom slab--------------
		int ss = (int)bs/2; //slab size
		String append = " " + bs + " -" + bs + " 0 0 180 0 lightmap_gray 16384 16384 16 -32 0 0";
		genString +="// brush " + this.brushNum + "\n";
		genString += "{";
		genString += "\n ( "+ (bs*(x)+8) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) ( "+ (bs*x) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[0] + append;						//line 1
		genString += "\n ( "+ (bs*(x)+2) +" "+ bs*y +" "+ ((bs*(z))+ss) +" ) ( "+ (bs*(x)+2) +" "+ (bs*(y)+8) +" "+ ((bs*(z))+ss) +" ) ( "+ ((bs*(x))+10) +" "+ (bs*(y)+8) +" "+ ((bs*(z))+ss) +" ) " + this.texture[1] + append;						//line 2
		genString += "\n ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[2] + append; 					//line 3
		genString += "\n ( "+ bs*(x+1) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y)+8) +" "+ ((bs*z)+8) +" ) ( "+ bs*(x+1) +" "+ (bs*(y)+8) +" "+ ((bs*z)) +" ) " + this.texture[3] + append; 				//line 4
		genString += "\n ( "+ (bs*(x)+8) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*(y+1) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*(y+1) +" "+ ((bs*z)) +" ) " + this.texture[4] + append; 			//line 5
		genString += "\n ( "+ (bs*x) +" "+ (bs*(y)+8) +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)+8) +" ) ( "+ (bs*x) +" "+ bs*y +" "+ ((bs*z)) +" ) " + this.texture[5] + append;	//line 6
		genString += "\n}\n";
		
		
		
		
		
		
		
		return genString;
	}
}
