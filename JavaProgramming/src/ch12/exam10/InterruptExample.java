package ch12.exam10;

public class InterruptExample {
	//0907
	public static void main(String[] args) {
//		PrintThread2 pt1 = new PrintThread2();
		PrintThread3 pt1 = new PrintThread3();
		
		pt1.start();
		
		try {
			System.out.println("MainThread멈춤");
			Thread.sleep(2);} catch (InterruptedException e) {}//메인스레드 3초동안 정지되는 동안 printThread3는 활성화
		pt1.interrupt();//pt1의 interrupt()호출
		System.out.println("MainThread활성");
	}
}	
 