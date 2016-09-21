package ch18.exam11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	//0921
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		//문자열 출력
		//보조 스트림사용
		Reader reader = new InputStreamReader(is);//문자 입력 스트림으로 변환
		char data = (char) reader.read();
		System.out.println(data);
		
		//보조 스트림 사용 X
		/*byte[] values = new byte[100];
		int byteNum = is.read(values);
		String data2 = new String(values, 0, byteNum-2);
		System.out.println(data2);*/

	}

}
