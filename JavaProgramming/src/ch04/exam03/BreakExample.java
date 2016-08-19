package ch04.exam03;

public class BreakExample {

	public static void main(String[] args) {
		//public=>접근제한자 static void=>리턴타입 main=>메소드 이름(String[] args)=>매개변수 {
		// 주사위의 눈이 6이 나오면 프로그램을 종료하세요
		//0819
		while (true) {
			
			/*double num = Math.random(); // 메소드 호출
			num = num*6;
			int value = (int)num;
			value += 1;*/
			
			int value = (int)(Math.random()*6)+1;
			System.out.println(value);
			
			if (value == 6) {
				break;
			}
		}
		

	}

}
