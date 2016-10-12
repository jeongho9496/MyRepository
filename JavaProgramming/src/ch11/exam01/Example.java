package ch11.exam01;

public class Example {
	//0902
	public static void main(String[] args) {
		
		Board b1 = new Board(1, "게시물 제목", "내용");
		Board b2 = new Board(1, "게시물 제목", "내용");
		Board b3 = b1;
		Object obj = new Object();
		
		System.out.println(b1 == b2);	//객체 생성을 달리하여 번지수가 다르다.
		System.out.println(b1.equals(b2));	//object의 equals 는 '==' 와 같다.(<=> String 비교와 다름)
		
		System.out.println("---hashcode---");
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
		System.out.println(b3.hashCode());
		System.out.println(b1.hashCode() == b3.hashCode());
	}
}
