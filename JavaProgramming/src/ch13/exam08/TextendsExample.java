package ch13.exam08;

public class TextendsExample {
	
	public void method1(C1<Integer> arg){}
	public void method2(C1<? extends Number>arg){}//C1에 있는 T타입을 제한할 목적으로 와일드카드 생성
	public C1<? extends Number> method3(){return null;}
//	public C1<T extends Number> method4(){return null;} 기존의 이미 T타입으로 정의 되있으므로 실행 불가
	
}

class C1 <T> {}	//T타입 선언
class C2 <T extends Number> {}//T를 새로 선언 하면서 Number를 자식으로 둠
class C3{
	public <T> void method(T t){}
	public <T extends Number> void method(T t){}
//	public <? extends Number> void method(T t){} 기존의 선언된 제네릭 타입이 없으므로 실행 불가
//	public C3<? extends Number> method(T t){return null;}
}