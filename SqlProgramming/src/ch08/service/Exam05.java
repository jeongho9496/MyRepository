package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam05 {
	//1019
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		board.setBno(100);
		board.setBtitle("title300");
		board.setBcontent("content300");
		board.setBwriter("writer300");
		board.setBhitcount(300);
		board.setBdate(new Date(1989,10,06));
		
		dao.update(board);
	
	}

}
