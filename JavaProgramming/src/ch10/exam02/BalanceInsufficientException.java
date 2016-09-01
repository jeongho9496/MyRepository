package ch10.exam02;

public class BalanceInsufficientException extends RuntimeException {
	public BalanceInsufficientException() {
		// TODO Auto-generated constructor stub
	}
	
	public BalanceInsufficientException(String message){
		super(message);
	}
}
