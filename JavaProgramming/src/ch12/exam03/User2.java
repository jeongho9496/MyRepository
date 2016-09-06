package ch12.exam03;

public class User2 extends Thread {
	//0906
	private Calculator calculator;
	
	
	public void setCalculator(Calculator calculator) {	//Calculator 타입을 받아 저장
		this.calculator = calculator;
		setName("User2");
	}


	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
