package ch12.exam03;

public class MainThreadExample {

	public static void main(String[] args) {
		//0906
		//공유 객체 생성
		Calculator calculator = new Calculator();
		
		//스레드 객체 생성
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		//공유 객체를 각 스레드에게 주입
		user1.setCalculator(calculator);	//calculator -> 같은 객체
		user2.setCalculator(calculator);
		
		//스레드 실행
		user1.start();
		user2.start();

	}

}
