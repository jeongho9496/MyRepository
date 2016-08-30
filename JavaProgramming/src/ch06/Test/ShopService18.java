package ch06.Test;

public class ShopService18 {
	private static ShopService18 shopService = new ShopService18();
	
	private ShopService18(){}
	
	static ShopService18 getInstance(){
		return shopService;
	}
}
