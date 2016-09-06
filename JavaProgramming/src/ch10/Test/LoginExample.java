package ch10.Test;

public class LoginExample {
	public static void main(String[] args) {
		try {
			login("white", "1111");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			login("blue", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static void login(String id, String password)throws Exception{
		if (!id.equals("blue")) {
			NotExistIDException exception = new NotExistIDException(id);
		}
		if (!password.equals("12345")) {
			WrongPaswordException exception = new WrongPaswordException(password);
		}
		
		
		
	}
}

