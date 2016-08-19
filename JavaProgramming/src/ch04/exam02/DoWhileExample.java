package ch04.exam02;

public class DoWhileExample {

	public static void main(String[] args) throws Exception {
		int num = 0;
		
		do {
			num = System.in.read();
			System.out.println(num);
		} while (num != 113); // ; 필수 !

	}

}
