package ch04.exam03;

public class ContinueExample {

	public static void main(String[] args) throws Exception {
		//키보드로 부터 1(키코드 : 49)~3(키코드 : 51)사이의 번호 이외의 번호가 입력되면 다시 입력을 하도록 하게 하기
		while (true) {
			int num = System.in.read();
			if (num < 49 || num > 51) {	// || 또는 
				continue;
			}
			System.out.println(num);
		}
	}

}
