package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	//0921
	public static void main(String[] args) throws IOException {
		long start = 0;
		long end = 0;
		
		FileInputStream fis = new FileInputStream("src/ch18/exam12/Chrysanthemum.jpg");	//파일 파일 읽어오기
		FileOutputStream fos = new FileOutputStream("src/ch18/exam12/Chrysanthemum2.jpg");	//파일로 데이터 출력하기
		
		int value;
		
		start = System.currentTimeMillis();//10의 -6승
		while ((value = fis.read()) != -1) {
			fos.write(value);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		fos.flush();
		
		fos.close();
		fis.close();
		
		//------------------------------------------------------------------------------------
		FileInputStream fis2 = new FileInputStream("src/ch18/exam12/Chrysanthemum.jpg");	//파일 파일 읽어오기
		BufferedInputStream bis = new BufferedInputStream(fis2);//보조 스트림
		
		FileOutputStream fos2 = new FileOutputStream("src/ch18/exam12/Chrysanthemum2.jpg");	//파일로 데이터 출력하기
		BufferedOutputStream bos = new BufferedOutputStream(fos2);//보조 스트림
		
		start = System.currentTimeMillis();//10의 -6승
		while ((value = bis.read()) != -1) {
			bos.write(value);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		bos.flush();
		
		bos.close();
		bis.close();
		fos2.close();
		fis2.close();
	}

}
