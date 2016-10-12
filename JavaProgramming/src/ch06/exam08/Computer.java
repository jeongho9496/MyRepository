package ch06.exam08;

public class Computer {
	//0824
	int sum1(int[] values){
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i]; 
		}
		return sum;
	}
	
	int sum2(int ... values){//배열의 길이를 알수 없을때 ... 으로 표시
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i]; 
		}
		return sum;
	}
}
