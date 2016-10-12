package ch10.exam01;

import java.util.Scanner;

public class Example1 {
	//0901
	public static void main(String[] args) {
//		Object obj = new Object();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {	//무한 반복
			
			try {	//try block
				System.out.print("입력 : ");
				String data = scanner.nextLine();
				int value = Integer.parseInt(data);	//NumberFormatException 예외 발생
				System.out.println(data);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("예외처리 발생 => " + e.toString());
			} finally {
				System.out.println("무조건 실행");
			}
			
		}

	}

}
