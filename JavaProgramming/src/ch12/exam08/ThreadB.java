package ch12.exam08;

public class ThreadB extends Thread{
	//0907
	private WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;	//주입(injection) 생성자를 통해 매개변수의 값을 필드값에 주입하는 것
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}

}
