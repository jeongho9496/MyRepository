package ch12.exam10;

public class PrintThread3 extends Thread {
	// 0907
	@Override
	public void run() {

		while (true) {

			System.out.println("실행 중...");
//			if (isInterrupted()) {
			if (Thread.interrupted()) {//static 메소드
				
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}

}
