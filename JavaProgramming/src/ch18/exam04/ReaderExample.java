package ch18.exam04;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderExample {
	//0920
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader reader = new FileReader("src/ch18/exam04/data.txt");
		String data = "";
		int value = -1;
		int count = 0;
		while ((value = reader.read()) != -1) {
			count ++;
			char ch = (char)value;
			data += ch;
		}
		
		reader.close();
		System.out.println(count);
		System.out.println(data);
		
		
		reader = new FileReader("src/ch18/exam04/data.txt");
		data = "";
		char[] values = new char[2];
		int charNum = -1;
		count = 0;
		while ((charNum = reader.read(values)) != -1) {
			count ++;
			data += new String(values, 0, charNum);	//입력 스트림으로부터 charNum개의 문자만큼 읽고 매개 값으로 주어진 데이터 크기만큼 데이터 배열을 저장한다.
		}
		
		reader.close();
		System.out.println(count);
		System.out.println(data);
	}

}
