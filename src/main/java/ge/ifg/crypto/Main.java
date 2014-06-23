package ge.ifg.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import ge.ifg.crypto.frequency.Bigram;
import ge.ifg.crypto.frequency.Frequency;
import ge.ifg.crypto.frequency.Unigram;
import ge.ifg.crypto.kasiski.KasiskiWorker;

public class Main {

	private static String FILE = "/data/ifg/test/example1.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(FILE);
		
		KasiskiWorker kasiski = new KasiskiWorker(file);
		kasiski.analize();
		
	}

}
