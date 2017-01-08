package com.mycompany.empweb.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dto.Employee;

@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	
	public int insert(Employee emp){
		String sql = "insert into employees(emp_no, emp_name, emp_phone, emp_position, emp_email) values(?,?,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				emp.getNo(),
				emp.getName(),
				emp.getPhone(),
				emp.getPosition(),
				emp.getEmail()
				);
		return row;
	}
	
	
	
}
