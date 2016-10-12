package ch11.exam13;

public class BoxingUnBoxingExample {
	//0906
	public static void main(String[] args) {
		Integer obj = 100;	//Integer 객체에 100을 만들고 obj가 그 객체를 가리키고 있는것.
		int value = obj;	//Wrapper객체 있는 값을 꺼내어서 int 타입에 대입
		System.out.println(value);
		
		int result = obj + 200;	//obj에 있는 값을 꺼내어서 더한다.
		System.out.println(result);
	}
}
