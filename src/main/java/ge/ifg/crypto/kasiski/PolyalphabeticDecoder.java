package ge.ifg.crypto.kasiski;

import ge.ifg.crypto.decoder.Decoder;


/**
 * 
 * @author nkhoriashvili
 * polialfabeturis gamshifravi
 *
 */
public class PolyalphabeticDecoder implements Decoder {

	@Override
	public String decode(String text, String key) {

		StringBuilder decoded = new StringBuilder("");
		int keyLength = key.length();
		for (int i = 0; i < text.length(); i++) {
			int tmp = (int) text.charAt(i) - (int) key.charAt(i % keyLength)
					+ (int) 'ა';
			if (tmp < 'ა')
				tmp += 33;
			decoded.append((char) tmp);
		}

		return decoded.toString();
	}

}
