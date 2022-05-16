package exception;

public class UserNotFoundException extends Exception {
	
	@Override
	public String getMessage() {
		return "The login information you have provided does not match any known record";
	}

}
