package ch11.Test;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "아이디, 이름, 패스워드";
		
		//splite
		String[] strSplit = str.split(", ");
		
		for (String string : strSplit) {
			
			System.out.println(string);
		}
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(str, ", ");
		int countTokens = st.countTokens();
		for (int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println();
		
		st = new StringTokenizer(str, ", ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
			
		}
	}

}
