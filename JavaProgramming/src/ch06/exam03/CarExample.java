package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {
		// 0823
		//Car 변수 선언 => 메소드 안에 선언 되있으므로 변수임.
		Car myCar = null;
		
		//객체 생성하고 위치 정보 얻기
		try {
			
			myCar = new Car();
			
		} catch (Exception e) {}
		
		//객체가 있는지 조사
		if (myCar != null) {
			System.out.println("Car 객체 있음");
		} else {
			System.out.println("Car 객체 없음");
		}
		
		//객체 내부의 필드값을 읽어보자.
		System.out.println(myCar.company);
		
		//객체 내부의 필드값을 변경하기
		myCar.company = "KOSA";
		System.out.println(myCar.company);
		
		//객체 내부의 메소드를 호출하기
		myCar.run();
	}

}
