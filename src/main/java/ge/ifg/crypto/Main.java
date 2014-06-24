package ge.ifg.crypto;

import ge.ifg.crypto.kasiski.KasiskiWorker;

import java.io.File;
import java.io.IOException;

public class Main {

	private static String FILE = "/data/ifg/test/example1.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(FILE);

		KasiskiWorker kasiski = new KasiskiWorker(file);
		kasiski.analize();

	}

}
