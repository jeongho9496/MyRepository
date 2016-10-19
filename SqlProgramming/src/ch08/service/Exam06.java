package ch08.service;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam06 {
	//1019
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		
		dao.deleteByBno(100);

	}

}
