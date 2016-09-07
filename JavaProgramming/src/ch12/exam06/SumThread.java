package ch12.exam06;

public class SumThread extends Thread {
	//0907
	private long sum;	//sum 필드 생성
	
	public long getSum() {	//sum getter생성 -> 외부에서 함부로 필드값 변경하게 하지 않기 위해
		return sum;
	}

	public void setSum(long sum) {	//매개변수 long sum 가지고 있는 setter생성 
		this.sum = sum;
	}

	@Override
	public void run() {	//Thread run 메소드 오버 라이드 
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}
