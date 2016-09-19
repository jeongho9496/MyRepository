package ch15.exam04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertiesExample {
	//0919
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Locale currentLocal = Locale.getDefault();
		String path = null;
		System.out.println(currentLocal);
		currentLocal = Locale.US;
		
		if (currentLocal == Locale.KOREA) {
			System.out.println("한국");
			path = PropertiesExample.class.getResource("ko.properties").getPath();
			System.out.println(path);
		} else if(currentLocal == Locale.US) {
			System.out.println("미국");
			path = PropertiesExample.class.getResource("en.properties").getPath();
		} else if(currentLocal == Locale.CANADA) {
			System.out.println("캐나다");
		}
		
		//Map properties = new Properties();
		Properties properties = new Properties();//Map 타입이긴 하지만 Properties로 받아야함.
		properties.load(new FileReader(path));
		
		String apptitle = properties.getProperty("apptitle");
		System.out.println(apptitle);
		String join = properties.getProperty("btnJoin");
		System.out.println(join);
		String cancel = properties.getProperty("btnCancel");
		System.out.println(cancel);
		String login = properties.getProperty("btnLogin");
		System.out.println(login);
	}

}
