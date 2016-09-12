package ch12.exam08;

public class ConsumerThread extends Thread {
	//0907
	private DataBox dataBox;	//DataBox 타입 필드 생성
	
	public ConsumerThread(DataBox dataBox) {	//매개변수 DataBox타입을 가진 생성자
		// TODO Auto-generated constructor stub
		this.dataBox = dataBox;
		this.setName("ConsumerThread");
	}
	
	@Override
	public void run() {	//start() 호출시 실행
		// TODO Auto-generated method stub
		for (int i = 1; i <= 3; i++) {
			
			//String data = dataBox.getData();//DataBox의 getData메소드에 있는 값을 String 타입에 대입
			dataBox.getData();//DataBox의 getData메소드에 있는 값을 String 타입에 대입
			
		}
	}
}
