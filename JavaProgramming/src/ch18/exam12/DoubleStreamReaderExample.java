package ch18.exam12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class DoubleStreamReaderExample {
	//0921
	public static void main(String[] args) throws IOException {
		/*InputStream is = System.in;	//콘솔로 입력하는 문자는 데이터 끝이 없다 . 즉 read가 -1을 리턴 안한다.
		//문자열 출력
		//보조 스트림사용
		Reader reader = new InputStreamReader(is);//문자 입력 스트림으로 변환
		
		while(true){
			int value = reader.read();
			if (value == 13) break;
			char data = (char) value;
			System.out.print(data);
		}*/
		
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		String data = br.readLine();	//캐리지리턴(\r\n)기준으로 한 행씩 읽음
		
		System.out.println(data);
		
	}

}
