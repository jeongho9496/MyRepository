package ch12.exam09;

public class PrintThread1 extends Thread {
	//0907
	private boolean stop;	//기본 false

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while (!stop) {
			
			System.out.println("실행 중...");
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
	
}
