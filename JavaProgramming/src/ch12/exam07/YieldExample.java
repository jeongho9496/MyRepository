package ch12.exam07;

public class YieldExample {
	//0907
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
				
		threadA.start();	//실행 대기 상태가 됨
		threadB.start();
		
		try {
			Thread.sleep(3000);	//메인 스레드를 일시 정지 시킨다.
		} catch (InterruptedException e) {
		}
		
		threadA.work = Work.PAUSE;

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		threadA.work = Work.CONTINUE;

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		threadA.stop = true;
		threadB.stop = true;
		
	}

}
