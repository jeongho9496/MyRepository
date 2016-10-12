package ch12.exam08;

public class WaitNotifyExample2 {
	//0907
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBox dataBox = new DataBox();
		
		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);
		
		pt.start();
		ct.start();
		
	}

}
