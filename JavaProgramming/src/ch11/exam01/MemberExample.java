package ch11.exam01;

public class MemberExample {
	//0902
	public static void main(String[] args) {
		
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if (obj1.equals(obj2)) {
			System.out.println("동등 하다.");
		} else {
			System.out.println("동등 하지 않다.");
		}
		
		if (obj1.equals(obj3)) {
			System.out.println("동등 하다.");
		} else {
			System.out.println("동등 하지 않다.");
		}
	}
	
	
}
