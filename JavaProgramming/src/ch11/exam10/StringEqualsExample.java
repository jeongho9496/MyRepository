package ch11.exam10;

public class StringEqualsExample {
	//0905	p501
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 = "홍길동";	//리터럴 literal
		String strVar2 = new String( "홍길동" );
		
		System.out.println(strVar1 == strVar2);	//참조 객체가 다르기 때문에 false
		System.out.println(strVar1.equals(strVar2));//문자열만 같으면 true
	}

}
