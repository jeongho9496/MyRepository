package com.mycompany.empweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dao.EmployeeDao;
import com.mycompany.empweb.dto.Employee;

@Component
public class EmployeeService {
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private EmployeeDao empDao;
	
	public int write(Employee emp){
		empDao.insert(emp);
		return WRITE_SUCCESS;
	}
	
	public int modify(Employee emp){
		int row = empDao.update(emp);
		if (row == 0) {
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int remove(int no){
		int row = empDao.delete(no);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}

}
