package failure_exception;


/**
 * MoreThanOneResultException will be thrown when there is more than one result from the searching.
 * @author lijunyu
 *
 */
public class MoreThanOneResultException extends Exception {
	public MoreThanOneResultException(){
		super();
	}
	
	public MoreThanOneResultException(String message){
		super(message);
	}
}
