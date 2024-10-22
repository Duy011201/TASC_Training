package Assignment.exception;

public class HandleServiceException extends Exception {
	public HandleServiceException(String message) {
		super(message);
	}

	public HandleServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
