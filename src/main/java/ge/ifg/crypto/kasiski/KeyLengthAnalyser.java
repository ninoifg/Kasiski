package ge.ifg.crypto.kasiski;

import ge.ifg.crypto.utils.GeneralNGram;
import ge.ifg.crypto.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KeyLengthAnalyser {

	private List<GeneralNGram> list;

	private int keyLength;

	public KeyLengthAnalyser() {
		this.list = new ArrayList<>();
		this.keyLength = -1;
	}

	public void add(GeneralNGram nGram) {
		list.add(nGram);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public int count() {
		return list.size();
	}

	public void analyze() {
		Collections.sort(list, new GeneralNGramComparator());

		int gcd = 0;

		for (GeneralNGram nGram : list) {
			int tmp = Utils.GCD(nGram.gcd, gcd);
			if (tmp >= 4) {
				gcd = tmp;
			}
		}
		
		this.keyLength = gcd;
		
	}

	public int getKeyLength() {
		if (keyLength == -1) {
			throw new RuntimeException("Not Analized");
		}
		return this.keyLength;
	}

	private class GeneralNGramComparator implements Comparator<GeneralNGram> {

		@Override
		public int compare(GeneralNGram o1, GeneralNGram o2) {
			return o2.compareTo(o1);
		}

	}
}
