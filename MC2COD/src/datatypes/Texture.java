package datatypes;

public class Texture {
	private String bottom;
	private String top;
	private String back;
	private String right;
	private String front;
	private String left;
	
	
	/**
	 * Single texture constructor
	 */
	public Texture() {
		
	}
	
	public Texture(String texture) {
		this.bottom = texture;
		this.top = texture;
		this.back = texture;
		this.right = texture;
		this.front = texture;
		this.left = texture;
	}
	
	public Texture(String bottom, String top, String sides) {
		this.bottom = bottom;
		this.top = top;
		this.back = sides;
		this.right = sides;
		this.front = sides;
		this.left = sides;
	}
	
	/**
	 * 6 sided constructor
	 */
	public Texture(String bottom, String top, String back, String right, String front, String left) {
		this.bottom = bottom;
		this.top = top;
		this.back = back;
		this.right = right;
		this.front = front;
		this.left = left;
	}
	
	public String[] getTexture() {
		String[] arr = {this.bottom, this.top, this.back, this.right, this.front, this.left};
		return arr;
	}
	
	public String[] getCaulkedBlock() {
		String[] arr = {"caulk", "caulk", "caulk", "caulk", "caulk", "caulk"};
		return arr;
	}
	
	public static String[] getEmptyBlock() {
		String[] arr = {"caulk", "caulk", "caulk", "caulk", "caulk", "caulk"};
		return arr;
	}
	
	public static boolean checkTextureEquality(String[] s1, String[] s2)
    {
        if (s1 == s2) {
            return true;
        }
 
        if (s1 == null || s2 == null) {
            return false;
        }
 
        int n = s1.length;
        if (n != s2.length) {
            return false;
        }
 
        for (int i = 0; i < n; i++)
        {
            if (!s1[i].equals(s2[i])) {
                return false;
            }
        }
 
        return true;
    }
}
