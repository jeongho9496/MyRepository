package ch04.exam02;

public class WhileExample2 {

	public static void main(String[] args) throws Exception{ // throws Exception Thread 사용하기 위해 사용 
		int i = 1;
		while ( i <= 10) {
			System.out.println("반복 실행중...");
			Thread.sleep(1000); // 1초 동안 작업 중지
			i++;
		}

	}

}
