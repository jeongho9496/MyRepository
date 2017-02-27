package ch18.exam23.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {
	//0923
	/*
	 * 자바 fx 찾기 : C:\Program Files\Java\jdk1.8.0_102\jre\lib\ext
	 * 에 jfxrt.jar를 AddExternalJars로 받고 order add export로 jar파일 최상위로 올리기
	 */
	Socket socket;
	
	void startClient() {
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("192.168.0.2", 5001));//연결시 bind가 아닌 connect 사용
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							displayText("[연결 완료 : " + socket.getRemoteSocketAddress() + "]");//소켓 주소 확인
							btnConn.setText("stop");
							btnSend.setDisable(false);//활성화
						}
					});
				} catch (Exception e) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							displayText("[서버 통신 안됨]");//소켓 주소 확인
							if (socket != null && !socket.isClosed()) {
								stopClient();
							}
						}
					});
					return;
				}
				
				receive();
			}
		};
		thread.start();
	}
	
	void stopClient() {
		if (socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				displayText("[연결 끊음]");//소켓 주소 확인
				btnConn.setText("start");
				btnSend.setDisable(true);//비활성화
			}
		});
	}	
	
	void receive() {
		while(true){
			try {
				InputStream is = socket.getInputStream();
				byte[] values = new byte[1024];
				int byteNum = is.read(values);
				if (byteNum == -1) {throw new IOException();}//정상 종료 Exception 발생 시키기
				String data = new String(values, 0, byteNum, "UTF-8");
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						String me = "나";
						String you = "상대방";
					
						displayText(data);//소켓 주소 확인
					}
				});
			} catch (Exception e) {//정상, 비정상 종류 모두 온다.
					Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						displayText("[서버 통신 안됨]");//소켓 주소 확인
					}
				});
					stopClient();
					break;
			}
		}
	}
	
	void send(String data) {
		Thread thread = new Thread(){//언제든지 사용해야 하기 때문에 스레드 따로 생성
			@Override
			public void run() {
				try {
					
					OutputStream os = socket.getOutputStream();
					byte[] values = data.getBytes("UTF-8");
					os.write(values);
					os.flush();
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							displayText("[보내기 완료]");//소켓 주소 확인
						}
					});
				} catch (Exception e) {
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							displayText("[서버 통신 안됨]");//소켓 주소 확인
						}
					});
					stopClient();//연결되지 않는 상태로 복원
				}
			}
			
		};thread.start();
	}
	
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
			txtInput = new TextField();
			txtInput.setPrefSize(60, 30);
			BorderPane.setMargin(txtInput, new Insets(0,1,1,1));
			
			btnConn = new Button("start");
			btnConn.setPrefSize(60, 30);
			btnConn.setOnAction(e->{
				if(btnConn.getText().equals("start")) {
					startClient();
				} else if(btnConn.getText().equals("stop")){
					stopClient();
				}
			});
			
			btnSend = new Button("send"); 
			btnSend.setPrefSize(60, 30);
			btnSend.setDisable(true);
			btnSend.setOnAction(e->send(txtInput.getText()));
			
			bottom.setCenter(txtInput);
			bottom.setLeft(btnConn);
			bottom.setRight(btnSend);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event->stopClient());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
