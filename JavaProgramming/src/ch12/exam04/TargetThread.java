package ch12.exam04;

public class TargetThread extends Thread {	
	//0906
	public void run() {
		for(long i=0; i<1000000000; i++) {}//Runnable or run()중 하나의 상태
		try {
			//1.5초간 일시 정지
			Thread.sleep(1500);
		} catch(Exception e) {}		
		for(long i=0; i<1000000000; i++) {}	//runnable상태 리턴
	}
}
