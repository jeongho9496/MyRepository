package ch18.exam19.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	//0923
	public static void main(String[] args) {
		System.out.println("서버 시작");
		ServerSocket serverSocket = null;
		
		try {
			//서버의 어떤 IP라도 접근 할수 있도록 한것
			serverSocket = new ServerSocket(5001);//서버에 클라이언트가 연결될수 있는 Port생성
			
			for (int i=0; i<10; i++) {				
				//클라이언트의 연결을 수락하고 통신용 Socket을 생성
				//클라이언트의 연결을 기다리다 클라이언트가 연결을 요청하면 연결을 수락하고 서버에 Socket(통신용 객체)을 생성한다.
				Socket socket = serverSocket.accept();
				
				//클라이언트에서 보낸 데이터를 받기
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024]; //데이터 받을 배열 정의
				int byteNum = is.read(receiveValues); //클라이언트에서 받은 바이트
				String data = new String(receiveValues, 0 , byteNum, "UTF-8");
				
				//클라이언트로 에코 보내기
				OutputStream os = socket.getOutputStream();
				byte[] sendValues = data.getBytes("UTF-8");//UTF-8로 인코딩
				os.write(sendValues);
				os.flush();
				
				//클라이언트의 연결을 끊음
				socket.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			serverSocket.close();
		} catch (IOException e) {}
		System.out.println("서버 종료");
	}

}
