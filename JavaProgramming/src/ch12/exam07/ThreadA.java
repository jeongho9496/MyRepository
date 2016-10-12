package ch12.exam07;

public class ThreadA extends Thread{
	//0907
	public boolean stop = false;
//	public boolean work = true;
	public Work work = Work.CONTINUE;	//enum으로 필드명 정의 -> 가독성 효과
	
	@Override
	public void run() {
		while(!stop){	//stop => true 이면 종료 !?
			if (work == Work.CONTINUE) {
				System.out.println("ThreadA 작업 내용");
			} else if(work == Work.PAUSE){
				Thread.yield();
			}
		}
		
		System.out.println("ThreadA 종료");
	}
}
