package ch18.exam14;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamExample {
	//0922
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("src/ch18/exam14/data.txt");
		PrintStream ps = new PrintStream(fos);	//문자형식으로 보낸다
		
		ps.println(10);
		ps.println(true);
		ps.println(5.3);
		ps.println("java");
		
		ps.flush();
		
		ps.close();
		fos.close();
		
		FileReader fr = new FileReader("src/ch18/exam14/data.txt");
		BufferedReader br = new BufferedReader(fr);
		int v1 = Integer.parseInt(br.readLine());
		boolean v2 = Boolean.parseBoolean(br.readLine());
		double v3 = Double.parseDouble(br.readLine());
		String v4 = br.readLine();
		
		br.close();
		fr.close();
		
		System.out.println(v1 + " " + v2 +" " +v3+ " "+v4);

	}

}
