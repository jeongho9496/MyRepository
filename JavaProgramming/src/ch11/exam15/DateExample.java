package ch11.exam15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	//0906
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		System.out.println(now.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(now);	//매개값으로 날짜 객체 삽입
		String strDate1 = sdf1.format(now);	//매개값으로 날짜 객체 삽입
		System.out.println(strDate);
		System.out.println(strDate1);
		
		Calendar cal = Calendar.getInstance();//객체 하나만 생성
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)/*0~11까지 나옴*/ + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);//한달 기준으로 일 계산
		int hour = cal.get(Calendar.HOUR_OF_DAY);//24시간,HOUR : 0~11만 나옴
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int amPm = cal.get(Calendar.AM_PM);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.println("hour : " + hour);
		System.out.println("minute : " + minute);
		System.out.println("second : " + second);
		System.out.println("ampm : " + amPm);
		System.out.println("week : " + week);
		

	}

}
