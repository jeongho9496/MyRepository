package ch18.exam18.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


public class ClientExample {

	public static void main(String[] args) {
		//소켓 생성
		Socket socket = new Socket();
		
		try {
			//서버에 연결 요청하기
			SocketAddress sa = new InetSocketAddress("192.168.0.2", 5001);
			socket.connect(sa);	//서버와 연결
			System.out.println("[서버와 연결됨]");
			
			//보낼 데이터를 키보드로부터 읽기
			Scanner scanner = new Scanner(System.in);
			System.out.print("보낼 데이터 -> ");
			String data = scanner.nextLine();
			
			//서버에 데이터 전송(보내기)
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println(data);//data 다음에 \n\r 이 붙는다.
			ps.flush();
			
			//서버에서 보낸 데이터를 읽기
			InputStream is = socket.getInputStream();
			Reader reader = new InputStreamReader(is); // reader로 변환
			BufferedReader br = new BufferedReader(reader);
			data = br.readLine(); // readLine() -> 행단위로 읽음
			System.out.println(data);
			
			
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
