package ch13.exam02;

import java.util.Date;

public class BoxExample {
	//0908
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();//다이아몬드 연산자<> 타입이 없지만 앞에 있는 타입을 따라 한다.
		box1.setItem("홍길동");
		String name = box1.getItem();
		
		Box<Integer/*int의 클래스 타입*/> box2 = new Box<>();
		box2.setItem(10);
		int  value= (Integer)box2.getItem();
		
		Box<Date> box3 = new Box<>();
		box3.setItem(new Date());
		Date now = box3.getItem();

	}

}
