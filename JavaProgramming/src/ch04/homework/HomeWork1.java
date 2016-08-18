package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int di1 = 0;
		int di2 = 0;
		for (int i = 1; i <= 100; i++) {
			di1 = (int)(Math.random()*6)+1;
			di2 = (int)(Math.random()*6)+1;
			if (di1 + di2 == 10) {
				System.out.println("("+di1+","+di2+")");			
			}
		}
		
	}

}
