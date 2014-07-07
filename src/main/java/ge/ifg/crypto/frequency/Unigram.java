package ge.ifg.crypto.frequency;

public class Unigram extends Frequency {

	private static Unigram unigram = new Unigram();

	public static Integer STRING_LENGTH = 1;
	
	private Unigram() {

	}

	public static Unigram getInstance() {
		return unigram;
	}

	@Override
	public double getFrequency(String str) {
		assertLength(STRING_LENGTH, str);
		return super.getFrequency(str);
	}
}
