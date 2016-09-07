package ch12.exam10;

public class InterruptExample {
	//0907
	public static void main(String[] args) {
//		PrintThread2 pt1 = new PrintThread2();
		PrintThread3 pt1 = new PrintThread3();
		
		pt1.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}//스레드 3초정지
		pt1.interrupt();//스레드가 일시정지 될때  InterruptedException(예외) 발생
	}
}	
