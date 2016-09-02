package ch10.exam02;

public class Example {
	//0901
	public static void main(String[] args) {
		try {
			
			int result = Calculator.sum("10", "aa");
			System.out.println(result);

		} catch (NumberFormatException e) {
			System.out.println("에러");
		}
		
	}
}
