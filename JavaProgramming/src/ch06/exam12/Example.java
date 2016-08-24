package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//0824
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
		System.out.println(im.field);
//		im.field = "자바";//객체 안에 저장
		im.method();	//객체 안에서 호출
		
		
		System.out.println("-------------static block 실행---------------");
		//Static Member 사용
//		StaticMember sm; 변수만 사용시 메모리 적제가 안되므로 static block 실행이 안된다.
		StaticMember sm = new StaticMember();
		System.out.println(StaticMember.field);
//		StaticMember.field = "자바";
//		StaticMember.method();
		
	}

}
