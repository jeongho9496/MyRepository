package ch09.exam10_extends;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymous anony = new Anonymous();
		anony.field.wake();	//익명 객체 필드 (Person field = new Person(){};) 사용
		anony.method1();	//익명 객체 로컬 변수 사용
		anony.method2(new Person(){	//익명 객체 매개값 사용
			void study(){
				System.out.println("공부함");
			}
			
			@Override
			void wake() {
				// TODO Auto-generated method stub
				System.out.println("8시에 일어난다.");
				study();//메소드 호출
			}
		});

	}

}
