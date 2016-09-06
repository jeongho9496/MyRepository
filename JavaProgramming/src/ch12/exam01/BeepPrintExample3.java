package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample3 {
	//0906
	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Thread thread = new Thread(){

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					System.out.println("소리: " + Thread.currentThread().getName());
					try {

						Thread.sleep(500);

					} catch (Exception e) {

					}
				}

			}
		};// Thread 상속 받은 익명 클래스에서 run 재정의
		thread.setName("SoundThread");//스레드명 변경
		thread.start();// 스레드 실행

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			System.out.println("출력: " + Thread.currentThread().getName());
			Thread.sleep(500);
		}
	}

}
