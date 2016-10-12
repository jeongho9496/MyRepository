package ch07.exam11;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent = new Child();//자동형변환
		parent.field1 = "data1";
		
		parent.method1();
		parent.method2();
		
		Child child = (Child)parent;//강제 형변환 * 자식객체로 부모 타입으로 자식 객체를 생성후 가능함.
		child.field2 = "yyy";
		child.method3();
	}

}
