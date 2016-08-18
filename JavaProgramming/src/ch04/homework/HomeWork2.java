package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		
		/*for (int i = 1; i <= 100; i++) {
			x = (int)(Math.random()*10)+1;
			y = (int)(Math.random()*10)+1;
			
			if (4*x+5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
		}*/
		
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y < 10; y++) {
				if (4*x + 5*y == 60) {
					System.out.println(x+","+y);					
				}
			}
		}

	}

}
