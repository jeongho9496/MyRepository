package ch18.exam10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
	//0921
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/ch18/exam10/NAVER.html");	//텍스트 파일 데이터 읽어오기
		FileWriter fw = new FileWriter("src/ch18/exam10/NAVERcopy.html");	//텍스트 파일로 데이터 출력하기
		
		char[] values = new char[1024];
		
		int charNum;
		while ((charNum = fr.read(values)) != -1) {
			fw.write(values, 0, charNum);
		}
		
		fw.flush();
		
		fw.close();
		fr.close();
	}

}
