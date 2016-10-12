package ch12.exam07;

import java.util.Calendar;

public class EnumExample {
	public static void main(String[] args) {
		//0907
//		Week week = Week.TUESDAY;	//가독성 높아짐
//		int week;
		
		Week week;
		
		Calendar now = Calendar.getInstance();
		switch (now.get(Calendar.DAY_OF_WEEK)) {//final static 로 요일이 정해져 있음
		case 1: week = Week.SUNDAY;break;
		case 2: week = Week.MONDAY;break;
		case 3: week = Week.TUESDAY;break;
		case 4: week = Week.WEDNESDAY;break;
		case 5: week = Week.THURSDAY;break;
		case 6: week = Week.FRIDAY;break;

		default: week = Week.SATURDAY;
		}
		
		System.out.println(week);
	}
}
