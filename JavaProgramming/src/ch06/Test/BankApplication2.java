package ch06.Test;

import java.util.Scanner;

public class BankApplication2 {
	private static Account[] accountArray = new Account[100]; // 배열 생성
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.계좌 생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 : ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				widthdraw();
			} else if (selectNo == 5) {
				break;
			}

		}
		System.out.println("종료");
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");

		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		System.out.print("계좌주 : ");
		String owner = scanner.nextLine();
		System.out.print("초기 입금액 : ");
		int balance = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				Account account;
				account = new Account(ano, owner, balance);
				accountArray[i] = account;
				break;
			}
		}
	}

	private static void accountList() {
		// TODO Auto-generated method stub
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");

		if (accountArray != null) {
			for (Account account : accountArray) {
				if (account != null) {
					System.out.println(account.getAno() + "\t" + account.getOwner() + "\t" + account.getBalance());
				}
			}
		}

	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");

		System.out.print("계좌번호 : ");
		String depAno = scanner.nextLine();
		System.out.print("예금 : ");
		int plusMoney = Integer.parseInt(scanner.nextLine());

		findAccount(depAno).setBalance(findAccount(depAno).getBalance()+plusMoney);
		/*if (accountArray != null) {
			for (Account account : accountArray) {
				if (account != null) {
					if (depAno.equals(account.getAno())) {
						account.setBalance(account.getBalance() + plusMoney);
					}
				}
			}
		}*/
	}

	private static void widthdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");

		System.out.print("계좌번호 : ");
		String withAno = scanner.nextLine();
		System.out.print("출금 : ");
		int minusMoney = Integer.parseInt(scanner.nextLine());
		int temp = findAccount(withAno).getBalance() - minusMoney;
		findAccount(withAno).setBalance(temp);
		
		/*if (accountArray != null) {
			for (Account account : accountArray) {
				if (account != null) {
					if (withAno.equals(account.getAno())) {
						account.setBalance(account.getBalance() - minusMoney);
					}
				}
			}
		}*/

		/*if(findAccount(withAno) != null)
			System.out.println("계좌 찾음");*/

	}

	private static Account findAccount(String ano){
		if(accountArray != null){
			for(int i=0;i<accountArray.length;i++){
				if(ano.equals(accountArray[i].getAno())){
					return accountArray[i];
				}
				
			}
	
		}
		return null;

	}


}
