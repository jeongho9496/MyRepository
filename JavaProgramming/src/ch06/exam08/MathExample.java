package ch06.exam08;

public class MathExample {
	public static void main(String[] args) {
		Math math = new Math();
		
		math.printInfo("수학 객체가 생성됨");
		
		int result = math.max(1, 2);//int result 변수에 max 메소드 리턴 값을 받는다.
		System.out.println(result);
		math.max(1, 2);//변수 선언 없이 메소드를 호출 한다는건 리턴값을 사용하지 않겠다는 것
		
		int[] values = {10,20,30,40,50};
		double result1 = math.avg1(values);
		System.out.println(result1);
		
		double result2 = math.avg2(10,20,30,40,50);
		System.out.println(result2);
		
		
	}

}
