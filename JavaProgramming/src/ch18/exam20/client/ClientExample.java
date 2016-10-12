package ch18.exam20.client;

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
	//0923
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
			
			try {
				//서버에 데이터 전송(보내기)
				OutputStream os = socket.getOutputStream();
				byte[] sendValues = data.getBytes("UTF-8");//UTF-8로 인코딩 -> 한글이 깨지지 않는다.
				os.write(sendValues);//서버에서 종료시 에러남
				os.flush();
				
				//서버에서 보낸 데이터를 읽기
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024]; //데이터 받을 배열 정의
				int byteNum = is.read(receiveValues); //서버 에서 받은 바이트
				data = new String(receiveValues, 0 , byteNum, "UTF-8");//UTF-8을 명시하여 데이터 손실을 없앤다.
				System.out.println(data);
			} catch(Exception e) {		//서버가 연결후 끈켰을때
				System.out.println("[서버와 연결이 끊어졌음]");
			}
			
		} catch (IOException e) {//서버와 연결 자체가 안됬을 경우
			// TODO Auto-generated catch block
			System.out.println("[서버와 연결이 안되었습니다]");
		}
		
		//서버 연결을 끊음
		try {
			socket.close();
			System.out.println("클라이언트를 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
