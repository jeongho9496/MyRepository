package ch13.exam07;

import java.util.Date;

public class Util {
	//0908
	public static <T extends Number>/*Number의 자식객체만 타입으로 올수 있다.*/ int compare(T t1, T t2){
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		/*if (v1 < v2) return -1;
		else if (v1 == v2) return 0;
		else return 1;*/
		
		return Double.compare(v1, v2);//Double.compare(v1, v2); 매개값 비교 첫 번째 매개변수가 작으면 음수 같으면 0 크면 양수를 리턴한다
	}
}
