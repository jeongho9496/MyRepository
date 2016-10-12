package ch07.exam14;

public class Dog extends Animal {
	public Dog(String kind){
		super(kind);
	}
	
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
}
