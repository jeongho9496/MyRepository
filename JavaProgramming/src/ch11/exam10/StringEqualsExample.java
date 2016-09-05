package ch11.exam10;

public class StringEqualsExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 = "홍길동";	//리터럴 literal
		String strVar2 = new String( "홍길동" );
		
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar1.equals(strVar2));
	}

}
