package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
	//0922
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 파일에 객체 저장
		FileOutputStream fos = new FileOutputStream("src/ch18/exam15/data.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos); // 보조 스트림
		
		Member member = new Member("devil", "이명진", "12345", 26);
		oos.writeObject(member);
		
		oos.flush();
		oos.close();
		fos.close();

	}

}
