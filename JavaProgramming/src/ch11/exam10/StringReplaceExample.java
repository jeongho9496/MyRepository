package ch11.exam10;


public class StringReplaceExample {
	//0905	p506
	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 Api를 지원합니다.";
		String newStr = oldStr.replace("자바", "**");	//새로운 문자열을 만들어 배치.
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
		//replace() => replace하면 새로운 문자열을 만들기 때문에 비교 연산자가 false가 된다.
	}
}
