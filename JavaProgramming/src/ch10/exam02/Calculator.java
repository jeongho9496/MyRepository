package ch10.exam02;

public class Calculator {
	//0901
	public static int sum(String x, String y) throws NumberFormatException{	//catch에서 예외값이 리턴으로 나와야 하는데 예외값이 변동되면 안되는 메소드이기 때문에 예외를 실행 하는 곳에 던져 준다.
		
		int v1 = Integer.parseInt(x);
		int v2 = Integer.parseInt(y);
		int result = v1 + v2;
		
		return result;
	}
}
