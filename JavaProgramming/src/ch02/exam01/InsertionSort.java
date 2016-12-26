package ch02.exam01;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 2, 3 };

		InsertionSort sort = new InsertionSort();
		sort.solution(arr);

	}
	

	public int solution(int[] arr) {
		int count =0;
		for (int i = 1; i < arr.length; i++) {
			int standard = arr[i]; // 기준
			int aux = i - 1; // 비교할 대상

			while (aux >= 0 && standard < arr[aux]) {
				arr[aux + 1] = arr[aux]; // 비교대상이 큰 경우 오른쪽으로 밀어냄
				aux--;
			}
			arr[aux + 1] = standard; // 기준값 저장
		}
		printArr(arr);
		return 0;
	}
	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
