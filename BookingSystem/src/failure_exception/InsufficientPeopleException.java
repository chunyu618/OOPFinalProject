package failure_exception;


public class InsufficientPeopleException extends Exception {
	public InsufficientPeopleException(){
		super();
	}
	
	public InsufficientPeopleException(String message){
		super(message);
	}
}
