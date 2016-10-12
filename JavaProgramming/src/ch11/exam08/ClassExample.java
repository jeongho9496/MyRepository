package ch11.exam08;

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//Class classCar = Car.class;	//클래스.class -> Car코드에 저장된 메모리 번지 저장. 로깅할때 사용 방법 1
		//Class classCar = Class.forName("ch11.exam08.Car");	//데이터 베이스 연동 방법2
		Car car = new Car();	//방법3
		Class classCar = car.getClass();
		
		System.out.println(classCar.getName());
		
		System.out.println(classCar.getSimpleName());//클래스 이름만 호출
		
		System.out.println(classCar.getPackage().getName());
	}

}
