package ch18.exam09;

import java.io.File;

public class FileExample {
	// 0921
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:/Temp/aaa");
		if (file.exists()) {
			if (file.isDirectory()) {	//디렉토리 유무
				System.out.println("디렉토리 존재");
			} else {
				System.out.println("파일 존재");
			}

		} else {
			System.out.println("파일 존재하지 않음");
		}
		
		File dir = new File("C:/Temp/dir1/dir2/dir3");
//		dir.mkdir();	//맨 마지막 디렉토리 하나만 생성
		dir.mkdirs();	//모든 디렉토리 생성

		dir.delete();	//경로 마지막 dir3삭제
	}

}
