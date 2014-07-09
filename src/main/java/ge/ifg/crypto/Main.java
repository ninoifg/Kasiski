package ge.ifg.crypto;

import ge.ifg.crypto.kasiski.KasiskiWorker;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

	private static String FILE = "./data/example1.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(FILE);
		KasiskiWorker kasiski = new KasiskiWorker(file);
		kasiski.analize();
		int [][] a = kasiski.buildAlphabetTable();
		kasiski.findKey();
		List ll = kasiski.probKey();
		System.out.println(ll);
		
		System.out.println(kasiski.decode());
	}

}
