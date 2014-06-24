package ge.ifg.crypto.kasiski;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class KasiskiWorker {

	private String text = null;

	private KeyLengthAnalyser analyser = new KeyLengthAnalyser();

	private int keyLength;

	int[][] table;

	public KasiskiWorker(File file) throws IOException {
		this(new FileInputStream(file));
	}

	public KasiskiWorker(InputStream inputStream) throws IOException {
		this(IOUtils.toString(inputStream));
	}

	public KasiskiWorker(String text) throws IOException {
		this.text = text;
		analyser = new KeyLengthAnalyser();
	}

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

	public int[][] buildTable() {
		table = new int[33][5];
		for (int i = 0; i < text.length(); i++) {

		}
		return table;
	}
}
