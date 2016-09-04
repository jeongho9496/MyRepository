package ch09.exam06;

public class A {			//클래스 내부에서는 생성자, 필드, 메소드 순서 상관 하지 않는다.
	//0901
	int field = 10;
	public void method(){
								//메소드 내부에서는 실행 순서를 따진다.
		final int local = 10;	//로컬변수는 내부에서 실행하기 위해 final을 붙힌다. 메소드내부 클래스에 메소드로 복사된다.
		class B{				//매소드 안에 클래스를 구성하면 해당 클래스는 로컬변수가 된다. 로컬 변수 -> 메소드 밖에서 실행 불가
			void method(){
				field = 5;
				//local = 5; final 이므로 값 변경 불가
				int result = local + field;
			}
		}
		B b = new B();
		
	}
}
