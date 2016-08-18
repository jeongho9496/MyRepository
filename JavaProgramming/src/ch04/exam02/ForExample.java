package ch04.exam02;

public class ForExample {

	public static void main(String[] args) {
		/*int sum = 0;	
		
		for (int i = 1; i <= 10; i++) {	//for(;;) 조건식이 없으면 무조건 true로 인식 => 무한 루프 
										//증감식에 식이 없다면 무한 루프를 돈다.
			if (i % 2 == 0) {
				sum = sum + i;	
				//(=> sum += i;)
			}
		}
		
		System.out.println(sum);*/
		/*int sum = 0;
		int total = 0;
		float avg = 0;
		for (int i = 1; i <=3 ; i++) {
			sum = (int)(Math.random()*6)+1;
			System.out.println(sum);
			total += sum;
			avg = (float)total/i;
		}
	
		System.out.println("총합 : " + total +" , "+"평균 : "+avg);*/
		
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			sum += num;
		}
		System.out.println("눈의 합 : " + sum);
		double avg = sum/3.0;
		System.out.println("눈의 평균 : " + avg);
	}

}
