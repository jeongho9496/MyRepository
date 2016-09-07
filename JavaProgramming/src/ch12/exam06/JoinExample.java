package ch12.exam06;

public class JoinExample {
	public static void main(String[] args) {
		//0907
		SumThread st = new SumThread();	//SumThread 객체 생성
		st.start();//SumThread 실행대기
		
		try {
			st.join();	//sumThread가 종료할 때까지 메인 스레드를 일시 정지 시킴
		} catch (InterruptedException e) {
		}
		System.out.println("1~100 합 : " + st.getSum());	//SumThread의 getSum()호출
	}
}
