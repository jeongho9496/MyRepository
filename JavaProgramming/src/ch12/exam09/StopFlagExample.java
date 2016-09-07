package ch12.exam09;

public class StopFlagExample {
	//0907
	public static void main(String[] args) {
		PrintThread1 pt1 = new PrintThread1();
		
		pt1.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}//메인스레드 3초후 정지
		pt1.setStop(true);//setStop 메소드에 true 매개변수 대입
	}
}	
