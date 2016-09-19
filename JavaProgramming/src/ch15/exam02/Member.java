package ch15.exam02;

public class Member {
	// 0919
	private String name;
	private int age;

	public Member(String name, int age)/* 생성자 주입 */ {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {	//hashCode 같게 하기

		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Member) { // 객체 비교
			Member target = (Member) obj;
			if (name.equals(target.name) && age == target.age) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
