package com.mycompany.empweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dao.ExtraDao;
import com.mycompany.empweb.dto.Extra;

@Component
public class ExtraService {
//김정호 11-18수정
	public static final int ADD_SUCESS = 0;
	public static final int ADD_FAIL = 1;
	
	public static final int MODIFY_SUCESS = 0;
	public static final int MODIFY_FAIL = 1;

	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
    
	@Autowired
	private ExtraDao extraDao;
	
	public int add(Extra extra){
		
		extraDao.insert(extra);
		return ADD_SUCESS;
	}
	
	public int modify(Extra extra){
		int row = extraDao.update(extra);
		if (row == 0) {return MODIFY_FAIL;}
		return MODIFY_SUCESS;
	}
	
	public int remove(int xid) {
		int row = extraDao.delete(xid);
		if (row == 0) {return REMOVE_FAIL;}
		return REMOVE_SUCESS;
	}
	
	public Extra info (int xid){
		return extraDao.selectByXid(xid);
	}
	
	//[명진]
	public Extra infoByXname (String xname){
		return extraDao.selectByXname(xname);
	}
	
	public List<Extra> getList(int xid){
		return extraDao.selectAll(xid);
	}
	

	
}
