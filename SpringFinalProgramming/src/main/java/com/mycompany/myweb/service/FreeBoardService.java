package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.FreeBoardDao;
import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardService {
	private static final int WRITE_SUCESS = 0;
	private static final int WRITE_FAIL = 1;
	
	private static final int MODIFY_SUCESS = 0;
	private static final int MODIFY_FAIL = 1;

	private static final int REMOVE_SUCESS = 0;
	private static final int REMOVE_FAIL = 1;
	
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	public List<FreeBoard> list(int pageNo, int rowsPerPage){
		
		return freeBoardDao.selectByPage(pageNo, rowsPerPage);
	}
	public int write(FreeBoard freeBoard){
		int row = freeBoardDao.insert(freeBoard);
		return WRITE_SUCESS;
	}
	public int modify(FreeBoard freeBoard){
		int row = freeBoardDao.update(freeBoard);
		if (row == 0) {return MODIFY_FAIL;}
		return MODIFY_SUCESS;
	}
	public int remove(int bno){
		int row = freeBoardDao.delete(bno);
		if (row == 0) {return REMOVE_FAIL;}//ex. 사용자의 게시물을 관리자가 지웠을때 사용자에게 게시물은 보이지만 DB에 남아 있지 않으므로 remove 할 수가 없다.
		return REMOVE_SUCESS;
	}
	public FreeBoard info(int bno){
		return freeBoardDao.selectByBno(bno);
	}
	
	public int getCount(){
		return freeBoardDao.count();
	}
}
