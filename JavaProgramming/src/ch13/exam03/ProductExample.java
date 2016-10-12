package ch13.exam03;

public class ProductExample {
	//0908
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product<String, String> p1 = new Product<>();
		
		p1.setKind("TV");
		p1.setModel("스마트");
		
		String kind = p1.getKind();
		String model = p1.getModel();
		
		System.out.println(kind+","+model);
		
		Product<TV, String> p2 = new Product<>();
		
		p2.setKind(new TV());
		p2.setModel("대화면");
		TV kind2 = p2.getKind();
		String model2 = p2.getModel();
		System.out.println(kind2+","+model2);
	}

}
