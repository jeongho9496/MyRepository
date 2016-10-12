package ch07.exam03;

public class Robot extends Machine {

	// 0829
	@Override // 부모의 메소드를 재정의 할시 제대로 맞게 했는지 체크하는 기능 ctrl + spacebar 로 부모 메소드 선택
	public void work() { // 접근 제한이 좁은것 부터 넓은건 가능하지만 넓은것 부터 좁은것으로는 불가능하다.

		System.out.println("Robot-work()실행");
	}

	@Override
	public void work2() {
		// TODO Auto-generated method stub
		super.work2();
	}

}
