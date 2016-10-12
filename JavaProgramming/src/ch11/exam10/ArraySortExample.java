package ch11.exam10;

import java.util.Arrays;

public class ArraySortExample {
	//0905	p521
	public static void main(String[] args) {
		int[] scores = {99, 97, 98};
		
		Arrays.sort(scores);	//배열 정렬 default : 오름차순
		System.out.println(Arrays.toString(scores));
		
		Member2[] members = {
			new Member2("홍길동",99),	
			new Member2("박동수",95),	
			new Member2("김민수",80)	
		};
		
		Arrays.sort(members);//compareTo 호출
		
		System.out.println(Arrays.toString(members));

	}

}

class Member2 implements Comparable{//Comparable - 비교 인터페이스
	
	String name;
	int score;
	
	Member2(String name) {
		this.name = name;
	}
	
	Member2(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Object o) {//Comparable 구현시 필수로 overriding
		// TODO Auto-generated method stub
//		System.out.println("compareTo");
		Member2 target = (Member2) o;
		return this.score-target.score;
		//오름 차순 일때 자신이 매개값보다 낮을 경우 음수,같을경우 0, 높을경우 양수 리턴
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
