package ch13.exam05;

import java.util.Date;

public class BoxingMethodExample {
	//0908
	public static void main(String[] args) {
		Box<Integer> box1 = Util.boxing(new Integer(30));//객체 타입 받기
		
		Box<Date> box2 = Util.boxing(new Date());
		
		Box<String> box3 = Util.boxing("Tv");

	}

}
