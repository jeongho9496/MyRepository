package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample3 {
	//0908
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		
		for (int i = 0; i < 10; i++) {
			int count = i;
			//작업 생성
			Runnable task = new Runnable() {//리턴값이 없는 구현 클래스
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;	//타입변환 스레드 개수
					System.out.println("스레드의 총수 : " + threadPoolExecutor.getPoolSize());
					//작업 실행
					System.out.println("실행 중... => "+count+")"+Thread.currentThread().getName());
					int value = Integer.parseInt("aa");//NumberFormat메소드 예외 발생
					
				}
			};
			//작업 큐에 작업
			executorService.submit(task);//예외처리를 메소드내에서 함, 스레드를 재사용
//			executorService.execute(task);//예외처리를 안함 오류 발생
		}
		
		
		//스레드풀 종류
		executorService.shutdown();//하던 작업은 계속 하고 작업 완료후 종료 <=> shutdownNow() 강제 종료
	}

}
