package failure_exception;


/**
 * InsufficientPeopleException will be thrown when there is no efficient people for
 * the order.
 * @author lijunyu
 *
 */
public class InsufficientPeopleException extends Exception {
	public InsufficientPeopleException(){
		super();
	}
	
	public InsufficientPeopleException(String message){
		super(message);
	}
}
