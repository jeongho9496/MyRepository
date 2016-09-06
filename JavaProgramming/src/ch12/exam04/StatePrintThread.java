package ch12.exam04;

public class StatePrintThread extends Thread {	
	//0906
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();//.getState() => 스레드 상태 정보 확인
			System.out.println("타겟 스레드 상태: " + state);
			if(state == Thread.State.NEW) {	//객체 생성 상태
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) {//스레드 종료
				break;
			}
			try {
				//0.5초간 일시 정지
				Thread.sleep(500);
			} catch(Exception e) {}
		}
	}
}