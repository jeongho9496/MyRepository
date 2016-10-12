package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		//------------------혼자 생각 했을 때-----------------------------------
		/*int y=0;									//int 타입 y 변수 선언
		for (int x = 1; x <= 10; x++) {				//x를 1~10까지 반복하는 반복문
			y=1;									//y에 1대입
			if (4*x + 5*y == 60) {					//if (4*x + 5*y == 60) 이면
				System.out.println("("+x+","+y+")");//if조건에 해당하면 x,y 값 출력
			}										//y가 1~10일때 까지 반복 작성
			y=2;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=3;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=4;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=5;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=6;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=7;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=8;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=9;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}
			y=10;
			if (4*x + 5*y == 60) {
				System.out.println("("+x+","+y+")");
			}	
				
		}*/
		
		//------------------팀원들과  생각하여 만든 code-----------------------------------
		  
	      for(int x=1;x<=10;x++){	//1~10까지의 x범위에 대한 for문
	         if((60-4*x)%5 ==0){	//4x+5y = 60 가 성립하기 위한 조건문 (=> y = (60-4*x)/5)
	        	int y = (60-4*x)/5; //y값 저장
	            System.out.println("("+x+","+y+")");
	            //조건에 해당하는 x,y 값 출력
	         }
	      }
		
		//-----------------------------------------------------------------------
		
	}

}
