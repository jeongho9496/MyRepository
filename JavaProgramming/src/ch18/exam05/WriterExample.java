package ch18.exam05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
	//0920
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Writer writer = new FileWriter("src/ch18/exam05/data.txt");
		
		String data = "날씨가 지금 같으면 좋겠습니다.";
		
		/*char[] values = data.toCharArray();	//.toCharArray() -> String 배열을 받을때 사용
		writer.write(values);*/
		
		writer.write(data);
		writer.flush();
		
		writer.close();

	}

}
