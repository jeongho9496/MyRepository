package ch18.exam11;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class OutputStreamWriterExample {

	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		//문자 출력하기
		String data = "가";
		
		//보조 스트림 사용 X
		
		/*byte[] values = data.getBytes();
		for (int i = 0; i < values.length; i++) {
			os.write(values[i]);
		}
		
		os.flush();*/
		
		
		//보조스트림 사용
		Writer writer = new OutputStreamWriter(os);
		writer.write(data);
		writer.flush();
		writer.close();
		
		Scanner scanner = new Scanner(System.in);
		
		int a = Integer.parseInt(scanner.nextLine());
	}

}
