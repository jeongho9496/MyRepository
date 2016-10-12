package ch15.exam01;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
	//0919
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java","Jdbc","Database");
		System.out.println(list.size());
		
		for (String string : list) {
			System.out.println(string);
		}
		
		//list.add("SQL");	ArrayAsList는 고정된 항목에만 사용되 add나 remove를 할 수 없다.
		//list.remove(1);

	}

}
