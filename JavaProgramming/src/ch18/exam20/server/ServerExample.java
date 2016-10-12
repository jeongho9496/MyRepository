package ch18.exam20.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	//0923
	private static ServerSocket serverSocket;//클래스 전체에 사용할 수 있는 필드가 됨
	private static boolean stop;	//flag로 사용할 필드 생성
	public static void main(String[] args) {
		System.out.println("서버 시작");
		
		try {
			//서버의 어떤 IP라도 접근 할수 있도록 한것
			serverSocket = new ServerSocket(5001);//서버에 클라이언트가 연결될수 있는 Port생성
			
			//Thread 생성
			Thread thread = new Thread(){
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			thread.start();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = scanner.nextLine();
			if (command.equals("stop")) {
				stop = true;	//작업스레드(클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close();
				} catch (IOException e) {}
				System.out.println("서버 종료");
				System.exit(0);	//서버 Process를 종료
			}		
		}
	}

	private static void waitAndAccept() {//메인 메소드가 static이므로 해당 메소드도 static로 해줘야 한다.
		try {
			
			while (!stop) {				
				//클라이언트의 연결을 수락하고 통신용 Socket을 생성
				//클라이언트의 연결을 기다리다 클라이언트가 연결을 요청하면 연결을 수락하고 서버에 Socket(통신용 객체)을 생성한다.
				Socket socket = serverSocket.accept();//블록킹 될수 있음(MainThread 말고 다른 Thread에서 작동해야함.)
				
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
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
