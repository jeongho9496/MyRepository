package ch12.exam08;

public class DataBox {//공유객체
	//0907
	private String data;

	public synchronized String getData() {	//객체에 스레드가 하나 올수 있도록 만듬 스레드 하나가 들어올때(실행될때) synchronized로 객체를 잠근다.
		if (this.data == null) {
			try {wait();} catch (InterruptedException e) {}
		}	//data 필드가 null이면 소비자 스레드를 일시 정지 상태로 만듬.
		
		String returnValue = data;	//data에 저장되어 있는 값을 returnValue로 넘긴다.
		System.out.println("ConsummerThread가 읽은 데이터 : " + returnValue);
		data = null;	//data 필드를 초기화한다.
		notify();		
		//일시정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고 자신은 wait()메소드를 호출하여 일시 정지 상태로 만든다.
		//예제에서는 wait()호출을 if문 안에서 하므로 if문에 조건 검사후 if문에 해당이 될때 wait()문을 실행하여 일시정지 상태로 만든다.
		return returnValue;
	}

	public synchronized void setData(String data) {
		if (this.data != null) {
			try {wait();} catch (InterruptedException e) {}
		}	//data 필드가 null이 아닐때 setData를 받은 스레드를 일시정지 시킴
		this.data = data;	//매개변수로 받은 데이터를 필드값에 초기화 시킴
		System.out.println("ProducerThread가 생성한 데이터 : " + data);
		notify();
		//일시정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고 자신은 wait()메소드를 호출하여 일시 정지 상태로 만든다.
		//예제에서는 wait()호출을 if문 안에서 하므로 if문에 조건 검사후 if문에 해당이 될때 wait()문을 실행하여 일시정지 상태로 만든다.		
	}
	
	
}
