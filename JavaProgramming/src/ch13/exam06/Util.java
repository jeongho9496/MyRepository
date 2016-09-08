package ch13.exam06;

public class Util {
	//0908
	public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){//매개변수의 구체적인 타입을 정의 안하면 Object로 바뀐다(경고 표시)
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = String.valueOf(p1.getValue()).equals(String.valueOf(p2.getValue()));
		
		return keyCompare && valueCompare;
	}
	
	public static <K,V> Pair<K,V> max(Pair<K,V> p1, Pair<K,V> p2){
		
		return  p2;
	}
	
	
}
