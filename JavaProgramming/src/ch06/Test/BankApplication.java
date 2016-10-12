package ch06.Test;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100]; // 배열 생성
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.계좌 생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 : ");

			int selectNo = scanner.nextInt();

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
		System.out.println("계좌주 : ");
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
	private static void widthdraw() {
		// TODO Auto-generated method stub
		

	}

	private static void deposit() {
		// TODO Auto-generated method stub

	}

	private static void accountList() {
		// TODO Auto-generated method stub

	}

}
