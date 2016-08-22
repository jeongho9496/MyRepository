package ch05.exam03;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		// 0822
		Scanner scanner = new Scanner(System.in);
		String[][] boards = new String[100][];
		;
		while (true) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("| 1.목록 | 2.글쓰기 | 3.상세보기 | 4.수정하기 | 5.삭제하기 | 6.종료 |");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine(); // 키보드로 선택한 숫자를 읽어온다.
			if (choice.equals("1")) {
				System.out.println("************************************************************************");
				System.out.println("게시물 번호\t\t글쓴이\t\t제목\t\t내용\t\t조회수");
				System.out.println("************************************************************************");

				for (String[] board : boards) { // for-each문
					// for(int i = 0; students.length; i++){ for문 방식
					// String[] student = students[i];
					// }
					if (board != null) { // null도 비교 가능 -> student에 배열이 있어야 실행
											// 가능
						System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2]+ "\t\t" + board[3]+ "\t\t" + board[4]);
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
						// String.valueOf(i) => 매개변수 안에 있는 숫자를 문자열로 바꿔준다.
						// (<=> Integer.parseInt() => 매개변수 안에 있는 문자열이 숫자형식이면 숫자로
						// 바꾼다.)
						boards[i] = board;
						break;
					}
				}

			}

		}
	}

}
