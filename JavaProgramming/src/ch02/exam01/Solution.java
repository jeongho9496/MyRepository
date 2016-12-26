package ch02.exam01;

import java.math.BigInteger;

/*
	문자열 strNum과 s가 주어진다.
	strNum에 조건을 만족하는 가장 작은 수 answer를 더해서 나온 결과 값이 숫자
	s를 최소 1개이상 가지고 있게 해야 한다.
	수식으로 정리해서 말하면 strNum+answer=숫자 s를 최소 1개 이상 가지고 있는 수
	위의 조건을 만족하는 answer중 가장 작은 값을 리턴 하시오
	
	<제약 및 참고 사항>
    String 타입인 numString를 숫자로 변환 하면 10^100 보다는 작다.
    numString에는 오직 숫자만 들어 있다.('0'-'9').
    numString의 값은 항상 양수이다.
    numString는 앞에 '0'을 가지고 있지 않다.(항상 올바른 숫자 값이다.)
    s는 0부터 9의 숫자이다.
	
	ex) String strNum = "153"
	    int s = 7
	    153+0=153,153+1=154,153+2=155,153+3=156
	    153+4 = 157 => s(7)가 있으므로 result = 4를 출력
*/

public class Solution {

	public static void main(String[] args) {
		String strNum = "153";
		int s = 7;

		Solution sol = new Solution();
		sol.solution(strNum, s);
		//System.out.println(sol.solution(strNum, s));
		//sol.solution2(strNum, s);
		/*
		 * String[] split = strNum.split(""); System.out.println(split[2]);
		 */

	}

	public int solution(String strNum, int s) {
	       
		boolean flag = false;
		int answer = 0;
		BigInteger number = new BigInteger(strNum);
		//BigInteger = 숫자의 크기에 제한이 없다. 무한대의 정수를 저장할수 있음.
		//기본 자료형과 달이 사칙연산이 되지 않아 메소드(함수)를 호출하며 연산을 해야 한다.
		while (flag == false) {
			BigInteger temp = number.add(BigInteger.valueOf(answer));
			String str = ""+temp;
			for (int i = 0; i < str.length(); i++) {
				if (s == str.charAt(i) - '0') {
					//charAt() => charAt() 메소드는 괄호안에 있는 인덱스 위치의 문자를 반환하는 메소드이다.
					//charAt(i)-'0' => chatAt에서 찾은 문자열의 정수값과 0문자의 숫자값을 빼면 사용자가 찾는 숫자값이 나온다.
					//즉 문자상태인 숫자를 -'0'을 통해 숫자로 변환하는것.
					flag = true;
					return answer;
				}
			}
			answer ++;
		}
		return 0;
    }


	/*public int solution2(String numString, int s) {
		boolean flag = false;
		int answer = 0;
		BigInteger numBig = new BigInteger(numString);
		while (flag == false) {
			BigInteger temp = numBig.add(BigInteger.valueOf(answer));
			String str = temp + "";
			for (int i = 0; i < str.length(); i++) {
				if (s == str.charAt(i) - '0') {
					System.out.println(answer);
					flag = true;
					//break;
					return answer;
				}
			}
			answer ++;
		}
		return 0;
	}*/
	
}
