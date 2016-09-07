package ch12.exam11;

public class AutoSaveThread extends Thread{
	//0907
	public void save(){
		System.out.println("작업 내용을 저장함");
	}
	
	@Override
	public void run() {
		while (true) {
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			save();
		}
	}
}
