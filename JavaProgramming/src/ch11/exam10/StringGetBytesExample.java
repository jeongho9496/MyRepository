package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	//0905
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "안녕하세요";
		
		//String -> byte[]
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length : " + bytes1.length);
		
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println("bytes.length : " + bytes2.length);

		byte[] bytes3 = str.getBytes("UTF-8");
		System.out.println("bytes.length : " + bytes3.length);

		//byte[] -> String
		String str1 = new String(bytes1);
		System.out.println("str : " + str1);
		
		String str2 = new String(bytes2, "EUC-KR");
		System.out.println("str : " + str2);
		
		String str3 = new String(bytes3);
		System.out.println("str : " + str3);
	}

}
