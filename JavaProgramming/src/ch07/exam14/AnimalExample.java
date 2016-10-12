package ch07.exam14;

public class AnimalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog("포유류");
		Cat cat = new Cat("포유류");
		dog.sound();
		cat.sound();
		System.out.println("--------------------------------");
		
		//변수의 자동 타입 변환
		Animal animal = null;
		animal = new Dog("포유류");
		animal.sound();
		
		animal = new Cat("포유류");
		animal.sound();
		System.out.println("--------------------------------");
		
		animalSound(new Dog("포유류"));
		animalSound(new Cat("포유류"));

	}

	private static void animalSound(Animal animal) {
		// TODO Auto-generated method stub
		animal.sound();
	}

}
