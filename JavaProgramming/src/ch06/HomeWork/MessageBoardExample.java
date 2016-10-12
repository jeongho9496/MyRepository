package ch06.HomeWork;

import java.util.Scanner;

public class MessageBoardExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		MessageBoard[] messageBoards = null;
		while (true) {
			System.out.println("-------------------------------------------------------------------------");
			if (messageBoards == null) {

				System.out.println("2. 글쓰기 | 6. 종료 ");
				messageBoards = new MessageBoard[100];

			} else {

				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6. 종료 ");

			}

			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) { // 목록보기

				System.out.println("******************************************************");
				System.out.println("번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("******************************************************");

				for (MessageBoard messageBoard : messageBoards) {

					if (messageBoard != null) {

						System.out.println(messageBoard.no + "\t\t" + messageBoard.title + "\t\t" + messageBoard.name
								+ "\t\t" + messageBoard.count);

					}
				}

			} else if (choice.equals("2")) { // 게시물 작성

				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String text = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String name = scanner.nextLine();

				for (int i = 0; i < messageBoards.length; i++) {

					if (messageBoards[i] == null) {

						MessageBoard messageBoard = new MessageBoard(i, title, text, name, 0);
						messageBoards[i] = messageBoard;
						break;

					}
				}

			} else if (choice.equals("3")) { // 게시물 상세보기

				System.out.println("상세보기할 게시물 번호를 선택하세요");
				int detailNum = Integer.parseInt(scanner.nextLine());

				if (messageBoards != null) {
					
					for (MessageBoard messageBoard : messageBoards) {
						if (messageBoard != null) {							
							if (detailNum == messageBoard.no) {
								
								messageBoard.count ++ ;
								
								System.out.println("***************************************************");
								System.out.println("번호\t\t제목\t\t내용\t\t글쓴이\t\t조회수");
								System.out.println("***************************************************");
								System.out.println(messageBoard.no + "\t\t" + messageBoard.title + "\t\t"
										+ messageBoard.text + "\t\t" + messageBoard.name + "\t\t" + messageBoard.count);
							}
						}
					}
				}

			} else if (choice.equals("4")) { // 게시물 수정
				System.out.println("변경할 게시물 번호를 선택하세요");
				int modifyNum = Integer.parseInt(scanner.nextLine());
				if (messageBoards != null) {
					
					for (MessageBoard messageBoard : messageBoards) {
						if (messageBoards[modifyNum] != null) {
							System.out.print("제목 : ");
							String title = scanner.nextLine();
							System.out.print("내용 : ");
							String text = scanner.nextLine();
							messageBoard.title = title;
							// notices[modifyNum][1] = title;
							messageBoard.text = text;
						}
					}
				}
			} else if (choice.equals("5")) { // 게시물 삭제
				System.out.println("삭제할 게시물 번호를 선택하세요");
				int bno = Integer.parseInt(scanner.nextLine());
				messageBoards[bno] = null;

			} else if (choice.equals("6")) { // 종료
				break;
			}
		}
	}

}