package ch05.exam02;

public class MainArgument {

	public static void main(String[] args) {
		//0822
		//java MainArgument 3 4 얻기
		String v1 = args[0];
		String v2 = args[1];
		
		int intV1 = Integer.parseInt(v1);	//문자열을 숫자(int형)으로 변환해준다. (*단 문자열이 숫자여야한다.)
											//Integer.parseInt(v1 -> 매개값) -> 메소드 호출
		int intV2 = Integer.parseInt(v2);
 		
		int result = intV1 + intV2;
		System.out.println("result = " + result);
	}

}
