package ch12.exam08;

public class ThreadA extends Thread{
	//0907
	private WorkObject workObject;	//WorkObject타입 필드 생성
	
	public ThreadA(WorkObject workObject) {//생성자
		this.workObject = workObject;	//주입(injection) 생성자를 통해 매개변수의 값을 필드값에 주입하는 것
	}

	@Override
	public void run() {	//ThreadA가 start() 할시 실행
		for (int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}

}
