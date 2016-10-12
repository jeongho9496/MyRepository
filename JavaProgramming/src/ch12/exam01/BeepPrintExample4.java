package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample4 {
	// 0906
	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Thread thread = new SoundThread();	//thread 상속 받은 객체 생성
		thread.start();// 스레드의 run메소드 실행 실행

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			System.out.println("출력: " + Thread.currentThread().getName());
			Thread.sleep(500);
		}
	}

}
