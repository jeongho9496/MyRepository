package ch12.exam11;

public class DaemonExample {
	//0907
	public static void main(String[] args) {
		AutoSaveThread ast = new AutoSaveThread();
		ast.setDaemon(true);
		//주스레드(main스레드)에서 데몬스레드(AutoSaveThread)의 setDaemon(true)를 설정한다.
		//반드시 start()메소드 호출 전에 setDaemon(true)를 호출해야 한다.
		ast.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		System.out.println("메인 스레드 종료");
	}
}
