package ch11.Test;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DatePrintExample {

	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월  dd일 hh시 mm분 ss초 ");
		String strNow = simple.format(now);
		System.out.println(strNow);

	}

}
