package ch13.exam04;

import java.util.Date;

public class Example {
	//0908
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map< String , Date > map = new HashMap< String, Date >();
		map.add("입학식", new Date());
		map.add("졸업식", new Date());
		map.add("취업날짜", new Date());
		
		Date date = map.get("입학식");
		
		System.out.println();
		
	}

}
