package ch07.service;

import java.util.List;

import ch07.dao.BoardDao;
import ch07.dto.Board;

public class BoardService {
	public static void main(String[] args) {
		//1018
		BoardDao dao = new BoardDao();
		
		//아이디 정보를 주고 멤버 정보를 얻기
		Board board = dao.selectByBno(1);
		System.out.println(board.getBno() + " : " + board.getBtitle() + " : " + board.getBcontent());
		System.out.println("----------------------------------------------------------------------");
		//현재 총 멤버의 정보를 얻기
		List<Board> list = dao.selectAll();
		for (Board b : list) {
			System.out.println(b.getBno() + " : " + b.getBtitle() + " : " + b.getBcontent());
		}
	}
}
