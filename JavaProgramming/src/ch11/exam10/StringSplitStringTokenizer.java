package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {
	//0905 p511,513
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "홍길동,이수홍,박연수,감자바,최명호";
		
		String[] dataArray = data.split(",");	//정규표현식
		System.out.println(dataArray.length);
		
		for (String string : dataArray) {
			System.out.println(string);
		}
		
		StringTokenizer st = new StringTokenizer(data, ",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){	//token이 있는지 여부 조사
			String token = st.nextToken();
			System.out.println(token);
		}
		
		data = "이명진&김정호,이보나,이윤주-지승훈";
		
		dataArray = data.split("&|,|-");	//정규표현식 | (파이프 기호) 로 연결 구분자를 구분
		System.out.println(dataArray.length);
		
		for (String string : dataArray) {
			System.out.println(string);
		}
		
	}

}
