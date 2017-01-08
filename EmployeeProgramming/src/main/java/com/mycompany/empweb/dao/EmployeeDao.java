package com.mycompany.empweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public int update(Employee emp){
		String sql = "update employees set emp_no=?, emp_name=?, emp_phone=?, emp_position=?, emp_email=? where emp_no=?";
		
		int row = jdbcTemplate.update(
				sql,
				emp.getNo(),
				emp.getName(),
				emp.getPhone(),
				emp.getPosition(),
				emp.getEmail(),
				emp.getNo()
				);
		logger.info(sql);
		return row;
	}
	
	public int delete(int no){
		String sql = "delete from employees where emp_no=?";
		int row = jdbcTemplate.update(sql, no);
		return row;
	}
	
	public Employee selectByNo(int no){
		String sql = "select emp_no, emp_name, emp_phone, emp_position, emp_email from employees where emp_no=?";
		List<Employee> list = jdbcTemplate.query(sql, new Object[]{no}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Employee emp = new Employee();
				emp.setNo(rs.getInt("emp_no"));
				emp.setName(rs.getString("emp_name"));
				emp.setPhone(rs.getString("emp_phone"));
				emp.setPosition(rs.getString("emp_position"));
				emp.setEmail(rs.getString("emp_email"));
				return emp;
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
	
	
	
}
