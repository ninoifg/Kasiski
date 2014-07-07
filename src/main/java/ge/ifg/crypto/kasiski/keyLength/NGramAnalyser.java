package ge.ifg.crypto.kasiski.keyLength;

import ge.ifg.crypto.utils.GeneralNGram;
import ge.ifg.crypto.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

		List<String> remove = new ArrayList<>();

		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() < 2) {
				remove.add(entry.getKey());
			}
		}

		for (String rm : remove) {
			map.remove(rm);
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

	private int analizeGCD(List<Integer> list) {
		int gcd = 0;

		Iterator<Integer> iterator = list.iterator();

		int prev = iterator.next();
		int next;

		while (iterator.hasNext()) {
			next = iterator.next();
			gcd = Utils.GCD(next - prev, gcd);
		}

		return gcd;
	}

	public void analyzeGCD(KeyLengthAnalyser analyser) {
		int gcd = 0;
		for (Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() > 1) {
				gcd = analizeGCD(list);
				if (gcd > 3) {
					analyser.add(new GeneralNGram(N, gcd, list.size()));
				}
			}
		}
	}

	@Override
	public String toString() {
		return map.toString();
	}
}
