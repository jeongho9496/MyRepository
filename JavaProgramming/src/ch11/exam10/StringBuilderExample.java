package ch11.exam10;

public class StringBuilderExample {
	//0905
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "a";
		data += "b";
		data += "c";
		System.out.println(data);
		
		//StringBuilder() : 문자열 변경이 많을 경우 사용
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		sb.append("d");
		System.out.println(sb);
		
		String data2 = "abc";
		StringBuilder sb2 = new StringBuilder(data2);
		sb2.insert(1, "0");	//.insert(삽입할 문자열, 넣을 문자);
		data2 = sb2.toString();
		System.out.println(data2);
		

	}

}
