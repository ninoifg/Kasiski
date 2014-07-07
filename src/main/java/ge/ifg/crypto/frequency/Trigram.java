package ge.ifg.crypto.frequency;

public class Trigram extends Frequency {

	private static Trigram unigram = new Trigram();

	public static Integer STRING_LENGTH = 3;
	
	private Trigram() {

	}

	public static Trigram getInstance() {
		return unigram;
	}

	@Override
	public double getFrequency(String str) {
		assertLength(STRING_LENGTH, str);
		return super.getFrequency(str);
	}
}
