package ge.ifg.crypto;

import ge.ifg.crypto.kasiski.KasiskiWorker;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

	private static String FILE = "./data/example1.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(FILE);
		System.out.println(file.getAbsolutePath());
		KasiskiWorker kasiski = new KasiskiWorker(file);
		kasiski.analize();
		int [][] a = kasiski.buildTable();
		
		int sum =0;
		
//		for (int[] cs : a) {
//			int sm = 0;
//			for (int c : cs) {
//				sm+=c;
//				System.out.print(c);
//				System.out.print(" ");
//			}
//			sum += sm;
//			System.out.println(sm);
//		}

		System.out.println(kasiski.findKey());
		List ll = kasiski.probKey();
		for (Object object : ll) {

			System.out.println(object);
		}
	}

}
