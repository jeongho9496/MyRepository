package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample2 {
	//0908
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		
		for (int i = 0; i < 1000; i++) {
			int count = i;
			//작업 생성
			Runnable task = new Runnable() {
				@Override
				public void run() {
					//작업 실행
					for (int i = 0; i <10; i++) {
						System.out.println("실행 중... => "+count+")"+Thread.currentThread().getName());
					}
				}
			};
			//작업 큐에 작업
			executorService.submit(task);
		}//스케줄링에 의해 Queue에 들어있는 작업큐들을 실행기회에 따라 스레드에 대입 되므로 종료 일시는 다를수 있다.
		
		
		//스레드풀 종류
		executorService.shutdown();//하던 작업은 계속 하고 작업 완료후 종료 <=> shutdownNow() 강제 종료
	}

}
