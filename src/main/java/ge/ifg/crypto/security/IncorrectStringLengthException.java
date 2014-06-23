package ge.ifg.crypto.security;

public class IncorrectStringLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// public IncorrectStringLengthException() {
	// super("Incorrect String Length");
	// }

	public IncorrectStringLengthException(Integer required, Integer stringLength) {
		super("Incorrect String Length: required " + required + ", length: "
				+ stringLength);
	}

}
