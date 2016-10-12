package ch12.exam02;

public class ThreadPriorityExample {//thread 우선 순위
	//0906
	public static void main(String[] args) {
//		Thread ta = new ThreadA();
//		ta.setPriority(Thread.MIN_PRIORITY);
//		Thread tb = new ThreadB();
//		ta.setPriority(Thread.MAX_PRIORITY);
//		
//		ta.start();
//		tb.start();
		
		Thread thread = null;
		for (int i = 1; i <= 100; i++) {
			thread = new ThreadC(i);
			if (i!=100) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);//i=100 일떼 우선순위 높음 부여
			}
			thread.start();
		}
		
	}

}
