package ch18.exam23.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	// 0923
	ExecutorService executorService; // 스레드 풀 선언
	ServerSocket serverSocket; // 서버 소켓 선언
	List<Client> connections = new Vector<>();// client객체 저장하는 list 생성 -> 멀티스레드 환경에서 사용하기 위해 vector로 생성

	void startServer() {
		// 스레드 풀 생성
		executorService = Executors.newFixedThreadPool(50);// 스레드 풀에서 받을 스레드 갯수 작성

		// ServerSocket 생성(5001번 포트를 사용)
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.8", 5001));
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}

		// 클라이언트 연결 수락 작업 생성과 작업큐에 넣
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						displayText("[서버 시작]");
						btnStartStop.setText("stop");
					}
				});
				
				while (true) {//무한루프
					try {
						//클라이언트의 연결을 기다리고 수락하기
						Socket socket = serverSocket.accept();
						String message = "[연결 수락 : " + socket.getInetAddress().getHostAddress()/*현재 들어온 클라이언트 주소*/ +
								" : "+ Thread.currentThread().getName()/*현재 스레드의 이름*/+"]";
						
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								displayText(message);
							}
						});
						
						//통신 객체 Client 생성
						Client client = new Client(socket);
						
						//Client 관리
						connections.add(client);
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								displayText("[연결 개수 : " + connections.size() + "]");
							}
						});
						
					} catch (Exception e) {
						if (!serverSocket.isClosed()) {stopServer();}
						break;
					}					
				}
			}
		};
		executorService.submit(runnable);// 스레드풀에 작업 추가
	}

	void stopServer() {
		try {		
			
			Iterator<Client> iterator = connections.iterator();//리스트(connections)에있는 클라이언트 지우기
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();			
			}
			
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();//bind를 중지 시켜야 한다.
			}
			if (executorService != null && !executorService.isShutdown()) {
				executorService.shutdownNow();//모든 스레드가 멈춰야만 프로세스가 종료될 수 있다.
			}
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					displayText("[서버 멈춤]");
					btnStartStop.setText("start");
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	class Client {
		
		Socket socket;
		
		public Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		void receive(){
			//클라이언트의 데이터를 받는 작업 생성 및 작업큐에 넣기
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						while (true) {	//클라이언트가 종료하지 않으면 계속 데이터를 받아야 하기 때문에 무한루프 생성
							InputStream is = socket.getInputStream();
							byte[] values = new byte[1024];
							int byteNum = is.read(values);
							if(byteNum == -1){throw new IOException();}//예외가 발생되어 catch로 넘어간다.
							String data = new String(values, 0, byteNum, "UTF-8");
							for (Client client : connections) {	//모든 클라이언트에게 보냄
								client.send(data);	//모든 클라이언트에게 보냄
							}
							
						}
					} catch (Exception e) {
						try {
							connections.remove(Client.this);//현재 클라이언트객체 제거
							String message = "[클라이언트 통신 안됨 : " + socket.getInetAddress().getHostAddress()/*현재 있는 클라이언트 주소*/ +
								" : "+ Thread.currentThread().getName()/*현재 처리 담당한 스레드의 이름*/+"]";
						
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									displayText(message);
								}
						});
							socket.close();//현재 클라이언트 소켓 닫음
						} catch (IOException e1) {}
					}
				}
			};
			executorService.submit(runnable);
		}
		
		void send(String data){
			//클라이언트로 데이터를 보내는 작업 생성
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						
						OutputStream os = socket.getOutputStream();
						byte[] values = data.getBytes("UTF-8");
						os.write(values);
						os.flush();
						
					} catch (Exception e) {
						try {
							connections.remove(Client.this);//현재 클라이언트객체 제거
							String message = "[클라이언트 통신 안됨 : " + socket.getInetAddress().getHostAddress()/*현재 있는 클라이언트 주소*/ +
								" : "+ Thread.currentThread().getName()/*현재 처리 담당한 스레드의 이름*/+"]";
						
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									displayText(message);
								}
						});
							socket.close();//현재 클라이언트 소켓 닫음
						} catch (IOException e1) {}
					}
					
				}
			};
			executorService.submit(runnable);
		}
	}

	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e -> {
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
