package ch05.exam02;

public class AdvancedFor {

	public static void main(String[] args) {
		//0822
		int[] scores = {90,92,95};
		
		int sum = 0;
		/*for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		
		System.out.println(sum);*/
		
		for(int score : scores) { //scores에 있는 항목 수 만큼 반복하여 제일 앞에서 부터 가져와서 int score에 대입 해라
			sum += score;
		}
		System.out.println(sum);
		
		String[] names = {"자바", "C언어", "파이썬"};
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		for (String name : names){
			System.out.println(name);
		}
			
	}

}
