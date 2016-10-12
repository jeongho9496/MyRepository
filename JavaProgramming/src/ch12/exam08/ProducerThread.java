package ch12.exam08;

public class ProducerThread extends Thread{
	//0907
	private DataBox dataBox;	//DataBox타입 필드 설정
	
	public ProducerThread(DataBox dataBox) {
		// TODO Auto-generated constructor stub
		this.setName("ProducerThread");
		this.dataBox = dataBox;// 데이터 필드 값 초기화 -> 인젝션
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = "DATA - "+i;
			dataBox.setData(data);	//String data를 setData의 매개변수로 넘김
		}
	}
}
