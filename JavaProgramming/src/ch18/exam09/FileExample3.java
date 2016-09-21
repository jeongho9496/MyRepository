package ch18.exam09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample3 {
	// 0921
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File root = new File("C:/");
		File[] contents = root.listFiles();
		
		for (File file : contents) {
			if (file.isDirectory()) {
				System.out.print("<DIR>");
			} else {
				System.out.println(file.length());//file size 조사
				
			}
			System.out.print("\t\t\t");
			System.out.println(file.getName());
		}
		
	}

}
