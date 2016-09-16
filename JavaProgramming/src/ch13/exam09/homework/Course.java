package ch13.exam09.homework;

public class Course<T> {
	//0908
	private String name;	//과정명
	private T[] students;	//수강생 배열타입 선언
	
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (T[])new Object[capacity];//타입이 설정안된 것은 Object로 만든다음에 형변환
	}
	
	public String getName(){ return name; }
	public T[] getStudent(){ return students; }
	
	public void add(T t){	//수강취소시 빈배열에 추가
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
