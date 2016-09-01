package ch10.exam01;

public class Example4 {
	public static void main(String[] args) {

		try {
			String data1 = args[0];
			String data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e1) {
			System.out.println("입력된 수가 틀립니다." + e1.toString());

		} catch (Exception e) {

		}

	}
}
