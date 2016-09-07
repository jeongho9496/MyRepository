package ch12.exam08;

public class ProducerThread extends Thread{
	//0907
	private DataBox dataBox;
	
	public ProducerThread(DataBox dataBox) {
		// TODO Auto-generated constructor stub
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = "DATA - "+i;
			dataBox.setData(data);
		}
	}
}
