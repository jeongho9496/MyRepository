package ch18.exam16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	//0922
	public static void main(String[] args) throws UnknownHostException {
		InetAddress myIA = InetAddress.getLocalHost();//InetAddress 얻기
		String myIp = myIA.getHostAddress();	//내 컴퓨터 IP주소얻기
		
		System.out.println("MyIp : "+myIp);
		
		InetAddress[] naverIAs = InetAddress.getAllByName("www.naver.com");//해당 이름의 모든 IP 출력 -> DNS에서 찾음
		
		for (InetAddress ia : naverIAs) {
			System.out.println("네이버 서버 IP : " + ia.getHostAddress());
		}
	}
}
