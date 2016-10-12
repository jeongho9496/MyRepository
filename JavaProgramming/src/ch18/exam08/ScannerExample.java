package ch18.exam08;

import java.util.Scanner;

public class ScannerExample {
	//0921
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.nextLine();//문자 읽어 오기 입력 안할시 대기 상태
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(scanner.nextLine());//숫자정수(문자) 읽어 오기
//		int age = scanner.nextInt()//숫자정수 읽어 오기

		System.out.print("키 : ");
		double height = Double.parseDouble(scanner.nextLine());//숫자실수(문자) 읽어 오기
//		double height = scanner.nextDouble();//숫자실수 읽어 오기
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		
		
	}

}
