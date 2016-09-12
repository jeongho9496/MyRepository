package ch12.exam08;

public class WaitNotifyExample {
	public static void main(String[] args) {
		//0907
		/*WorkObject shareObject = new WorkObject();	//WorkObject타입 공유객체 생성
		ThreadA threadA = new ThreadA(shareObject);	//ThreadA타입 WorkObject매개변수를 담는 객체 생성
		ThreadB threadB = new ThreadB(shareObject);
		
		threadA.start();//run메소드 실행
		threadB.start();
		*/
		
		DataBox dataBox = new DataBox();
		
		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);
		
		pt.start();
		ct.start();
		
	}
}
