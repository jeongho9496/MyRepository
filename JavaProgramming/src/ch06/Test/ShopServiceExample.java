package ch06.Test;

public class ShopServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopService18 obj1 = ShopService18.getInstance();
		ShopService18 obj2 = ShopService18.getInstance();
		
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체 이다.");
		} else {
			System.out.println("다른 객체 이다.");
		}

	}

}
