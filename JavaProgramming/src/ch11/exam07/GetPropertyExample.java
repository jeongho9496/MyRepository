package ch11.exam07;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String osName = System.getProperty("os.name");
		System.out.println(osName);			//운영체제
		
		String userName = System.getProperty("user.name");
		System.out.println(userName);		//사용자 계정
		
		String userHome = System.getProperty("user.home");
		System.out.println(userHome);		//사용자 홈 디렉토리
		System.out.println("---------------------------------------");

		
		Properties props = System.getProperties();
		
		Set keys = props.keySet();
		
		for (Object objKey : keys) {
			String key = (String)objKey;
			System.out.print(key);
			System.out.print(": ");
			
			String value = System.getProperty(key);
			System.out.println(value);
		}
	}

}
