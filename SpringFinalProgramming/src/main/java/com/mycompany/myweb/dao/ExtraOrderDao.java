package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.ExtraOrder;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class ExtraOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//중요
	
	//1개 주문에 대한 모든 사이드오더 리스트 찾기
	public List<ExtraOrder> selectExtraOrdersByOid(int oid){
		String sql = "select xid,oid from extra_order where oid=?";
		List<ExtraOrder> extraOrders =  jdbcTemplate.query(sql, 
				new Object[]{oid}, 
				new RowMapper<ExtraOrder>(){
			  		
			@Override
			public ExtraOrder mapRow(ResultSet rs, int row) throws SQLException {
				ExtraOrder extraOrder = new ExtraOrder();
				extraOrder.setXid(rs.getInt("xid"));
				extraOrder.setOid(rs.getInt("oid"));
	
				return extraOrder;
			}			
		});
		return extraOrders;
	}
	
	//주문 품목 사이드오더 삽입(다수)
	public int insertExtraOrder(ExtraOrder extraOrder){
		String sql = "insert into extra_order(xid,oid) values(?,?)";
		int row = jdbcTemplate.update(
				sql,
				extraOrder.getXid(),
				extraOrder.getOid()
		);
		return row;		
	}
	
	//주문 품목 사이드오더 삽입(다수)
	public int insertExtraOrder(int xid, int oid){
		String sql = "insert into extra_order(xid,oid) values(?,?)";
		int row = jdbcTemplate.update(sql,xid,oid);
		return row;		
	}
	
	//1개 주문 품목 사이드오더 삭제
	public int deleteExtraOrder(ExtraOrder extraOrder){
		String sql = "delete from extra_order where oid=?";
		int row = jdbcTemplate.update(sql, extraOrder.getOid());
		return row;
	}
	
	
	//-----------------------------------------------------------
}
