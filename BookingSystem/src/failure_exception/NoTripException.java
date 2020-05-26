package failure_exception;

/**
 * NoTripException will be thrown when there is no such trip for the search.
 * @author lijunyu
 *
 */
public class NoTripException extends Exception {

	public NoTripException() {
		super();
	}


	public NoTripException(String message) {
		super(message);
	}
	
}
