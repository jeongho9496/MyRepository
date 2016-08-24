package ch06.exam10;

import java.util.Scanner;

public class CalculatorExample {

	public static void main(String[] args) {
		//0824
		Calculator myCalcu = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("길이1 : ");
		int line = scanner.nextInt();
		System.out.print("길이2 : ");
		int line2 = scanner.nextInt();
		
		double result1 = myCalcu.areaRectangle(line);
		System.out.println("정사각형의 넓이 : "+result1);
		
		double result2 = myCalcu.areaRectangle(line, line2);
		System.out.println("직사각형의 넓이 : "+result2);

	}

}
