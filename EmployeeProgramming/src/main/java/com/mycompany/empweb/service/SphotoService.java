package com.mycompany.empweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dao.SphotoDao;
import com.mycompany.empweb.dto.Sphoto;

/*작성자: 이윤주*/

@Component
public class SphotoService {
	public static final int WRITE_SUCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCESS = 0;
	public static final int MODIFY_FAIL = 1;

	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;

	@Autowired
	private SphotoDao sphotoDao;
	
	/*public List<Sphoto> list(int pageNo, int rowsPerPage){
		
		return sphotoDao.selectByPage(pageNo, rowsPerPage);
	}*/
	
	public List<Sphoto> getList(String sid){
		return sphotoDao.selectAll(sid);
	}
	public int write(Sphoto sphoto){
		sphotoDao.insert(sphoto);
		return WRITE_SUCESS;
	}
	public int modify(Sphoto sphoto){
		int row = sphotoDao.update(sphoto);
		if (row == 0) {return MODIFY_FAIL;}
		return MODIFY_SUCESS;
	}
	
	public int modifyAll(Sphoto sphoto){
		int row = sphotoDao.updateAll(sphoto);
		if (row == 0) {return MODIFY_FAIL;}
		return MODIFY_SUCESS;
	}
	public int remove(int spic_id){
		int row = sphotoDao.delete(spic_id);
		if (row == 0) {return REMOVE_FAIL;}//ex. 사용자의 게시물을 관리자가 지웠을때 사용자에게 게시물은 보이지만 DB에 남아 있지 않으므로 remove 할 수가 없다.
		return REMOVE_SUCESS;
	}
	
	public int removeAll(int sid){
		int row = sphotoDao.deleteAll(sid);
		if (row == 0) {return REMOVE_FAIL;}//ex. 사용자의 게시물을 관리자가 지웠을때 사용자에게 게시물은 보이지만 DB에 남아 있지 않으므로 remove 할 수가 없다.
		return REMOVE_SUCESS;
	}
	public Sphoto infoSpic_id(int spic_id){
		return sphotoDao.selectBySpic_id(spic_id);
	}
	
	public List<Sphoto> info(String sid){
		return sphotoDao.selectAll(sid);
	}
	
	/*public int getCount(){
		return sphotoDao.count();
	}*/
}


