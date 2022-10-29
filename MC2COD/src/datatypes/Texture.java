package datatypes;

public class Texture {
	public static String[] texture(String texture) {
		String[] arr = {texture, texture, texture, texture, texture, texture};
		return arr;
	}
	
	public static String[] texture(String bottom, String top, String sides) {
		String[] arr = {bottom, top, sides, sides, sides, sides};
		return arr;
	}
	
	public static String[] texture(String bottom, String top, String back, String right, String front, String left) {
		String[] arr = {bottom, top, back, right, front, left};
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
