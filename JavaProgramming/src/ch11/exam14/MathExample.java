package ch11.exam14;

import java.util.Arrays;

public class MathExample {
	//0906
	public static void main(String[] args) {
		
		double v1 = Math.ceil(5.3);		//5.3위에 정수
		double v2 = Math.floor(5.3);	//5.3아래 정수
		
		System.out.println(v1);
		System.out.println(v2);
		
		double v3 = Math.max(5, 3);//두수중 최대값
		System.out.println(v3);
		
		double v4 = Math.round(5.3);//반올림
		double v5 = Math.round(5.6);
		System.out.println(v4);
		System.out.println(v5);
		
		int[] lotto = new int[7];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
		}
		System.out.println(Arrays.toString(lotto));
		
		
				
	}
	
	
}
