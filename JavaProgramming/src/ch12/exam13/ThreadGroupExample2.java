package ch12.exam13;

public class ThreadGroupExample2 {
	public static void main(String[] args) {
		//0907
		Thread thread;
		
		thread = new Thread("t1"){//main group
			@Override
			public void run() {
				while(true){
					System.out.println("Thread2: "+ getName() +" 실행중");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println("Thread2: "+ getName() +" 종료------------------------------------------------------------------------");
			}
		};//new Thread("t1"){} == class XXX extends Thread{public XXX(){super("t1")}}new XXX(); -> 부모생성자 "t1"호출
		thread.start();
		
		thread = new Thread("t2"){//main group
			@Override
			public void run() {
				while(true){
					System.out.println("Thread2: "+ getName() +" 실행중");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println("Thread2: "+ getName() +" 종료------------------------------------------------------------------------");
			}
		};
		thread.start();
		
		ThreadGroup sub = new ThreadGroup("sub");//main group밑에 group생성
		
		thread = new Thread(sub,"t3"){//sub group 안으로 들어감
			@Override
			public void run() {
				while(true){
					System.out.println("Thread2: "+ getName() +" 실행중");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println("Thread2: "+ getName() +" 종료------------------------------------------------------------------------");
			}
		};
		thread.start();
		
		thread = new Thread(sub,"t4"){//sub group 안으로 들어감
			@Override
			public void run() {
				while(true){
					System.out.println("Thread2: "+ getName() +" 실행중");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println("Thread2: "+ getName() +" 종료------------------------------------------------------------------------");
			}
		};
		thread.start();
		
		try { Thread.sleep(1); } catch (InterruptedException e) {}
		sub.interrupt();
		
		try { Thread.sleep(3); } catch (InterruptedException e) {}
		Thread.currentThread().getThreadGroup().interrupt();
		
	}
}
