package ch13.exam05;

public class Box<T> {//타입 지정 안할시 Object로 설정된다.
	//0908
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}	

}
