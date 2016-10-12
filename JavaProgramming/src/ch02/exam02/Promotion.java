package ch02.exam02;

public class Promotion {
	public static void main(String[] args) {
		//정수
		byte v1 = 100;	//1byte
		short vs = v1;	//2byte
		int v2 = v1;	//4byte
		long v3 = v2;	//8byte
		System.out.println("v3 : " + v3);
		
		//실수
		float v4 = v3;	//4byte(부동소수점)
		double v5 = v3;	//8byte(부동소수점)
		System.out.println("v3 : " + v5);
		
		int a = 128;
		byte b = (byte)a;
		System.out.println(b);
	}
}
