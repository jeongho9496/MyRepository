package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputStreamExample {
	//0922
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일에서 객체 복원
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis); // 보조 스트림
		Member member2 = (Member)ois.readObject();
		
		fis.close();
		ois.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMpassword());
		System.out.println(member2.getMage());
		System.out.println(member2.getNation());//정적 데이터이므로 복원한 데이터가 아니라 기존 클래스에 있는 데이터이다.
	}

}
