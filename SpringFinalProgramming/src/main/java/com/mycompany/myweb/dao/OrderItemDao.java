package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class OrderItemDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//중요
	//1개 주문에 대한 모든 품목 리스트 찾기
	public List<OrderItem> selectOrderItemsByOgid(String ogid){
		String sql = "select oid,ogid,mid,ordercount from order_item where ogid like ?";
		List<OrderItem> orderItems =  jdbcTemplate.query(sql, 
				new Object[]{ogid}, 
				new RowMapper<OrderItem>(){
				  		
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderItem = new OrderItem();
				orderItem.setOid(rs.getInt("oid"));
				orderItem.setOgid(rs.getString("ogid"));
				orderItem.setMid(rs.getInt("mid"));
				orderItem.setOrdercount(rs.getInt("ordercount"));
				
				return orderItem;
			}			
		});
		return orderItems;
	}
	
	//주문 품목 삽입(1개)(주문할 때 필요)
	public int insertOrderItem(String ogid, int mid, int ordercount) {
		String sql = "insert into order_item(oid, ogid, mid, ordercount) values(seq_order_item_oid.nextval,?,?,?)";
		int row = jdbcTemplate.update(sql, ogid, mid, ordercount);
		return row;		
	}
	
	//주문 품목 삽입(1개)
	/*public int insertOrderItem(OrderItem orderitem){
		String sql = "insert into order_item(oid, ogid, mid, ordercount) values(seq_order_item_oid.nextval,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				orderitem.getOgid(),
				orderitem.getMid(),
				orderitem.getOrdercount()
		);
		return row;		
	}*/
	
	//1개 주문 품목 삭제
	public int deleteOrderItem(OrderItem orderitem){
		String sql = "delete from order_item where oid=?";
		int row = jdbcTemplate.update(sql, orderitem.getOid());
		return row;
		
	}
	
	//주문 품목 검색(1개)(oid)
	public OrderItem selectOrderItemByOid(int oid){
		String sql = "select oid,ogid,mid,ordercount from order_item where oid=?";
		List<OrderItem> list = jdbcTemplate.query(sql, new Object[]{oid}, new RowMapper<OrderItem>(){
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderitem = new OrderItem();
				orderitem.setOid(rs.getInt("oid"));
				orderitem.setOgid(rs.getString("ogid"));
				orderitem.setMid(rs.getInt("mid"));
				orderitem.setOrdercount(rs.getInt("ordercount"));
					
				return orderitem;
			}
				
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	//주문 품목 검색(1개)(ogid,mid)
	public OrderItem selectOrderItemByOgidMid(String ogid,int mid){
		String sql = "select oid,ogid,mid,ordercount from order_item where ogid like ? and mid=?";
		List<OrderItem> list = jdbcTemplate.query(sql, new Object[]{ogid,mid}, new RowMapper<OrderItem>(){
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderitem = new OrderItem();
				orderitem.setOid(rs.getInt("oid"));
				orderitem.setOgid(rs.getString("ogid"));
				orderitem.setMid(rs.getInt("mid"));
				orderitem.setOrdercount(rs.getInt("ordercount"));
					
				return orderitem;
			}
				
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	//주문 품목 검색(다수)(ogid,mid)
	public List<OrderItem> selectOrderItemsByOgidMid(String ogid,int mid){
		String sql = "select oid,ogid,mid,ordercount from order_item where ogid like ? and mid=?";
		List<OrderItem> orderitems = jdbcTemplate.query(sql, new Object[]{ogid,mid}, new RowMapper<OrderItem>(){
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderitem = new OrderItem();
				orderitem.setOid(rs.getInt("oid"));
				orderitem.setOgid(rs.getString("ogid"));
				orderitem.setMid(rs.getInt("mid"));
				orderitem.setOrdercount(rs.getInt("ordercount"));
					
				return orderitem;
			}
				
		});
		return orderitems;
	}	
	
		
	//------------------------------------------------------------------------------
	
	
	/*//중요
	//1개 주문에 대한 1개 품목 메뉴(mid) 찾기
	public int selectMidByOrid(int orid){
		String sql = "select mid from order_item where orid=?";
		List<Integer> list =  jdbcTemplate.query(sql, 
				new Object[]{orid}, 
				new RowMapper<Integer>(){
					  		
			@Override
			public Integer mapRow(ResultSet rs, int row) throws SQLException {
				Integer mid = new Integer(rs.getInt("mid"));
				
				return mid;
			}			
		});
		return (list.size() != 0)?list.get(0):null;
	}*/
	
}
