package ch11.exam10;

import java.util.regex.Pattern;

public class PatternExample {
	//0905
	public static void main(String[] args) {
		String tel1 = "010-472-9496";
		String tel2 = "013-4728-9496";
		String tel3 = "010-4728-9496";
		String tel4 = "013-47280-946";
		
		String regExp = "(010|011)-\\d{3,4}-\\d{4}";//정규표현식 : 문자열이 정해져 있는 형식
		
		System.out.println(Pattern.matches(regExp, tel1));	//Pattern.matches(정규표현식, String 객체) 정규표현식에 맞게 데이터가 작성되있는지 확인
		System.out.println(Pattern.matches(regExp, tel2));
		System.out.println(Pattern.matches(regExp, tel3));
		System.out.println(Pattern.matches(regExp, tel4));
		
		String email1 = "hong@naver.com";
		String email2 = "hongnaver.com";
		String email3 = "hong@navercom";
		
		String regExp2 = "\\w+@\\w+\\.\\w+";
		
		System.out.println(Pattern.matches(regExp2, email1));
		System.out.println(Pattern.matches(regExp2, email2));
		System.out.println(Pattern.matches(regExp2, email3));
		
		
		
	}

}
