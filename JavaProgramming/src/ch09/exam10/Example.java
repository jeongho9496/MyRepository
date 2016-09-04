package ch09.exam10;

public class Example {
	//0901
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Parent p = new Parent();	//객체생성
		
		//익명클래스
		Parent p = new Parent(){
		//=> class XXX extends Parent{}	
		//자식클래스를 만드는 동시에 객체생성 후 자동 형변환
			
		};	
		
		//익명 인터페이스
		RemoteControl rc = new RemoteControl() {
		//=> class XXX implements RemoteControl{}	
		//구현클래스를 만드는 동시에 객체생성 후 자동 형변환	
			
		};
		

	}

}
