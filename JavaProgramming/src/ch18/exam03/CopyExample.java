package ch18.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	//0920
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = CopyExample.class.getResource("Lighthouse.jpg").getPath();
		System.out.println(filePath);
		
		InputStream is = new FileInputStream(filePath);
		OutputStream os = new FileOutputStream("src/ch18/exam03/Test.jpg");
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while ((byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);	//출력시 받아온 데이터 만큼만 출력해야 하므로 데이터 크기(byteNum)만큼만 출력한다.
		}
		
		os.flush();
		
		os.close();
		is.close();
		
		
		
		
		
	}

}
