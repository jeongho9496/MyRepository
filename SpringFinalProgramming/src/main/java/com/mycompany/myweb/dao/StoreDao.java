package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Store;

@Component
public class StoreDao {
	/* 김정호	*/	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Store store){
		
		String sql = "insert into store(sid, semail, spw, sname, slocal, saddr, stel, sopen, sclosed, sbeacon)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		
		int row = jdbcTemplate.update(
				sql,
				store.getSid(),
				store.getSemail(),
				store.getSpw(),
				store.getSname(),
				store.getSlocal(),
				store.getSaddr(),
				store.getStel(),
				store.getSopen(),
				store.getSclosed(),
				store.getSbeacon()
				);
		
		return row;
	}
	
	public int update(Store store){
		
		String sql = "update store set semail=?, spw=?, sname=?, slocal=?, saddr=?, stel=?, sopen=?, sclosed=?, sbeacon=? where sid=?";
		int row = jdbcTemplate.update(
				sql,
				store.getSemail(),
				store.getSpw(),
				store.getSname(),
				store.getSlocal(),
				store.getSaddr(),
				store.getStel(),
				store.getSopen(),
				store.getSclosed(),
				store.getSbeacon(),
				store.getSid()
				);
		return row;
	}
	public int delete(String sid){
		
		String sql = "delete from store where sid=?";
		int row = jdbcTemplate.update( sql, sid );
		
		return row;
	}
	public Store selectBySid(String sid){
		String sql = "select sid, semail, spw, sname, slocal, saddr, stel, sopen, sclosed, sbeacon from store where sid=? ";
		
		List<Store> list = jdbcTemplate.query(sql, new Object[]{sid}, new RowMapper<Store>(){

			@Override
			public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Store store = new Store();
				store.setSid(rs.getString("sid"));
				store.setSemail(rs.getString("semail"));
				store.setSpw(rs.getString("spw"));
				store.setSname(rs.getString("sname"));
				store.setSlocal(rs.getString("slocal"));
				store.setSaddr(rs.getString("saddr"));
				store.setStel(rs.getString("stel"));
				store.setSopen(rs.getString("sopen"));
				store.setSclosed(rs.getString("sclosed"));
				store.setSbeacon(rs.getInt("sbeacon"));
			
				return store;
			}
			
		});
		return (list.size() != 0)? list.get(0):null;
	}
	public String selectBySemail(String semail){
		
		String sql = "select sid from store where semail=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{semail}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("sid");
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
	
	public String searchSpw(String sid, String semail){//비밀번호 찾기
		String sql = "select spw from store where sid=? and semail=? ";
		List<String> list = jdbcTemplate.query(sql, new Object[]{sid,semail}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getString("spw");
			}
		
		});
		return (list.size() != 0)? list.get(0):null;
	}

	public Store selectByBeacon(int sbeacon) {
		// TODO Auto-generated method stub
		String sql = "select sid, sname, slocal, saddr, stel, sopen, sclosed, sbeacon from store where sbeacon=? ";
		
		List<Store> list = jdbcTemplate.query(sql, new Object[]{sbeacon}, new RowMapper<Store>(){

			@Override
			public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Store store = new Store();
				store.setSid(rs.getString("sid"));
				store.setSname(rs.getString("sname"));
				store.setSlocal(rs.getString("slocal"));
				store.setSaddr(rs.getString("saddr"));
				store.setStel(rs.getString("stel"));
				store.setSopen(rs.getString("sopen"));
				store.setSclosed(rs.getString("sclosed"));
				store.setSbeacon(rs.getInt("sbeacon"));
			
				return store;
			}
			
		});
		return (list.size() != 0)? list.get(0):null;
	}
	
}