package ch04.exam01;

public class SwitchExample {

	public static void main(String[] args) {
		/*double d = Math.random();
		//Math.random() : 임의의 수를 추출하는 코드 범위 : 0.0 <= 임의의 수 <1.0
		d = d * 6;			// 0.0 <= 임의의 수 < 6.0
		int num = (int)d;	// 0 <= 임의의 수 < 6
		num = num + 1;*/	// 1 <= 임의의 수 < 7 
		
		int num = (int)(Math.random()*6)+1; // 1~6까지 랜덤 출력 ex)주사위
		//System.out.println(num);
		
		//int num = 3;
		
		switch (num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break; // 해당 값만 나오게 하고 싶을때 break 사용. 
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default:
			System.out.println("6번이 나왔습니다.");
		}

	}

}
