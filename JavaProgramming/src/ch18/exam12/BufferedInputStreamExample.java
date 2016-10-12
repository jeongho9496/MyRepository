package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
	// 0921
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = 0;
		long end = 0;

		FileInputStream fis = new FileInputStream("src/ch18/exam12/Chrysanthemum.jpg");

		start = System.currentTimeMillis();

		while (fis.read() != -1) {
		}
		end = System.currentTimeMillis();

		System.out.println(start);
		System.out.println(end);
		System.out.println(end - start);
		System.out.println();

		// 보조스트림(BufferedInputStream)사용
		FileInputStream fis2 = new FileInputStream("src/ch18/exam12/Chrysanthemum.jpg");

		BufferedInputStream bis = new BufferedInputStream(fis2);

		start = System.currentTimeMillis();

		while (bis.read() != -1) {
		}
		end = System.currentTimeMillis();

		System.out.println(start);
		System.out.println(end);
		System.out.println(end - start);
	}

}
