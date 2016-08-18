package ch02.exam01;

public class VariableSize {

	public static void main(String[] args) {
		byte var1 = 10;
//		int var2 = 200;
		
		int var3 = 200;
//		byte var4 = var3; // int 4byte 이므로 byte(1byte)타입에 담으면 mismatch 오류.
		byte var5 = (byte)/*(byte) -> 자르는크기*/var3; // casting(형변환) : (타입)크기만큰 변환 된다.
		System.out.println(var5);
		
		char var6 = (char)200000;		
		System.out.println(var6);
		
	}

}
