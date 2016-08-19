package ch04.exam02;

public class WhileExample5 {

	public static void main(String[] args) throws Exception {
//		System.out.print("A");	//출력되고 한줄로 나옴
//		System.out.println("B");//출력되고 다음 행으로 넘어감.
		
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			if ( keyCode != 13 && keyCode != 10 ) {
				System.out.println("------------------------");
				System.out.println("| 1.증속 | 2.감소 | 3.멈춤 |");
				System.out.println("------------------------");
				System.out.print("선택: ");
			}
			
			keyCode = System.in.read();
			
			if (keyCode == 49/*1의 키코드값*/) {
				speed++;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 50/*2의 키코드값*/) {
				speed--;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 51/*3의 키코드값*/) {
				run = false;
			} 
		}
		
		System.out.println("종료");

	}

}
