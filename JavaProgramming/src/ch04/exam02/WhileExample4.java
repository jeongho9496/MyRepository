package ch04.exam02;

public class WhileExample4 {

	public static void main(String[] args) throws Exception {

		/*boolean tf = true;
		
		while (tf) {
			int num = System.in.read();

			if (num != 13 && num != 10) {

				System.out.println(num);
				if (num == 113) {
					tf = false;
				}
			}
		}
		System.out.println("종료");*/
		
		int num = 0;
		System.out.println("프로그램 시작");
		
		while (num != 113) {		// q의 키코드값 113
			num = System.in.read();
			
			if (num != 13 && num != 10) {
				System.out.println(num);
			}
		}
		System.out.println("프로그램 종료");
	}

}
