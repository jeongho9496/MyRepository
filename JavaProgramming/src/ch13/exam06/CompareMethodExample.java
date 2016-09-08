package ch13.exam06;

public class CompareMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String,String> p1 = new Pair<String,String>("name","홍길동");
		Pair<String,String> p2 = new Pair<String,String>("name","김가을");
//		Pair<int,int> p2 = new Pair<int,int>(1,2);
		
		boolean result = Util.compare(p1, p2);
		System.out.println(result);

	}

}
