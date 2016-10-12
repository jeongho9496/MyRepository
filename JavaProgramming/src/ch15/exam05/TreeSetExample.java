package ch15.exam05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	//0920
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();//값을 비교 하여 작은 건 왼쪽 큰 건 오른쪽
		
		scores.add(87);
		scores.add(98);
		scores.add(65);
		scores.add(72);
		scores.add(12);
		
		int firstScore = scores.first();	//가장 작은 값 출력
		System.out.println("가장 작은 값 출력 : "+firstScore);
		
		int lastScore = scores.last();		//가장 큰 값 출력
		System.out.println("가장 큰 값 출력 : "+lastScore);
		System.out.println();
		
		int lowerScore = scores.lower(87);//87에 가장 근접한 값 중 바로 아래 값
		System.out.println("87에 가장 근접한 값 중 바로 아래 값 : "+lowerScore);

		int higherScore = scores.higher(87);//87에 가장 근접한 값 중 바로 윗 값
		System.out.println("87에 가장 근접한 값 중 바로 아래 값 : "+higherScore);
		System.out.println();
		
		int floorScore = scores.floor(87);//87이하 가장 가까운 값 
		System.out.println("87이하 가장 가까운 값(87포함) : "+floorScore);
		
		int ceilingScore = scores.floor(87);//87이상 가장 가까운 값 
		System.out.println("87이상 가장 가까운 값(87포함) : "+ceilingScore);
		System.out.println();
		
		//정렬
		NavigableSet<Integer> desendingSet = scores.descendingSet();
		System.out.print("내림차순 : ");
		for (Integer score : desendingSet) {
			System.out.print(score+"->");
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = desendingSet.descendingSet();
		System.out.print("오름차순 : ");
		for (Integer score : ascendingSet) {
			System.out.print(score+"->");
		}
		System.out.println();
		System.out.println();
		
		//범위 검색
		TreeSet<String> words = new TreeSet<>();
		words.add("apple");	//글자는 유니코드로 비교 숫자를 문자열로 만들었을시 문자열로 비교한다 ex) "20" , "100" 1이 더 낮으므로 100이 더 낮다.
		words.add("forever");
		words.add("description");
		words.add("ever");
		words.add("zoo");
		words.add("base");
		words.add("bike");
		words.add("soccer");
		words.add("red");
		words.add("blue");
		words.add("green");
		words.add("f");
		words.add("20");
		words.add("100");
		NavigableSet<String> ns = words.descendingSet().descendingSet();
		System.out.print("문자열 오름차순 : ");
		for (String word : ns) {
			System.out.print(word+"->");
		}
		System.out.println();
		System.out.println();
		
		
		NavigableSet<String> ns2 = words.subSet("c", true, "f", true);//첫 글자가 C이상 F이하 글자 찾기 F뒤에 글씨가 오면 F를 넘어가므로 안된다.
		System.out.print("문자열 부분 검색 : ");
		for (String word : ns2) {
			System.out.print(word+"->");
		}
		System.out.println();
		System.out.println();
		
		

	}

}
