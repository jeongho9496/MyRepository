package ch13.exam01;

import java.util.Date;

public class BoxExample {
	//0908
	public static void main(String[] args) {
		Box box1 = new Box();
		box1.setItem("홍길동");
		String name = (String)box1.getItem();
		
		Box box2 = new Box();
		box2.setItem(10);
		int  value= (Integer)box2.getItem();
		
		Box box3 = new Box();
		box3.setItem(new Date());
		String now = (String)box3.getItem();//Date타입은 String로 바꾸므로 classcastException 실행

	}

}
