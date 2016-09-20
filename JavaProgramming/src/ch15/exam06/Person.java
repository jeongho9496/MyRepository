package ch15.exam06;

public class Person implements Comparable<Person> {
	//0920
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Person target) {
		/*if (age < target.age) return -1;
		else if (age == target.age) return 0;
		else return 1;*/
		
		return (age - target.age);
		
	}
	
	
}
