package ch11.exam04;

public class ExitExample {
	//0902
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i == 5) {
				System.exit(0);	//프로세스를 멈추어라
//				return;			//메소드의 실행을 멈추어라
//				break;			//메소드 실행문을 빠져나온다.
			}
		}
		
		System.out.println("출력");
	}
	
	public static void method(int x){
		if (x == 5) {
			return;
		}
		System.out.println(x);
	}
}
