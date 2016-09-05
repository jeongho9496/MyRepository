package ch11.exam10;

public class StringIndexOfExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String subject = "자바 프로그래밍 프나가";
		
		boolean result1 = subject.contains("자바");//String 저장된 문자열을 찾는 String메소드 boolean타입
		if (result1) {
			System.out.println("자바 책");
		} else {
			
			System.out.println("뭐 보냐!?");
		}
		
		int result2 = subject.indexOf("자바");//String 저장된 문자열을 찾는 String메소드 boolean타입//찾는 문자열이 없을 경우 -1 리턴 즉 false
		if (result2 != -1) {
			System.out.println("자바 책");
		} else {
			
			System.out.println("뭐 보냐!?");
		}
		
		int startIndex = subject.indexOf("자바");//중복 문자열은 제일 첫번째 단어를 찾는다.
		int endIndex = startIndex + 2;	// 잘라내고 싶은 문자열 숫자만큼 더해줘야 한다.
		String token1 = subject.substring(startIndex,endIndex);//subject.substring(인덱스 수 or indexof()로 찾은 문자,문자 수)
		System.out.println(token1);
		
		String find = "프로그래밍";
		startIndex = subject.indexOf(find);
		endIndex = startIndex + find.length();
		String token2 = subject.substring(startIndex,endIndex);
		System.out.println(token2);
		
		startIndex = subject.indexOf(find);
		String token3 = subject.substring(startIndex);
		System.out.println(token2);
	}

}
