package ge.ifg.crypto.frequency;

public class Bigram extends Frequency {

	private static Bigram unigram = new Bigram();

	public static Integer STRING_LENGTH = 2;

	private Bigram() {

	}

	public static Bigram getInstance() {
		return unigram;
	}

	@Override
	public double getFrequency(String str) {
		assertLength(STRING_LENGTH, str);
		return super.getFrequency(str);
	}
}
