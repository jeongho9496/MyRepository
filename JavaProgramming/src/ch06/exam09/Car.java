package ch06.exam09;

public class Car {
	//0824
	//Field
	int gas;
	
	//Constructor
	
	//Method
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas(){//boolean이 리턴 타입일시 변수명 앞에 is를 써준다(관례)
		if (gas == 0) {
			System.out.println("가스가 없습니다.");
			return false;
		} else {
			System.out.println("가스가 있습니다.");
			return true;
		}
	}
	
	void run(){
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas 잔량: " + gas +")");
				gas--;
			} else {
				System.out.println("멈춥니다.(gas 잔량: " + gas +")");
				//break;//while부분만 빠져나감 메소드는 실행중
				return;//메소드 실행을 종료
			}
			
		}
	}
}
