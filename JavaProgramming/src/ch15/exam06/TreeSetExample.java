package ch15.exam06;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	//0920
	public static void main(String[] args) {
		TreeSet<Person> treeSet1 = new TreeSet<>();
		treeSet1.add(new Person("김정호", 28));
		treeSet1.add(new Person("윤지수", 27));
		treeSet1.add(new Person("이명진", 26));
		
		NavigableSet<Person> ns1 = treeSet1.descendingSet();
		System.out.print("나이 내림 차순 정렬 : ");
		for (Person person : ns1) {
			System.out.print(person+"->");
		}
		System.out.println();
		System.out.println();
		
//		TreeSet<Fruit> treeSet2 = new TreeSet<>();//비교기능이 없으면 TreeSet에 저장이 안됨.
		TreeSet<Fruit> treeSet2 = new TreeSet<>(new FruitComparator());
		treeSet2.add(new Fruit("사과", 5000));
		treeSet2.add(new Fruit("딸기", 9000));
		treeSet2.add(new Fruit("포도", 8000));
		
		NavigableSet<Fruit> ns2 = treeSet2.descendingSet().descendingSet();
		System.out.print("과일 가격 오름 차순 정렬 : ");
		for (Fruit fruit : ns2) {
			System.out.print(fruit+"->");
		}
		System.out.println();
		
		System.out.print("과일 가격 오름 차순 정렬 : ");
		for (Fruit fruit : treeSet2) {
			System.out.print(fruit+"->");
		}
		System.out.println();
		
	}

}
