package ch12.exam03;

public class Calculator {//synchronized를 가지면 스레드 하나가 들어올 동안 다른 스레드들은 Calculator에 접근 불가(Lock)
	//0906
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		//synchronized 실행된 객체의 스레드 메소드가 완전히 끝날때 까지 기다렸다가 다음 객체의 스레드 메소드 실행
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println(Thread.currentThread().getName() + ": "+ this.memory);
		//Thread.currentThread().getName() -> 현재 실행하고 있는 스레드 이름
	}
	
	/*public void setMemory(int memory) {
		synchronized (this) {
			
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			
			System.out.println(Thread.currentThread().getName() + ": "+ this.memory);
			//Thread.currentThread().getName() -> 현재 실행하고 있는 스레드 이름
		}
	}*/

}
