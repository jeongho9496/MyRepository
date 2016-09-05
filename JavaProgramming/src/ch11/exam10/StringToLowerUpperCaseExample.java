package ch11.exam10;


public class StringToLowerUpperCaseExample {
	//0905
	public static void main(String[] args) {
		String oldStr = "Java Programming";
		String newStr = oldStr.toLowerCase();	//새로운 문자열을 만들어 사용.
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
		
		System.out.println(oldStr.equals("JAVA programming"));
		System.out.println(oldStr.toLowerCase().equals("JAVA programming".toLowerCase()));//메소드 체이닝
		System.out.println(oldStr.toUpperCase().equals("JAVA programming".toUpperCase()));//메소드 체이닝
		
		String targetStr = "             Java Programming        ";
		System.out.println(oldStr == targetStr);
		System.out.println(oldStr.equals(targetStr));
		System.out.println(oldStr.equals(targetStr.trim()));
	}
}
