package ch15.exam07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	// 0920
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Message> queue = new LinkedList<>();//먼저 들어온 객체 부터 처리

		queue.offer(new Message("sendMail", "홍길동"));
		queue.offer(new Message("sendSMS", "감자바"));
		queue.offer(new Message("sendKakaotalk", "홍두께"));

		while (!queue.isEmpty()) {
			Message message = queue.poll();

			switch (message.command) {
			case "sendMail":
				System.out.println(message.to+"님에게 메일 전송");
				break;
			case "sendSMS":
				System.out.println(message.to+"님에게 문자 전송");
				break;
			case "sendKakaotalk":
				System.out.println(message.to+"님에게 카카오 전송");
				break;

			}

		}
	}

}
