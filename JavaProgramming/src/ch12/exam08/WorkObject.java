package ch12.exam08;

public class WorkObject {	//공유객체
	//0907
	public synchronized void methodA(){	//synchronized 메소드가 실행될시 객체가 잠겨 다른 스레드는 메소드를 사용 할수 없다.
		System.out.println("ThreadA의 methodA() 작업 실행");
		notify();	//일시정지 상채에 있는 다른 스레드를 실행 대기 상태로 만들고 자신은 wait()메소드를 호출하여 일시 정지 상태로 만든다.
		try {
			wait();
		} catch (InterruptedException e) {
			
		}
	}
	
	public synchronized void methodB(){
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
}
