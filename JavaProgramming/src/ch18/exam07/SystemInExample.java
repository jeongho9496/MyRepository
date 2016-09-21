package ch18.exam07;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SystemInExample {
	//0921
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		/*int keycode2 = is.read();
		
		int keyCode = System.in.read();	//1byte 키만 읽을 수 있다.
		System.out.println("키 하나만 입력");
		System.out.println(keyCode + " : " +(char)keyCode);*/
		
		//한글과 같은 여러 byte의 조합을 읽기
		System.out.println("키 여러개 입력");
		byte[] values = new byte[100];
		int byteNum = is.read(values);
		System.out.println(Arrays.toString(values));
		String data = new String(values,0, byteNum-2);
		System.out.println(data);
		
	}

}
