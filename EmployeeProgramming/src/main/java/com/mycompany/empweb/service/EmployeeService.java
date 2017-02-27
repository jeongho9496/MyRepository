package com.mycompany.empweb.service;

import java.util.List;
import java.util.Map;

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
	private EmployeeDao employeeDao;
	
	public int write(Employee emp){
		employeeDao.insert(emp);
		return WRITE_SUCCESS;
	}
	
	public int modify(Employee emp,int no){
		int row = employeeDao.update(emp, no);
		if (row == 0) {
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int remove(int no){
		int row = employeeDao.delete(no);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public Employee info(int no){
		return employeeDao.selectByNo(no);
	}

	public List<Map<String, Object>> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}
	
	public List<Map<String, Object>> searchEmployee(int searchType, String searchParam) {
		return employeeDao.searchEmployee(searchType, searchParam);
	}
}
