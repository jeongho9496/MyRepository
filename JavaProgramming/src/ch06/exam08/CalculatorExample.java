package ch06.exam08;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCalc = new Calculator();
		
		myCalc.powerOn();
		
		int a = 45;
		int b = 20;
		
		int result = myCalc.plus(a, b);
		System.out.println("더한 값 : " + result);
		
		double result2 = myCalc.divide(a, b);
		System.out.println("나누기 값 : " + result2);
		
		myCalc.powerOff();
		

	}

}
