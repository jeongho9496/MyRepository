package ch12.exam02;

public class ThreadC extends Thread {
	//0906
	public ThreadC(int num){
		setName("ThreadC-"+num);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 200000000; i++) {
			String str = "a";
			str += "b";
			str += "c";
		}
		System.out.println(getName() + "종료");
	}
}
