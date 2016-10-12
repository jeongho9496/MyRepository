package ch13.exam09.homework;

import java.util.Arrays;

public class WildCardExample {
	//registerCourse -> 과정을 등록하다.
	public static void registerCourse1(Course<?> course){
		System.out.println(course.getName() + "수강생 : "+ Arrays.toString(course.getStudent()));
	}
	//->객체 생성시 어떠한 타입이 와도 상관 없다.(제한을 두지 않는다.)
	
	public static void registerCourse2(Course<? extends Student> course){		
		System.out.println(course.getName() + "수강생 : "+ Arrays.toString(course.getStudent()));
	}
	//->객체 생성시 Student로 상속되는 하위클래스나 자기 자신만 올수 있다.(상위클래스 제한)
	
	public static void registerCourse3(Course<? super Worker> course){
		System.out.println(course.getName() + "수강생 : "+ Arrays.toString(course.getStudent()));		
	}
	//->객체생성시 Worker자기 자신과 자신의 상위 클래스만 올수 있다.
	
	public static void main(String[] args) {
		
		Course<Person> c1 = new Course<Person>("일반인 과정",5);
//		registerCourse1(c1);
//		registerCourse2(c1);//student를 상속받고 있는 클래스들의 타입만 올수있다.
//		registerCourse3(c1);
		
		Course<Worker> c2 = new Course<Worker>("직장인 과정",5);
//		registerCourse1(c2);
//		registerCourse2(c2);//student를 상속받고 있는 클래스들의 타입만 올수있다.
//		registerCourse3(c2);
		
		Course<Student> c3 = new Course<Student>("학생 과정",5);
//		registerCourse1(c3);
//		registerCourse2(c3);
//		registerCourse3(c3);//Worker의 부모에 student가 없으므로 실행이 안된다.

		Course<HighStudent> c4 = new Course<HighStudent>("고등 학생 과정",5);
//		registerCourse1(c4);
//		registerCourse2(c4);
//		registerCourse3(c4);//Worker의 부모에 student가 없으므로 실행이 안된다.
		
		c1.add(new Person("일반인"));
		c1.add(new Person("직장인"));
		c1.add(new Person("학생"));
		c1.add(new Person("고등학생"));
		
		c2.add(new Worker("직장인"));
		
		c3.add(new Student("학생"));
		c3.add(new HighStudent("고등학생"));
		
		c4.add(new HighStudent("고등 학생"));
		
		registerCourse1(c1);
		registerCourse1(c2);
		registerCourse1(c3);
		registerCourse1(c4);
		
//		registerCourse2(c1);
//		registerCourse2(c2);
		//자기 자신과 자기 자신을 상속한 하위 클래스만 올수 있음
		registerCourse2(c3);
		registerCourse2(c4);
		
		//자기 자신과 자기가 상속받은 상위 클래스만 올수 있다.
		registerCourse3(c1);
		registerCourse3(c2);
//		registerCourse3(c3);
//		registerCourse3(c4);
	}

}
