package ch06.exam11;

import java.util.Scanner; //import : Scanner 클래스가 있는 패키지 경로 설정 ctrl + shift + o -> 표준 api

public class ScoreManagement {

	public static void main(String[] args) throws Exception {
		// 0824
		Scanner scanner = new Scanner(System.in);
		Student[] students = null; // Student 타입 생성

		while (true) {

			System.out.println("-------------------------------------------------------------------------");
			if (students == null) {
				
				System.out.println("| 1.총학생수 | 7.종료 |");

			} else {
				
				System.out.println("| 1.총학생수 | 2.목록 | 3.입력 | 4.삭제 | 5.최고 점수 | 6.평균 | 7.종료 |");
			
			}
			
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();	//키보드로 선택한 숫자를 읽어온다.

			if (choice.equals("1")) {
				
				System.out.print("총학생수 : ");
				int totalNum = Integer.parseInt(scanner.nextLine()); // 학생수 입력 받기
				students = new Student[totalNum]; // student 배열에 지정한 수(totalNum)만큼 배열 생성 Student[] 는 배열을 생성 하는 것임 생성자 아님

			} else if (choice.equals("2")) {
				
				System.out.println("******************************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************************");
				
				for (Student student : students) { 
					if (student != null) 
						//student가 가지고 있는 번지로가 필드 값을 읽어 온다.
						System.out.println(student.no+ "\t\t" + student.name +"\t\t" + student.score);
					}
				}
				

			 else if (choice.equals("3")) {
				
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("점수 : ");
				int score = Integer.parseInt(scanner.nextLine());
				
				for (int i = 0; i < students.length; i++) {
				
					if (students[i] == null) {
						Student student = new Student(i, name, score);
						students[i] = student;
						break;
					}
				}

			} else if (choice.equals("4")) {
				
				System.out.print("삭제할 학번 : ");
				int sno = Integer.parseInt(scanner.nextLine());
				students[sno] = null;

			} else if (choice.equals("5")) {

				System.out.println("******************************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************************");

				int max = 0;
				for (Student student : students) {
					if (student != null) {						
						int score = student.score;
						if (max < score) {
							max = score;
						}	
					}
				}
				
				for (Student student : students) {	//최고 점수가 여러명 있을수 있기 때문에 필요

					if (student != null) {	
						int score = student.score;
						if (max == score) {
							System.out.println(student.no + "\t\t" + student.name +"\t\t" + student.score);
						}
					}
				}
				
			} else if (choice.equals("6")) {
				int count = 0;
				int sum = 0;
				for (Student student : students) {
					if (student != null) {
						count ++ ;	//student 객체가 null 이 있을수 있기 때문에 현재 있는 객체만 계산한다.
						sum += student.score;
					}
				}
				System.out.println("평균 : " + (double)sum/count);
				
			} else if (choice.equals("7")) {
				break;
			}

		}

	}

}
