package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderStreamExample {
	// 0921
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = 0;
		long end = 0;

		FileReader fr = new FileReader("src/ch18/exam12/NAVER.html");

		start = System.nanoTime();//실행 시간

		while (fr.read() != -1) {
		}
		end = System.nanoTime();//fr.read()로 데이터 읽고 난 후 시간

		System.out.println(start);
		System.out.println(end);
		System.out.println(end - start);
		System.out.println();

		// 보조스트림(BufferedInputStream)사용
		FileReader fr2 = new FileReader("src/ch18/exam12/NAVER.html");

		BufferedReader bis = new BufferedReader(fr2);

		start = System.nanoTime();

		while (bis.read() != -1) {
		}
		end = System.nanoTime();

		System.out.println(start);
		System.out.println(end);
		System.out.println(end - start);
	}

}
