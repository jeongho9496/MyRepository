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
				//목록보기
				System.out.println("************************************************************************");
				System.out.println("게시물 번호\t\t글쓴이\t\t제목\t\t조회수");
				System.out.println("************************************************************************");

				for (String[] board : boards) {//향상된 for문(for-each) 배열의 항목수만큼 실행부분을 반복
												//반복이 이루어질 때마다 배열의 항목을 순서대로 꺼내어 변수에 자동으로 대입
					if (board != null) {		//배열값이 null인 데이터에 값을 넣을수 없으므로 조건문 으로 처리
						System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2] + "\t\t" + board[4]);
					}
				}
			} else if (choice.equals("2")) {

				System.out.print("글쓴이 : ");
				String writer = scanner.nextLine();	//사용자가 키보드로 입력한 값을 읽음
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String content = scanner.nextLine();

				for (int i = 0; i < boards.length; i++) {

					if (boards[i] == null) {	//배열에 해당 값 생성
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
						if (detailNum.equals(board[0])) {		//선택한 게시물 번호와 board에 있는 인텍스를 문자열로 비교한다.
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
							board[2] = replaceTitle;	//기존에 있던 제목을 키보드로 입력한 제목으로 바꾼다.
							break;
						}
					}
				}

			} else if (choice.equals("5")) {
				// 삭제하기
				System.out.print("삭제할 번호 : ");
				int bno = Integer.parseInt(scanner.nextLine());
				boards[bno] = null;	//boards 배열의 값을 null로 초기화 한다.

			} else if (choice.equals("6")) {
				break;
			}

		}
	}

}
