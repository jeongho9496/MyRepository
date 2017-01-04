package com.mycompany.myweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.EventMenuDao;
import com.mycompany.myweb.dto.EventMenu;
//지워야 할듯(검토 바람)
@Component
public class EventMenuService {
	
	@Autowired
	private EventMenuDao eventMenuDao;
	
//----------------------------------------------------
	public static final int WRITE_SUCCESS=0;
	public static final int WRITE_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int REMOVE_SUCCESS=0;
	public static final int REMOVE_FAIL=0;
	
//----------------------------------------------------	
	Logger logo = Logger.getLogger(EventMenuService.class);
	

	//이벤트 추가
	public int write(EventMenu eventmenu){
		int row = eventMenuDao.insert(eventmenu);
		
		return WRITE_SUCCESS;
	}
	
	//이벤트 수정
	public int modify(EventMenu eventmenu){
		int row = eventMenuDao.update(eventmenu);
		if(row == 0 ){
			logo.info("수정할 내용이 없습니다.");
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	//이벤트 제거
	public int remove(int emid){
		int row = eventMenuDao.delete(emid);
		if(row ==0){
			logo.info("삭제할 내용이 없습니다");
			return REMOVE_FAIL;
		}
		return REMOVE_SUCCESS;
	}
	//이벤트 조회
	public void list(){}
	
	  
}
