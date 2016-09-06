package ch11.Test;

import java.util.regex.Pattern;

public class PatternMatchExample {
	//??
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "Angel1004";
		String regExp = "[a-zA-Z]{8,12}";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}

}
