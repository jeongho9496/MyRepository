package ch13.exam06;

public class CompareMethodExample2 {

	public static void main(String[] args) {
		//0907
		Pair<String,String> p1 = new Pair<String,String>("name","홍길동");
		Pair<String,String> p2 = new Pair<String,String>("name","김가을");
		
		Pair<String,String> result1 = Util.max(p1, p2);
		
		boolean result = Util.compare(p1, p2);
		
		System.out.println(result);
		System.out.println(result1.getValue());
		
		Pair<String,Integer> p3 = new Pair<String,Integer>("name",10);
		Pair<String,Integer> p4 = new Pair<String,Integer>("name",30);
		
		Pair<String,Integer> resultInt = Util.max(p3, p4);//두번째 매개값 리턴
		
		boolean resultInt2 = Util.compare(p3, p4);//값 비교
		
		System.out.println(resultInt2);
		System.out.println(resultInt.getValue());
	}

}
