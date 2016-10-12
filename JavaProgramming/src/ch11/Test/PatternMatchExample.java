package ch11.Test;

import java.util.regex.Pattern;

public class PatternMatchExample {
	//??
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "5Angel1004";
		String regExp = "[a-zA-Z][a-zA-Z0-9]{7,11}";
		//첫글자 영어만 나머지(7~11자) 숫자 영어 상관 없음
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}

}
