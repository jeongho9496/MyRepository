package ch06.exam12;

public class Television {
	//0829
	static String company = "Samsung";
	static String model = "LCD";
	static String info;
	
	static {
		info = company+"-"+model;
	}
	
	public static void main(String[] args) {
		System.out.println(Television.info);
	}
}
