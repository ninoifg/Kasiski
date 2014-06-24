package ge.ifg.crypto.kasiski;

import ge.ifg.crypto.utils.GeneralNGram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class KasiskiWorker {

	private String text = null;

	public KasiskiWorker(File file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);

		this.text = IOUtils.toString(inputStream);
	}

	public KasiskiWorker(String text) throws IOException {
		this.text = text;
	}

	public void analize() {

		if (this.text == null) {
			throw new NullPointerException("Text is not initialized");
		}

		KeyLengthAnalyser analyser = new KeyLengthAnalyser();

		for (int i = this.text.length() / 2 + 1; i > 2; i--) {
			NGramAnalyser nGramAnalyser = new NGramAnalyser(i);
			nGramAnalyser.analyze(this.text);
			nGramAnalyser.removeUnused();
			nGramAnalyser.analyzeGCD(analyser);
		}
		analyser.analyze();

		System.out.println(analyser.getKeyLength());
	}

}
