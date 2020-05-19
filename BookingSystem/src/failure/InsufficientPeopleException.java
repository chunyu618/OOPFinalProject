package failure;

public class InsufficientPeopleException extends Exception {
	public InsufficientPeopleException(){
		super();
	}
	
	public InsufficientPeopleException(String message){
		super(message);
	}
}
