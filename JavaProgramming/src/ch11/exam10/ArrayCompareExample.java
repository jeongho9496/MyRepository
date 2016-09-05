package ch11.exam10;

import java.util.Arrays;

public class ArrayCompareExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		System.out.println(arr1 == arr2);
		System.out.println(Arrays.equals(arr1, arr2));
		//Arrays.equals(arr1, arr2) 배열안에 항목이 같다면 true 출력. 
		
		int[][] arr3 = {{1,2},{3,4}};
		int[][] arr4 = {{1,2},{3,4}};
		System.out.println(arr3 == arr4);
		
		System.out.println(Arrays.equals(arr3, arr4));
		//배열 항목들이 참조를 하고 있다면 false가 리턴 된다.
		
		System.out.println(Arrays.deepEquals(arr3, arr4));	//deepEquals 2차항목 값 비고
	}

}
