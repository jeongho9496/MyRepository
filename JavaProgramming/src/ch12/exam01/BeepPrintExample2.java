package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	//0906
	public static void main(String[] args){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					System.out.println("소리: "+Thread.currentThread().getName());
					try {
						Thread.sleep(500);
				
					} catch (Exception e) {
						
					}
				}
				
			}
		});//Runnable 객체를 만들어서 Thread객체에 매개값으로 넘김
		
		thread.start();//스레드 실행
		

		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				System.out.println("출력: "+Thread.currentThread().getName());
				Thread.sleep(500);
		
			} catch (Exception e) {
				
			}
		}
	}
}
