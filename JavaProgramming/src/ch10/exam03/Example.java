package ch10.exam03;

import ch10.exam02.BalanceInsufficientException;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account = new Account();
		
		account.deposit(100000);
		System.out.println(account.getBalance());
		
		try {
			account.withdraw(200000);
			System.out.println("출금이 되었습니다.");
		} catch (BalanceInsufficientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	//예외 경로를 출력한다.
			System.out.println("출금이 되지 않았습니다.");
		}

	}

}
