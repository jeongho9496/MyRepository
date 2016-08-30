package ch06.Test;

public class Account19 {
	private int balance;

	public int getBalance() {
		return balance;
	}
	
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	public void setBalance(int balance) {
		if (MIN_BALANCE <= balance && balance<=MAX_BALANCE) {
			this.balance = balance;			
		}else {
			return;
		}
	}
	
	
}
