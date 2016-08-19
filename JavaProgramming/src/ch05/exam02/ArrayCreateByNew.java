package ch05.exam02;

public class ArrayCreateByNew {

	public static void main(String[] args) {
		int[] arr1 = new int[5]; // int타입 길이 5짜리 배열 생성
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+i+"] => "+arr1[i]);
		}
		
		System.out.println("-------------------------------");
		double[] arr2 = new double[5]; // double타입 길이 5짜리 배열 생성
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2["+i+"] => "+arr2[i]);
		}
		
		System.out.println("-------------------------------");
		boolean[] arr3 = new boolean[5]; // boolean타입 길이 5짜리 배열 생성
		
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3["+i+"] => "+arr3[i]);
		}
		
		System.out.println("-------------------------------");
		String[] arr4 = new String[5]; // String타입 길이 5짜리 배열 생성
		
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4["+i+"] => "+arr4[i]);	//null 출력 null -> 아직 객체를 참조하고 있지 않다.
		}
		
	}

}
