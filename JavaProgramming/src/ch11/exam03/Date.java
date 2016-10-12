package ch11.exam03;

import java.util.Calendar;

public class Date {
	@Override
	public String toString() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);		//년
		int month = now.get(Calendar.MONTH)+1;	//월 +1 하는 이유?
		int day = now.get(Calendar.DAY_OF_MONTH);//일
		String abc = year + "-"+ month + "-" + day;//숫자가 문자열로 바뀜
		return abc;
	}
}
