package ch12.exam13;

public class ThreadGroupExample {

	public static void main(String[] args) {
		//0907
		Thread thread = Thread.currentThread();//현재 실행 중인 스레드 반환
		System.out.println(thread.getName());
		
		for (int i = 0; i < 10; i++) {//익명 객체 안에서 로컬 변수를 사용할 시 변수는 fianl을 갖는다.
			int count = i;
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					while(true){
						System.out.println("Thread2: "+ count +" 실행중");
						if (isInterrupted()) {
							break;
						}
					}
					System.out.println("Thread2: "+ count +" 종료------------------------------------------------------------------------");
				}
			};//익명 자식 객체
			thread2.start();
			
		}
		
		ThreadGroup mainGroup = thread.getThreadGroup();
		System.out.println(mainGroup.getName());
		System.out.println(mainGroup.activeCount());//mainthread->1개, thread2 thread->1개 
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		
		mainGroup.interrupt();//group에 포함되어 있는 모든 thread가 interrupt됨.
	}

}
