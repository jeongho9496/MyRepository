package ch15.exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;


public class HashMapExample {
	//0919
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map 계열 컬렉션 생성
		Map<String, Integer> map = new HashMap<>();
//		Map<String, Integer> map2 = new Hashtable<>();
		
		//엔트리 추가
		map.put("이명진", 00);
		map.put("홍길동", 85);//int형 Integer형으로 자동 박싱
		map.put("추가을", 90);
		map.put("홍길동", 95);
		map.put("감자바", 81);
		System.out.println(map.size());
		
		//객체(값)얻기
		int score = map.get("홍길동");
		System.out.println(score);
		
		//모든 엔트리 일괄처리
		//방법 1
		Set<Entry<String, Integer>> set = map.entrySet();
		//Map.Entry -> Map import 하지 않으면 사용
		
		for (Entry<String, Integer> entry : set) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key+" : "+value);
			
		}
		System.out.println();
		
		//방법2
		Set<String> set2 = map.keySet();
		for (String key : set2) {
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		//객체 삭제
		map.remove("홍길동");
		System.out.println(map.size());
		
		set2 = map.keySet();
		for (String key : set2) {
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("\uB300\uD55C\uBBFC\uAD6D");

	}

}
