package ch13.exam07;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r1 =  Util.compare(30, 20);		//boxing
		int r2 =  Util.compare(10, 20.5);	//boxing
		int r3 =  Util.compare(new Integer(10), 20);		//boxing
		System.out.println(r1);
	}

}
