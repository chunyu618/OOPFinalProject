package failure_exception;

/**
 * NoOrderException will be thrown when there is no such order for the search.
 * @author lijunyu
 *
 */
public class NoOrderException extends Exception {
	public NoOrderException() {
		super();
	}


	public NoOrderException(String message) {
		super(message);
	}
}
