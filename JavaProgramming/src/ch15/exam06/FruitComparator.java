package ch15.exam06;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit>{
	//0920
	@Override
	public int compare(Fruit f1, Fruit f2) {
		// TODO Auto-generated method stub
		
		return f1.getPrice()-f2.getPrice();//기본적으로 오름차순으로 정렬 된다. 큰수가 오른쪽으로 간다.
	}

}
