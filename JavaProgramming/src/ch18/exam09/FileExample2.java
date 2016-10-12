package ch18.exam09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {
	// 0921
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:/Temp/dir1/dir2/data3.txt");
		file.getParentFile().mkdirs();
		file.createNewFile();
		/*File parentDir = file.getParentFile();
		parentDir.mkdirs();
		file.createNewFile();*/
		
		System.out.println(new Date(file.lastModified()));
	}

}
