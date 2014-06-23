package ge.ifg.crypto.utils;

public class Utils {

	public static int GCD(int x, int y) {
		return y == 0 ? x : GCD(y, x % y);
	}
	
}
