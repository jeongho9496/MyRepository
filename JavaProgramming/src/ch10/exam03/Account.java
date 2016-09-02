package ch10.exam03;

import ch10.exam02.BalanceInsufficientException;
//0901
public class Account {	//계좌클래스
	private long balance;	//잔고

	public long getBalance() {	
		return balance;
	}
	
	public void deposit(int money){		//예금
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException{	//출금 //throws exception 호출한 객체로 보냄
		//예외를 가지고 있는 메소드는 throws로 메소드 실행하는 곳에다 예외를 던진다.
		if (balance >= money) {
			balance -= money;
		} else {
				throw new BalanceInsufficientException("잔고 부족");	
		}
	}
}
