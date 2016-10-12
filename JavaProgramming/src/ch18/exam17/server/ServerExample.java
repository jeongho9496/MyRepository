package ch18.exam17.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	//0922
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//서버의 어떤 IP라도 접근 할수 있도록 한것 -> 클라이언트 연결 수락
			serverSocket = new ServerSocket(5001);
			
			
			//서버의 특정 IP로 접근할 수 있도록 한 것
			/*serverSocket = new ServerSocket();
			SocketAddress sa = new InetSocketAddress("192.168.0.2", 5001);
			serverSocket.bind(sa);*/
			
			for (int i=0; i<10; i++) {				
				//클라이언트의 연결을 수락하고 통신용 Socket을 생성
				System.out.println("[클라이언트의 연결을 기다림]");
				
				//클라이언트의 연결을 기다리다 클라이언트가 연결을 요청하면 연결을 수락하고 서버에 Socket(통신용 객체)을 생성한다. -> 클라이언트와 통신 담당
				Socket socket = serverSocket.accept();	
				 
				//클라이언트의 IP정보 얻기
				String clientIP =  socket.getInetAddress().getHostAddress();
				System.out.println("[클라이언트의 [" + clientIP +"] 연결을 수락함]");
				
				//클라이언트의 연결을 끊음
				socket.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			serverSocket.close();
		} catch (IOException e) {}
	}

}
