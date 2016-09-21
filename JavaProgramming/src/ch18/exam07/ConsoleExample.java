package ch18.exam07;

import java.io.Console;

public class ConsoleExample {
	//0921
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console console = System.console();
		
		System.out.print("아이디 : ");
		String id = console.readLine();//엔터 이전까지 저장한 데이터를 출력한다.
		
		System.out.print("패스워드 : ");
		char[] values = console.readPassword();	//콘솔창에 나오지 않지만 데이터는 출력한다.
		
		System.out.println("입력된 내용");
		System.out.println(id);
		System.out.println(values);

	}

}
