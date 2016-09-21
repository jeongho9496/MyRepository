package ch18.exam10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamExample {
	//0921
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/ch18/exam10/Lighthouse.jpg");	//파일 데이터 읽어오기
		FileOutputStream fos = new FileOutputStream("src/ch18/exam10/Lighthouse2.png");	//파일로 데이터 출력하기
		
		byte[] values = new byte[1024];
		
		int byteNum;
		while ((byteNum = fis.read(values)) != -1) {
			fos.write(values, 0, byteNum);
		}
		
		fos.flush();
		
		fos.close();
		fis.close();
	}

}
