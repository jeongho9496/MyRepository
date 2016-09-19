package ch15.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {
	//0919
	public static void main(String[] args) {
		//Set 계열 컬렉션 생성
		Set<String> set = new HashSet<>();
//		Set<String> set = new TreeSet<>();
//		Set<String> set = new LinkedHashSet<>();
		
		//객체 저장
		String s1 = new String("JDBC");
		String s2 = new String("JDBC");
		
		set.add("Java");
		set.add(s1);
		set.add(s2);
		set.add("Servlet/JSP");
		set.add("MYSQL");
		System.out.println(set.size());
		
		System.out.println();
		
		//객체를 일괄 처리하기
		//방법1
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if (str.equals("Java")) {
				iterator.remove();
			}
			System.out.println(str+"\t");
		}
		
		System.out.println();
		//방법2 향상된 for문
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println();

	}

}
