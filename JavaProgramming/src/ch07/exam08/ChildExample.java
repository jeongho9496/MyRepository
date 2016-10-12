package ch07.exam08;

public class ChildExample {
	//0830
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		System.out.println();
		
		Parent parent = child;
		parent.method1();
		parent.method2();	//자식 클래스에서 재정의한 메소드 호출

	}

}
