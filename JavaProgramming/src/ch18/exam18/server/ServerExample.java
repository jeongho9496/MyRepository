package ch18.exam18.server;

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
	//0922
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
				Reader reader = new InputStreamReader(is); // reader로 변환
				BufferedReader br = new BufferedReader(reader);//보조 스트림
				String data = br.readLine(); // readLine() -> 행단위로 읽음
				
				//클라이언트로 에코 보내기
				OutputStream os = socket.getOutputStream();
				PrintStream ps = new PrintStream(os);
				ps.println("[서버] -> "+data);//data 다음에 \n\r 이 붙는다.
				ps.flush();
				
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
