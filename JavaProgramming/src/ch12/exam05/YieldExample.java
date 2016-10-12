package ch12.exam05;

public class YieldExample {
	//0907
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA threadA = new ThreadA();	//ThreadA 타입 객체 생성
		ThreadB threadB = new ThreadB();
				
		threadA.start();	//실행 대기 상태가 됨
		threadB.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		threadA.work = false;	//work가 false면 Thread.yield()에 의해 스레드 양보

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		
		threadA.work = true;	//work가 true이면 ThreadA가 다시 실행한다.

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		threadA.stop = true;
		threadB.stop = true;
		
	}

}
