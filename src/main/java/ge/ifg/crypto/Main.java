package ge.ifg.crypto;

import ge.ifg.crypto.kasiski.KasiskiWorker;
import ge.ifg.crypto.kasiski.PolyalphabeticDecoder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	private static String FILE = "./data/example1.txt";

	public static void main(String[] args) throws IOException {
		
		File file = new File(FILE);
		KasiskiWorker kasiski = new KasiskiWorker(file);
		kasiski.analize();
		kasiski.buildAlphabetTable();
		kasiski.findKey();
		List<Map<Character, Double>> ll = kasiski.probKey();
		
		for ( Map<Character, Double> map: ll) {
			System.out.println(map);
		}

		kasiski.choose(System.in);
		
		kasiski.decode(new PolyalphabeticDecoder());
		
		kasiski.showEncriptedText();
	}

}
