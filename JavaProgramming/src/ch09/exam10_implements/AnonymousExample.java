package ch09.exam10_implements;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 익명 객체 필드 사용
		Anonymous anony = new Anonymous();
		anony.field.turnOn();
		anony.field.turnOff();
		
		System.out.println();
		
		// 익명 객체  로컬 변수  사용
		anony.method1();
		
		System.out.println();
		
		//익명 객체 매개값 사용
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("SmartTv를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("SmartTv를 끕니다.");
				
			}
		});
		

	}

}
