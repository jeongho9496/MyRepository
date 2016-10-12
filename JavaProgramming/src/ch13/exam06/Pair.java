package ch13.exam06;

public class Pair<K, V> {
	//0908
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}
