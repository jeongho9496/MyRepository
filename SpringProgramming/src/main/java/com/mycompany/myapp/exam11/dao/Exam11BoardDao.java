package com.mycompany.myapp.exam11.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AlternativeJdkIdGenerator;

import com.mycompany.myapp.exam11.dto.Board;

@Component
public class Exam11BoardDao {	//service에 주입
	//1012
	
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardDao.class);
	
	public void insert(Board board){
		logger.info("insert 처리");
		logger.info("Writer : " + board.getBwriter());
		logger.info("Title : " + board.getBtitle());
		logger.info("Content : " + board.getBcontent());
	}
	
	public List<Board> selectList() {
		logger.info("selectList() 처리");
		List<Board> list = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {	//리스트 10개 생성
			Board board = new Board();
			board.setBtitle("제목 : "+i);
			board.setBcontent("내용 : "+i);
			board.setBwriter("글쓴이 : "+i);
			list.add(board);
		}
		
		return list;
	}
	
	//1013
	
	public Board selectBoard(int bno){
		logger.info("selectBoard() 처리");
		Board board = new Board();
		board.setBwriter("한가을");
		board.setBtitle("날씨가 쌀쌀합니다.");
		board.setBcontent("감기 조심하세요. 내일부터 감점 있습니다.");
		return board;
	}
	
	public void update(Board board){
		logger.info("Update 처리");	
	}

	public void delete(int bno) {
		logger.info("Delete 처리");
	}
}
