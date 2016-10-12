package ch07.exam04;

public class Robot extends Machine {

	// 0829
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("robot-work() 실행");
		super.work();	//부모에서 작성한 메소드 실행
	}

}
