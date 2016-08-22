package ch05.exam03;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		// 0822
		Scanner scanner = new Scanner(System.in);//키보드 입력값 받는 메소드 호출
		String[][] boards = new String[100][];	//배열 객체 정의
									

		while (true) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("| 1.목록 | 2.글쓰기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6.종료 |");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine(); // 키보드로 선택한 숫자를 읽어온다.

			if (choice.equals("1")) {
				System.out.println("************************************************************************");
				System.out.println("게시물 번호\t\t글쓴이\t\t제목\t\t조회수");
				System.out.println("************************************************************************");

				for (String[] board : boards) {
					if (board != null) {
						System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2] + "\t\t" + board[4]);
					}
				}
			} else if (choice.equals("2")) {

				System.out.print("글쓴이 : ");
				String writer = scanner.nextLine();
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String content = scanner.nextLine();

				for (int i = 0; i < boards.length; i++) {

					if (boards[i] == null) {
						String[] board = { String.valueOf(i), writer, title, content, "0" };
						boards[i] = board;
						break;
					}
				}

			} else if (choice.equals("3")) {

				System.out.print("상세 보기할 번호 : ");
				String detailNum = scanner.nextLine();
				System.out.println("************************************************************************");
				System.out.println("게시물 번호\t\t글쓴이\t\t제목\t\t내용\t\t조회수");
				System.out.println("************************************************************************");
				for (String[] board : boards) {
					if (board != null) {
						int views = Integer.parseInt(board[4]); //조회수 카운트 변수
						if (detailNum.equals(board[0])) {
							views++;							//읽은 만큼 증가
							board[4] = String.valueOf(views);
							System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2] + "\t\t" +board[3]+"\t\t"+ board[4]);
							break;
						}

					}
				}

			} else if (choice.equals("4")) {
				// 수정하기
				System.out.print("수정할 게시글 번호 : ");
				String replaceNum = scanner.nextLine();
				System.out.print("수정 제목 : ");
				String replaceTitle = scanner.nextLine();
				for (String[] board : boards) {
					if (board != null) {
						if (replaceNum.equals(board[0])) {
							board[2] = replaceTitle;
							break;
						}
					}
				}

			} else if (choice.equals("5")) {
				// 삭제하기
				System.out.print("삭제할 번호 : ");
				int bno = Integer.parseInt(scanner.nextLine());
				boards[bno] = null;

			} else if (choice.equals("6")) {
				break;
			}

		}
	}

}
