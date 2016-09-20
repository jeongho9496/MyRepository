package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	//0920
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = InputStreamExample.class.getResource("data.txt").getPath();//data.txt 실제경로를 얻는다.
		System.out.println(filePath);
		
		int count = 0;
		//파일 데이터 읽어 오기
		InputStream inputStream = new FileInputStream(filePath);
		/*while (true) {
			int value = inputStream.read();
			if (value == -1)break;
			count ++;
		}
		System.out.println("읽은 횟수 : "+count);
		inputStream.close();
		*/
		System.out.println();
		
		count = 0;
		inputStream = new FileInputStream(filePath);
		int value = -1;
		while ((value=inputStream.read()) != -1) {
			System.out.println(value);
			count++;
			
		}
		
		System.out.println("읽은 횟수 : "+count);
		inputStream.close();
	}

}
