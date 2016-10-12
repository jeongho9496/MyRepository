package ch15.exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {
	//0919
	public static void main(String[] args) {
		//List계열의 컬렉션 생성
		List<String> list = new ArrayList<>();
//		List<String> list = new Vector<>();
//		List<String> list = new LinkedList<>();
		
		//객체 저장(추가)
		list.add("Java");		//index 0 번에 저장
		list.add("JDBC");		//index 1 번에 저장
		list.add("Servlet/JSP");//index 2 번에 저장 =>list.add(2,"DataBase");에 의해 3번으로 밀림
		list.add(2,"DataBase");	//index 2 번에 저장
		list.add("iBatis");		//index 4 번에 저장
		
		//저장된 객체수 얻기
		int size = list.size();
		System.out.println("총객체수 : " + size);
		System.out.println();
		
		//겍체 찾기
		String skill = list.get(2);
		System.out.println("2번째 : " + skill);
		System.out.println(list.get(3));
		System.out.println();
		
		//전체 객체를 일괄 처리
		//방법1
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+"번째 : "+str);
		}
		System.out.println();
		//방법2 향상된 for문
		System.out.println("향상된 for문 처리");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println();
		
		//객체 삭제
		list.remove(2);//DataBase 삭제
		list.remove(2);//Servlet/JSP 삭제
		list.remove(new String("iBatis"));//iBatis 삭제
		list.remove("iBatis");//iBatis 삭제
		//remove는 Equals로 비교하기 때문에 new를 사용해도 지워진다.
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+"번째 : "+str);
		}
	}
}
