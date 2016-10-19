package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam04 {
	//1019
	public static void main(String[] args) {
		BoardDao boardDao = new BoardDao();
		
		Board board = new Board();
		board.setBno(100);
		board.setBtitle("title100");
		board.setBcontent("content100");
		board.setBwriter("writer100");
		board.setBhitcount(100);
		board.setBdate(new Date());
		
		boardDao.insert(board);

	}

}
