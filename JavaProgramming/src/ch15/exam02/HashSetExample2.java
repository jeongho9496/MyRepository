package ch15.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	//0919
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("홍길동", 25);
		
		System.out.println(m1 == m2);		//번지 비교. 번지가 다르므로 false
		System.out.println(m1.equals(m2));	//object의 equals는 == 와 같다. equals 재정의 하면 true
		System.out.println(m1.hashCode() == m2.hashCode());	//객체가 다르므로 false hashcode 재정의 하면 true
		System.out.println();
		
		String s1 = new String("JDBC");
		String s2 = new String("JDBC");
		System.out.println(s1 == s2);		//번지 비교. 번지가 다르므로 false
		System.out.println(s1.equals(s2));	//object의 equals는 == 와 같다. equals 재정의 하면 true
		System.out.println(s1.hashCode() == s2.hashCode());	//객체가 다르므로 false hashcode 재정의 하면 true
		System.out.println();
		
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
		
		

	}

}
