package ch11.exam06;

public class SystemTimeExample {
	public static void main(String[] args) {
		long start = System.nanoTime();
//		long start = System.currentTimeMillis();
		
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		long end = System.nanoTime();
//		long end = System.currentTimeMillis();
		
		System.out.println("걸린 시간 : " + (end - start));
	}
}
