package ch11.exam10;

import java.util.Arrays;

public class ArrayCopyExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr1 = {'J','A','V','A'};
		
		//배열복사
		char[] arr2 = new char[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];	//값만 복사 얕은 복사
		}
		
		System.out.println(Arrays.toString(arr2));//배열 안의 항목을 하나씩 출력
		
		//배열복사방법2
		char[]arr3 = new char[arr1.length];
		//System.arraycopy(복사할 배열, 복사할위치(index), 복사할 곳, 복사된 곳의 위치(index), 복사할 배열);
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);	//얕은 복사 1차원 항목 복사
		
		System.out.println(Arrays.toString(arr3));//배열 안의 항목을 하나씩 출력(확인)

		//배열복사방법3
		//Arrays.copyOf(복사할 배열, 복사할 길이);
		char[] arr4 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr4));	//얕은 복사
	}

}
