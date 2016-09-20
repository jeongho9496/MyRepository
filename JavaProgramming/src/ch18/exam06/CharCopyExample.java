package ch18.exam06;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharCopyExample {
	//0920
	public static void main(String[] args) throws IOException {
		String filePath = "src/ch18/exam06/data.txt";
		Reader reader = new FileReader(filePath);
		Writer writer = new FileWriter("src/ch18/exam06/data2.txt");
		
		char[] values = new char[100];
		int charNum = -1;
		while ((charNum = reader.read(values)) != -1) {
			writer.write(values, 0 , charNum);
			
		}
		
		writer.flush();
		writer.close();
		
		reader.close();
	}

}
