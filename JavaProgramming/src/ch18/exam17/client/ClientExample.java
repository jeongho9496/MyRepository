package ch18.exam17.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


public class ClientExample {

	public static void main(String[] args) {
		//소켓 생성
		Socket socket = new Socket();
		
		//서버에 연결 요청하기
		try {
			SocketAddress sa = new InetSocketAddress("192.168.0.29", 5001);
			socket.connect(sa);//서버에 연결 요청
			System.out.println("[서버와 연결됨]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//서버 연결을 끊음
		try {
			socket.close();
		} catch (IOException e) {}
	}

}
