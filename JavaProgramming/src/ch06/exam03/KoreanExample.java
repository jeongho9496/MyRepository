package ch06.exam03;

import java.util.Scanner;

public class KoreanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Korean ko = new Korean("", "");
		Korean ko2 = new Korean("", "");
		
//		ko.name = "이해해";
//		ko.ssn = "891006-1066918";
		
		System.out.print("이름 입력 : ");
		String name = scanner.nextLine();
		System.out.print("주민 번호 입력 : ");
		String ssn = scanner.nextLine();
		
		ko.name = name;
		ko.ssn = ssn;
			
		System.out.println("국적 : " + ko.nation);
		System.out.println("이름 : " + ko.name);
		System.out.println("주민 번호 : " + ko.ssn);

		System.out.print("이름 입력 : ");
		name = scanner.nextLine();
		System.out.print("주민 번호 입력 : ");
		ssn = scanner.nextLine();
		
		ko2.name = name;
		ko2.ssn = ssn;
		
		System.out.println("국적 : " + ko2.nation);
		System.out.println("이름 : " + ko2.name);
		System.out.println("주민 번호 : " + ko2.ssn);

	}

}
