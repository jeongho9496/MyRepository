package ch10.exam01;

public class Example2 {
	// 0901
	public static void main(String[] args) {

		try {
			String data1 = args[0];
			String data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("입력된 수가 틀립니다." + e.toString());

		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력하지 않았습니다." + e.toString());
		}

	}
}
