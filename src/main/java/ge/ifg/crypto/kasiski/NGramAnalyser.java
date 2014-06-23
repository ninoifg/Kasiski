package ge.ifg.crypto.kasiski;

import ge.ifg.crypto.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NGramAnalyser {

	Map<String, List<Integer>> map;

	private final int N;

	public NGramAnalyser(int N) {
		this.N = N;

		map = new HashMap<>();
	}

	public NGramAnalyser(int N, String text) {
		this(N);
		analyze(text);
	}

	public void analyze(String text) {
		String ngram;

		for (int i = 0; i < text.length() - N; i++) {
			ngram = text.substring(i, i + N);

			List<Integer> tmp = map.get(ngram);

			if (tmp == null) {
				tmp = new ArrayList<>();
				map.put(ngram, tmp);
			}
			tmp.add(i);
		}
	}

	public void removeUnused() {
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() < 2) {
				map.remove(entry.getKey());
			}
		}
	}

	public int old_count() {
		int count = 0;
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() > 1) {
				count++;
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
		return count;
	}

	public int count() {
		return (int) map.entrySet().stream().filter(entry -> entry.getValue().size() > 1).count();
	}

	private int analizeGCD() {
		int gcd = 0;
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
		return gcd;
	}

	public int getGCD() {

		return getGCD();
	}
}
