package ge.ifg.crypto.kasiski;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

		for (int i = this.text.length(); i > 3; i--) {
			NGramAnalyser nGramAnalyser = new NGramAnalyser(i);
			nGramAnalyser.analyze(this.text);
			nGramAnalyser.removeUnused();
		}

		

	}
}
