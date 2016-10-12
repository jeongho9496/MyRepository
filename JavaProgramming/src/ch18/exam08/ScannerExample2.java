package ch18.exam08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerExample2 {
	//0921
	public static void main(String[] args) throws FileNotFoundException {
		InputStream is = new FileInputStream("src/ch18/exam08/data.txt");
		Scanner scanner = new Scanner(is);
		
		int age = Integer.parseInt(scanner.nextLine());//숫자정수(문자) 읽어 오기
		String name = scanner.nextLine();//문자 읽어 오기 입력 안할시 대기 상태
		double height = Double.parseDouble(scanner.nextLine());//숫자실수(문자) 읽어 오기
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		
		
	}

}
