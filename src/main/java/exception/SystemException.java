package exception;

public class SystemException extends Exception {
	
	@Override
	public String getMessage() {
		return "There was an interal error! Please try again later!";
	}
 
}
