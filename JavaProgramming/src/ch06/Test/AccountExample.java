package ch06.Test;

public class AccountExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account19 account = new Account19();
		
		account.setBalance(10000);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(-10000);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(200000000);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(2000);
		System.out.println("현재 잔고 : " + account.getBalance());

	}

}
