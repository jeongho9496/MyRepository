package ch12.exam02;

public class ThreadB extends Thread {
	//0906
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100000000; i++) {
			
		}
		System.out.println("ThreadB 종료");
	}
}
