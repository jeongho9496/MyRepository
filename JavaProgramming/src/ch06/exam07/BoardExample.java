package ch06.exam07;

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0824
		Board b1 = new Board(3);
		Board b2 = new Board(1, "제목");
		Board b3 = new Board("제목", 1);
		
		String s1 = new String();
		String s2 = new String("홍길동");
		
		byte[] date = {65,66,67};
		String s3 = new String(date);
		System.out.println(s3);
		
		String s4 = new String(date, 1, 2);
		System.out.println(s4);
	}

}
