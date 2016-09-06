package ch12.exam01;

import java.awt.Toolkit;

public class SoundThread extends Thread {
	//0906
	//Field
	//Constructor
	public SoundThread(){
		setName("SoundThread");	//Thread 이름 정의
	}
	//Method
	@Override
	public void run() {//반드시 재정의
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			System.out.println("소리: "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
		
			} catch (Exception e) {
				
			}
		}
	}
}
