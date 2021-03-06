package ge.ifg.crypto.kasiski;

import ge.ifg.crypto.decoder.Decoder;
import ge.ifg.crypto.kasiski.keyLength.KeyLengthAnalyser;
import ge.ifg.crypto.kasiski.keyLength.NGramAnalyser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
/**
 * 
 * @author nkoriashvili
 * es aris kasiskis metodi.  poulobs gasagebis sigrdzes, gasagevs da gashifrafs teqst
 *
 */
public class KasiskiWorker {

	private String text = null;
	private String key = null;
	private List<Map<Character, Double>> probKey = null;
	private KeyLengthAnalyser analyser = new KeyLengthAnalyser();
	private int keyLength;
	private int[][] table;
	private Scanner scanner;
	private String encrepted;

	public KasiskiWorker(File file) throws IOException {
		this(new FileInputStream(file));
	}

	public KasiskiWorker(InputStream inputStream) throws IOException {
		this(IOUtils.toString(inputStream));
	}

	public KasiskiWorker(String text) throws IOException {
		this.text = text;
		analyser = new KeyLengthAnalyser();
		probKey = new ArrayList<>();
	}

	/**
	 *  aanalizebs text-s i sigrdzis tol ertmanetis tol stringebs shoris itvlis mandzils pulobs USG-s
	 *  da shemdgom poulobs gasagebis sigrdzes yvela matganis USG-s 
	 */
	public void analize() {

		if (this.text == null) {
			throw new NullPointerException("Text is not initialized");
		}

		for (int i = this.text.length() / 2 + 1; i > 2; i--) {
			NGramAnalyser nGramAnalyser = new NGramAnalyser(i);
			nGramAnalyser.analyze(this.text);
			nGramAnalyser.removeUnused();
			nGramAnalyser.analyzeGCD(analyser);
		}
		analyser.analyze();

		keyLength = analyser.getKeyLength();
	}

	/**
	 * aagebs cxrils da daitvlis simboloebs
	 */
	public int[][] buildAlphabetTable() {
		table = new int[keyLength][33];
		for (int i = 0; i < text.length(); i++) {
			table[i % keyLength][text.charAt(i) - 'ა']++;
		}
		return table;
	}

	/**
	 * gasagebis povna 
	 */
	public String findKey() {

		StringBuilder key = new StringBuilder("");

		for (int i = 0; i < keyLength; i++) {
			int mx = 0;
			for (int j = 1; j < 33; j++) {

				if (table[i][j] > table[i][mx]) {
					mx = j;
				}
			}
			key.append((char) ('ა' + mx));
		}

		this.key = key.toString();

		return this.key;
	}

	/**
	 * savaraudo gasagebebi
	 */
	public List<Map<Character, Double>> probKey() {
		int[] sum = new int[keyLength];

		for (int i = 0; i < keyLength; i++) {
			for (int j = 1; j < 33; j++) {
				sum[i] += table[i][j];
			}
		}

		for (int i = 0; i < keyLength; i++) {
			Map<Character, Double> help = new HashMap<>();
			for (int j = 0; j < 33; j++) {
				double p = table[i][j] * 100. / sum[i];

				if (p > 12.) {
					help.put((char) ('ა' + j), p);
				}
			}
			probKey.add(help);
		}
		return probKey;
	}

	
	private void setKey(String key) {
		this.key = key;
	}

	/**
	 * gashivra
	 */
	public String decode(Decoder decoder) {
		this.encrepted = decoder.decode(text, key);
		return this.encrepted;
	}

	/**
	 * gasagebis archeva 
	 */
	public void choose(InputStream sysin) {
		if (scanner == null)
			scanner = new Scanner(sysin);
		System.out.print("შემოიტანეთ გასაღები: ");
		setKey(scanner.next());
	}

	/**
	 * textis gamotana
	 */
	public String showEncriptedText() {
		System.out.println(this.encrepted);
		return this.encrepted;
	}
}
