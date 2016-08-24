package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {
		// 0823
		//Car 변수(참조타입) 선언 => 메소드 안에 선언 되있으므로 변수임.
		Car myCar = null;
		
		//객체 생성하고 위치 정보 얻기
		try {
			
			myCar = new Car();	//라이브러리 클래스의 생성자 실행
			
		} catch (Exception e) {}
		
		//객체가 있는지 조사
		if (myCar != null) {
			System.out.println("Car 객체 있음");
		} else {
			System.out.println("Car 객체 없음");
		}
		
		//객체 내부의 필드값을 읽어오기.
		System.out.println(myCar.company);
		
		//객체 내부의 필드값을 변경하기
		myCar.company = "KOSA";
		System.out.println(myCar.company);
		
		//객체 내부의 메소드를 호출하기
		myCar.run();
		System.out.println("------------------------------------");
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("차 모델 : " + myCar.model);
		System.out.println("차 색상 : " + myCar.color);
		System.out.println("최고 속도 : " + myCar.maxSpeed);
		System.out.println("현재속도 : " + myCar.speed);
		
		myCar.speed = 100;
		int speed = myCar.speed;
		speed++;
		System.out.println("수정된 속도 : " + speed);
	}

}
