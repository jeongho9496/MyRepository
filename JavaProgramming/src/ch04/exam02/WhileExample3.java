package ch04.exam02;

public class WhileExample3 {

	public static void main(String[] args) throws Exception { //throws Exeception => System.in.read() 사용하기 위해 필요함.
		// TODO Auto-generated method stub
		
		while (true) {
			int num = System.in.read(); //System.in(메소드 위치).read()(메소드 이름); 메소드 호출
										//=> 키보드에서 입력된 키를 읽고 키번호를 만들어서 리턴해준다.
			
			if (num != 13 && num != 10) { //num!=13 num 이 13번이 아니다. 
			
				System.out.println(num); //*Enter 키코드가 13, 10인 이유 Enter는 키 하나지만 캐리지리턴(13) - 줄 초기화 -> 맨 왼쪽으로 이동라인피드(10) - 한 줄 넘김 -> 아래로 이동

			}
		}
	}

}
