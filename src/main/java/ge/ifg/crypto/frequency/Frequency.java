package ge.ifg.crypto.frequency;

import ge.ifg.crypto.security.TestCases;

import java.util.HashMap;

public class Frequency extends TestCases {

	private HashMap<String, Integer> frequency;

	public double getFrequency(String str) {
		Integer freq = frequency.get(str);
		if (freq == null)
			return 0.01;
		return freq;
	}

	protected Frequency() {
		frequency = new HashMap<>();
	}

}
