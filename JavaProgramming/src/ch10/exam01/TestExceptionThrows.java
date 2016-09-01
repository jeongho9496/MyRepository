package ch10.exam01;

public class TestExceptionThrows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			method3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("오류");
		}

	}

	private static void method3() throws Exception{
		// TODO Auto-generated method stub
		method2();
	}

	private static void method2() throws Exception{
		// TODO Auto-generated method stub
			method1();
		
	}

	private static void method1() throws Exception{
		
		int abc = Integer.parseInt("abc10");
		/*try {
			
			int abc = Integer.parseInt("abc10");
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생"+ e.toString());
		}*/
		
	}

}
