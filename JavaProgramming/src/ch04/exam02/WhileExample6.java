package ch04.exam02;

public class WhileExample6 {

	public static void main(String[] args) throws Exception {
		// System.out.print("A"); //출력되고 한줄로 나옴
		// System.out.println("B");//출력되고 다음 행으로 넘어감.

		boolean run = true;
		int balance = 0; // 잔액 출력 (=speed)
		int keyCode = 0; // 금액 입력 (=keyCode)

		while (run) {
			if (keyCode != 10 && keyCode != 13) {
				System.out.println("------------------------");
				System.out.println("| 1.예금 | 2.출금 | 3.종료 |");
				System.out.println("------------------------");
				System.out.print("선택 : ");
			}

			keyCode = System.in.read();
			
			if (keyCode == 49) {
				balance += 1000;
				System.out.println("현재 잔액 : " + balance + "원");
			} else if (keyCode == 50) {
				balance -= 500;
				System.out.println("현재 잔액 : " + balance + "원");
			} else if (keyCode == 51) {
				System.out.println("종료");
				run = false;
			} else {
				if (keyCode != 10 && keyCode != 13) {
				System.out.println("다시입력");
				}
			}

		}

	}

}
