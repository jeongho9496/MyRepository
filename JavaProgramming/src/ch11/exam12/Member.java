package ch11.exam12;

public class Member implements Comparable{
	private String name;
	
	public Member(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Member target = (Member)o;
		return name.compareTo(target.name);
	}
}
