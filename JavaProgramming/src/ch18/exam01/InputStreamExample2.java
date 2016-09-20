package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamExample2 {
	//0920
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = InputStreamExample2.class.getResource("data.txt").getPath();//data.txt 실제경로를 얻는다.
		System.out.println(filePath);
		
		int count = 0;
		InputStream inputStream = new FileInputStream(filePath);
		byte[] values = new byte[3];
		/*while (true) {
			int byteNum = inputStream.read(values);	//읽은 바이트수 대입
			if (byteNum == -1)break;
			System.out.println(byteNum + " : " + Arrays.toString(values));
			count ++;
		}
		System.out.println("읽은 횟수 : "+count);
		inputStream.close();*/
		
		inputStream = new FileInputStream(filePath);
		count = 0;
		values = new byte[3];
		int byteNum = -1;	//초기값 설정
		while ((byteNum = inputStream.read(values)) != -1 ) {
			System.out.println(byteNum + " : " + Arrays.toString(values));
			count ++;
		}
		System.out.println("읽은 횟수 : "+count);
		inputStream.close();
		
		
	}

}
