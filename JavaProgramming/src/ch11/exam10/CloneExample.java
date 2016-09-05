package ch11.exam10;

import java.util.Arrays;

public class CloneExample {
		//0905
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3};
		
		int[] arr2 = arr1.clone();
		System.out.println(arr1 == arr2);
		System.out.println(Arrays.equals(arr1, arr2));

		Member m1 = new Member("hong", "길동");
		System.out.println(m1.toString());
		
		Member m2 = (Member) m1.clone();//Objcet 타입인 clone를 Member로 강제 형변환
		System.out.println(m1 == m2);
		System.out.println(m2);
	}

}

class Member implements Cloneable{
	String mid;
	String mname;
	int age;
	String[] hobbys;
	
	Member(String mid, String mname){
		this.mid = mid;
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		return mid + " : " + mname;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();	//외부에서 clone를 사용할수 있도록 접근제한자를 public로 바꾼다(오버라이드) 얕은 복사
	}
}
