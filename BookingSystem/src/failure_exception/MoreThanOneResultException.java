package failure_exception;

public class MoreThanOneResultException extends Exception {
	public MoreThanOneResultException(){
		super();
	}
	
	public MoreThanOneResultException(String message){
		super(message);
	}
}
