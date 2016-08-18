package ch02.exam01; //패키지 선언 패키지 이름은 전부 소문자로 하는게 관례

public class VariableScope { // 첫글자 대문자 두 단어 합치면 단어의 첫글자는 대문자. File이름과 클래스 이름은
								// 대소문자 포함 모두 일치 해야 한다.
	public static void main(String[] args) {
		int var1 = 10;
		System.out.println("var1: " + var1); // '()' 괄호 안에 ""안에 있는 단어는 출력 "" 없는
												// 변수는 변수의 값 출력. '+' -> 결합시키는 역할

		if (true) {
			int var2 = 15;
			System.out.println("var1: " + var1);
			System.out.println("var1: " + var2);

			if (true) {
				int var3 = 20;
				System.out.println("var1: " + var1);
				System.out.println("var1: " + var2);
				System.out.println("var1: " + var3);
			}
			System.out.println("var1: " + var1);
			System.out.println("var1: " + var2);
			// System.out.println("var1: " + var3); // 변수 선언한 블록을 벗어남
		}

		System.out.println("var1: " + var1);
		// System.out.println("var1: " + var2); // 변수 선언한 블록을 벗어남

	}

}
