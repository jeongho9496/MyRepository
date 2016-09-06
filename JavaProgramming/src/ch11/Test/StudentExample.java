package ch11.Test;

import java.util.HashMap;

public class StudentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Student, String> hashMap = new HashMap<Student, String>();
		
		//키 값으로 점수 저장
		hashMap.put(new Student("1"), "95");
		hashMap.put(new Student("2"), "34");
		hashMap.put(new Student("3"), "88");
		
		//키값으로 점수 가져오기
		String score = hashMap.get(new Student("2"));
		System.out.println("1번 학생의 총점 : "+ score);

	}

}
