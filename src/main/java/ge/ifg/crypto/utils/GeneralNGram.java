package ge.ifg.crypto.utils;

public class GeneralNGram implements Comparable<GeneralNGram> {

	public final int N;
	public final int gcd;
	public final int count;

	public GeneralNGram(int N, int gcd, int count) {
		super();
		this.N = N;
		this.gcd = gcd;
		this.count = count;
	}

	@Override
	public int compareTo(GeneralNGram o) {
		if (this.N > o.N)
			return 1;

		if (this.N < o.N)
			return -1;

		if (this.count > o.count) {
			return 1;
		}

		if (this.count > o.count) {
			return -1;
		}

		return 0;
	}

	@Override
	public String toString() {
		return "{\n\tN : " + N + ", \n\tgcd : " + gcd + ", \n\tcount : " + count + "\n}\n";
	}
	
}
