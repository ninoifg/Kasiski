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
		
		File file = new File(FILE);	//failis shemotana
		KasiskiWorker kasiski = new KasiskiWorker(file); //kasistran samusha
		kasiski.analize();	//gaanalizeba datvla gasagebis sigrdzis
		kasiski.buildAlphabetTable(); // gasagebis sapovnelat cxrilis ageba
		kasiski.findKey();//gasagebis povna
		List<Map<Character, Double>> ll = kasiski.probKey(); //savaraudo gasagebebi
		
		for ( Map<Character, Double> map: ll) {
			System.out.println(map);
		}

		kasiski.choose(System.in); //archeva gasagebis
		
		kasiski.decode(new PolyalphabeticDecoder()); //gashifvra
		
		kasiski.showEncriptedText(); //bechvda
	}

}
