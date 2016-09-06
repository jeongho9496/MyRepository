package ch12.exam02;

public class ThreadA extends Thread {
	//0906
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100000000; i++) {
			
		}
		System.out.println("ThreadA 종료");
	}
}
