package ch06.Test;

public class MemberService15 {
	public boolean login(String id, String password) {
		if (id.equals("hong")&& password.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void logOut(String id){
		System.out.println("로그아웃 되었습니다");
	}
}
