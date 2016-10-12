package ch05.exam03;

import java.util.Scanner;

public class ReplaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String abc = "asdf";
		System.out.println(abc);
		System.out.print("글수정:");
		String test = scanner.nextLine();
		abc = test;
		System.out.println(abc);
	}

}
