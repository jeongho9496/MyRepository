package com.mycompany.empweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dao.StoreDao;
import com.mycompany.empweb.dto.Store;

@Component
public class StoreService {
//김정호
	
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS=0;
	public static final int LOGIN_FAIL_SID=1;
	public static final int LOGIN_FAIL_SPW=2;	

	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS=0;
	public static final int WITHDRAW_FAIL=1;
	
	@Autowired
	private StoreDao storeDao;
	
	public int join(Store store){
		storeDao.insert(store);
		return JOIN_SUCCESS;
	}
	
	public int login(String sid, String spw){
		
		Store store = storeDao.selectBySid(sid);
		if (store == null) {
			return LOGIN_FAIL_SID;
		} 
		
		if(store.getSpw().equals(spw) == false){
			//디비에 있는 비밀번호와 다름.
			return LOGIN_FAIL_SPW;
		}
		
		return LOGIN_SUCCESS;
	}
	
	public Store info(String sid) {
		//매장 정보
		Store store = storeDao.selectBySid(sid);
		return store;
	}
	
	public boolean isSid(String sid){
		//기존 회원 아이디 있는지 체크
		Store store = storeDao.selectBySid(sid);
		if (store==null) {
			return false;
		}//기존 회원 아이디가 없다.
		return true;
	}
	
	public String findSid(String semail){
		//회원 아이디 찾기
		return storeDao.selectBySemail(semail);
	}
	
	public String findSpw(String sid, String semail){
		
		Store store = storeDao.selectBySid(sid);
		if (store == null) return null;
		if (store.getSemail().equals(semail) == false) return null;
		return store.getSpw();
			
	}
	
	public int modify(Store store){
		int row = storeDao.update(store);
		if (row == 0) {
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	
	//김정호 test
	public Store findStore(int sbeacon){
		return storeDao.selectByBeacon(sbeacon);
	}

}