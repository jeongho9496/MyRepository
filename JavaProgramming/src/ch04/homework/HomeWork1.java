package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {				//100번 실행하는 반복문
			int di1 = (int) (Math.random() * 6) + 1;	//1번 주사위 생성
			int di2 = (int) (Math.random() * 6) + 1;	//2번 주사위 생성
			if (di1 + di2 == 10) {						//조건식
				System.out.println("(" + di1 + "," + di2 + ")");
				//if문이 true 이면 di1,di2 값 출력
			}

		}
	}

}
