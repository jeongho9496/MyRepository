package ch18.exam02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
	//0920
	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		OutputStream os = new FileOutputStream("src/ch18/exam02/data1.txt");
		//new FileOutputStream(출력할 경로 지정) "src/ch18/exam02/data.txt" -> 상대경로
		String data = "abcdefghij";
		byte[] values = data.getBytes();
		os.write(values);
		os.flush();
		os.close();
		
		/*os = new FileOutputStream("src/ch18/exam02/data2.txt");
		for (int i = 0; i < values.length; i++) {
			os.write(values[i]);//1byte씩 처리
		}
		os.flush();
		os.close();*/
		

	}

}
