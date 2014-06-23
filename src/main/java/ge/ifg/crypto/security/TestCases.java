package ge.ifg.crypto.security;

public class TestCases {
	public void assertLength(Integer required, String string) {
		if (required != string.length()) {
			throw new IncorrectStringLengthException(required, string.length());
		}
	}
}
