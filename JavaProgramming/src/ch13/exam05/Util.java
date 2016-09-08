package ch13.exam05;

public class Util {
	//0908
	public static <T> Box <T> boxing(T t){//public static <T>/*컴파일러가 찾을수 없기 때문에 명시*/ Box<T> boxing(T t){ => 타입이 결정되지 않으면 리턴 타입 앞에 타입을 명시 해주어야 한다.
		Box<T> box = new Box<T>();
		box.setItem(t);
		return box;
	}
}
