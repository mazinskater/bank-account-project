package exception;

public class OverDraftException extends Exception{
	
	@Override 
	public String getMessage() {
		return "The ammount to be withdrawn is more the current account balance";
	}

}
