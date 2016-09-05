package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {
	//0905
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};	//ASCII 번호 문자(숫자, 알파벳, 특수문자)에 0~255의 번호를 매김
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,6,4);
		System.out.println(str2);
		
		String str3 = "홍길동";	//ASCII 표현 안됨.
		byte[] strBytes3 = str3.getBytes();	//바이트 배열로 변환 문자를 2byte로 변환
		
		String str4 = new String(strBytes3);//String로 복원
		System.out.println(str4);
		
		String str5 = "ab홍길동"; 
		byte[] strBytes5 = str5.getBytes("EUC-KR");	//3byte로 문자를 표현	->Encoding 문자를 바이트 배열로 만드는 작업
		//EUC-KR ASCII + UNICODE(한글만 사용 한글을 2byte로 변경) -> 알파벳, 한글만 사용
		//UTF-8 ASCII + UNICODE(각 나라 언어별로 Byte수가 다름 ex.영어:1byte, 한글:3byte, 중국:4byte)
		String str6 = new String (strBytes5, "EUC-KR");	//->Decoding 바이트 배열을 문자열로 만드는 작업
		System.out.println(str6);
		
		String str7 = new String(strBytes5, 2, 6/*byte수*/,"EUC-KR");
		System.out.println(str7);
		
		//네트워크 통신할시 byte로 데이터를 전송하기 때문에 문자 복원시 필요!

	}

}
