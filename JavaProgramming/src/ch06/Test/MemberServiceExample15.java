package ch06.Test;

public class MemberServiceExample15 {
	public static void main(String[] args) {
		
		MemberService15 memberService = new MemberService15();
		boolean result = memberService.login("hong", "12345");
		if (result) {
			System.out.println("로그인 성공");
			memberService.logOut("hong");
		} else{
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
