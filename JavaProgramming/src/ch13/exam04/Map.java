package ch13.exam04;

public interface Map<K, V> {
	//0908
	void add(K k,V v);
	
	V get(K k);//K타입의 매개값이 들어오면 리턴값으로 V 가 된다.

}
