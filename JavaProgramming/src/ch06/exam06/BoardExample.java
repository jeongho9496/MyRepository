package ch06.exam06;

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b1 = new Board(3);
		Board b2 = new Board(1, "제목");
		Board b3 = new Board("제목", 1);
		
		String s1 = new String();
		String s2 = new String("홍길동");
		
		byte[] date = {65,66,67};
		String s3 = new String(date);
		System.out.println(s3);
		
		String s4 = new String(date, 1, 2);//데이터출력할시 처음 출력될 배열 번호와 최종 번호를 설정할 수 있다.
		System.out.println(s4);
	}

}
