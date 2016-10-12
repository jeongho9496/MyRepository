package ch18.exam13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamExample {
	//0922
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutputStream("src/ch18/exam13/data.db");
		
		int v1 = 100;
		boolean v2 = true;
		double v3 = 5.3;
		String v4 = "java";
		
		DataOutputStream dos =  new DataOutputStream(fos);	//보조스트림
		dos.writeInt(v1);
		dos.writeBoolean(v2);
		dos.writeDouble(v3);
		dos.writeUTF(v4);
		
		dos.flush();
		dos.close();
		
		//--------------------------------------------------------------------------------------------
		
		FileInputStream fis = new FileInputStream("src/ch18/exam13/data.db");
		DataInputStream dis = new DataInputStream(fis);	//보조스트림
		
		int v5 = dis.readInt();	//파일에 들어있는 데이터 순서대로 읽는다.
		boolean v6 = dis.readBoolean();
		double v7 = dis.readDouble();
		String v8 = dis.readUTF();
		
		System.out.println(v5 +" "+v6 +" "+ v7 +" "+ v8);
		
		dis.close();

	}

}
