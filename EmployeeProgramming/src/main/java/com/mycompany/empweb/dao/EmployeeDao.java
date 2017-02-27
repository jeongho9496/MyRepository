package com.mycompany.empweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		String sql = "INSERT INTO EMPLOYEES(EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL) VALUES(?,?,?,?,?)";
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
	
	public int update(Employee emp, int no){
		String sql = "UPDATE EMPLOYEES SET EMP_NO=?, EMP_NAME=?, EMP_PHONE=?, EMP_POSITION=?, EMP_EMAIL=? WHERE EMP_NO="+no;
		logger.info(sql);
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
	
	public int delete(int no){
		String sql = "DELETE FROM EMPLOYEES WHERE EMP_NO=?";
		int row = jdbcTemplate.update(sql, no);
		return row;
	}
	
	public Employee selectByNo(int no){
		String sql = "SELECT EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL FROM EMPLOYEES WHERE EMP_NO=?";
		List<Employee> list = jdbcTemplate.query(sql, new Object[]{no}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Employee emp = new Employee();
				emp.setNo(rs.getInt("EMP_NO"));
				emp.setName(rs.getString("EMP_NAME"));
				emp.setPhone(rs.getString("EMP_PHONE"));
				emp.setPosition(rs.getString("EMP_POSITION"));
				emp.setEmail(rs.getString("EMP_EMAIL"));
				return emp;
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
	
	public List<Map<String, Object>> getEmployeeList() {
		logger.info("============== 직원 리스트 불러오기 시작 ==============");
		StringBuilder query = new StringBuilder();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES ORDER BY EMP_NAME");
		
		resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString());
		
		// 데이터 검증
		if (!resultList.isEmpty()) {
			logger.info("직원 수 : " + resultList.size());
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> resultMap = resultList.get(i);
				logger.info("EMP_NO : " + resultMap.get("EMP_NO").toString());
				logger.info("EMP_NAME : " + resultMap.get("EMP_NAME").toString());
				logger.info("EMP_PHONE : " + resultMap.get("EMP_PHONE").toString());
				logger.info("EMP_POSITION : " + resultMap.get("EMP_POSITION").toString());
				logger.info("EMP_EMAIL : " + resultMap.get("EMP_EMAIL").toString());
			}
		}
		
		logger.info("============== 직원 리스트 불러오기 끝 ==============");
		return resultList;
	}
	
	public List<Map<String, Object>> searchEmployee(int searchType, String searchParam) {
		logger.info("============== 직원 검색 시작 ==============");
		logger.info("검색 타입 : " + searchType);
		logger.info("검색어 : " + searchParam);
		StringBuilder query = new StringBuilder();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		switch (searchType) {
		case 1 : 
			query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES WHERE EMP_NO = ? ")
				.append("ORDER BY EMP_NAME");
			resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString(), searchParam);
			break;
		case 2 : 
			query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES WHERE EMP_NAME = ? ")
				.append("ORDER BY EMP_NAME");
			resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString(), searchParam);
			break;
		case 3 : 
			query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES WHERE EMP_PHONE = ? ")
				.append("ORDER BY EMP_NAME");
			resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString(), searchParam);
			break;
		case 4 : 
			query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES WHERE EMP_POSITION = ? ")
				.append("ORDER BY EMP_NAME");
			resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString(), searchParam);
			break;
		case 5 : 
			query.append("SELECT LPAD(EMP_NO, 3, '0') AS EMP_NO, EMP_NAME, EMP_PHONE, EMP_POSITION, EMP_EMAIL ")
				.append("FROM EMPLOYEES WHERE EMP_EMAIL = ? ")
				.append("ORDER BY EMP_NAME");
			resultList = (List<Map<String, Object>>) jdbcTemplate.queryForList(query.toString(), searchParam);
			break;
		default : resultList = getEmployeeList();
			break;
		}
		
		// 데이터 검증
		if (!resultList.isEmpty()) {
			logger.info("직원 수 : " + resultList.size());
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> resultMap = resultList.get(i);
				logger.info("EMP_NO : " + resultMap.get("EMP_NO").toString());
				logger.info("EMP_NAME : " + resultMap.get("EMP_NAME").toString());
				logger.info("EMP_PHONE : " + resultMap.get("EMP_PHONE").toString());
				logger.info("EMP_POSITION : " + resultMap.get("EMP_POSITION").toString());
				logger.info("EMP_EMAIL : " + resultMap.get("EMP_EMAIL").toString());
			}
		}
		
		logger.info("============== 직원 검색 끝 ==============");
		return resultList;
		
	}
	
}
