package ch11.exam12;

import java.util.Arrays;

public class ArraySerachExample {
	//0906	p526
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {99,97,98};
		Arrays.sort(scores);
		
		int index = Arrays.binarySearch(scores, 99);//Arrays.binarySearch 실행전 sort 필수!
		System.out.println("찾은 인덱스 : " + index);
		
		String[] names = {"홍길동","박동수","김민수"};
		Arrays.sort(names);	//문자열은 사전순으로
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스 : " + index);
		
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = {m1,m2,m3};
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스 : " + index);

	}

}
