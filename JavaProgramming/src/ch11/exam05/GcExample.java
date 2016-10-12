package ch11.exam05;

public class GcExample {

	public static void main(String[] args) {
		
		Employee emp = new Employee(1);	//객체 생성
		emp = null;	//객체 위치 정보를 가지고 있지 않음 -> 스레기 객체 생성
		emp = new Employee(2);	//emp Employee(2) 객체 참조 전에 참조한 Employee(1) GC
		emp = new Employee(3);	//emp Employee(3) 객체 참조 전에 참조한 Employee(2)는 GC가 된다.
		System.gc();
		

	}

}
