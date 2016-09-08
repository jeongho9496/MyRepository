package ch13.exam04;

public class HashMap<K, V> implements Map<K, V>{
	//0908
	private K k;
	private V v;
	
	@Override
	public void add(K k, V v) {
		// TODO Auto-generated method stub
		this.k = k;
		this.v = v;
		
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		if (this.k == k) {
			
			return v;
			
		}
		
		return null;
	
	}
	

}
