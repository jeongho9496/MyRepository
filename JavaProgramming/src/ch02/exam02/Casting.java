package ch02.exam02;

public class Casting {

	public static void main(String[] args) {
		long v1 = 300;
		int v2 = (int)v1;
		System.out.println("v2 : " + v2);
		
		byte v3 = (byte)v1;	//byte크기에 300은 안담아진다.
		System.out.println("v3 : " + v3);
		
		char v5 = 'A';	//''하나의 문자 사용시 사용
		int v6 = 'A';	// 'A'는 유니코드로 저장하기 때문에 숫자 타입도 가능하다.
		int v7 = '한';
		System.out.println("v5:"+v5);
		System.out.println("v6:"+v6);
		System.out.println("v7:"+v7);
//		byte v7 = '한';	// 한글은 크기가 byte를 넘긴다.
		
		int v8 = 65;
		char v9 = (char)v8;	// 2byte지만 1byte를 입력시 (char)입력 (자바문법상)
		System.out.println(v9);
		
		char v10 = 66;
		System.out.println(v10);
	}

}
