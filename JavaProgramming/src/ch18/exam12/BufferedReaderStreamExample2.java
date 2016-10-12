package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderStreamExample2 {
	// 0921
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = new FileReader("src/ch18/exam12/NAVER.html");

		BufferedReader br = new BufferedReader(fr);
		
		int count = 0;
		while (true) {
			String line = br.readLine();//br.readLine() => 행 단위로 문자열 읽기. 행 단위로 읽다가 데이터가 없으면 null을 검사 한다.
			if(line == null)break;
			System.out.println((++count)+ " : " + line);
		}

	}

}
