package ch12.exam05;

public class ThreadA extends Thread{
	//0907
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop){	//!stop => !false => true
			if (work) {
				System.out.println("ThreadA 작업 내용");
			} else {
				Thread.yield();//work => false가 되면 다른 스레드 에게 실행을 양보한다.
			}
		}
		
		System.out.println("ThreadA 종료");
	}
}
