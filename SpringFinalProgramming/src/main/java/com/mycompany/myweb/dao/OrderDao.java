package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Order;
//명진
@Component
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//주문 삽입
	public int insertOrder(Order order) {
		String sql = "insert into order_total(ogid,ogtotalprice,ogtime,user_id,sid,oghowpay) values(?,?,sysdate,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				order.getOgid(),
				order.getOgtotalprice(),
				order.getUser_id(),
				order.getSid(),
				order.getOghowpay()
				);
		return row;
	}

	
	
	//1개 주문 검색
	public Order selectByOgid(String ogid) {
		String sql = "select ogid,ogtotalprice,ogtime,user_id,sid,oghowpay from order_total where ogid like ?";
		List<Order> list = jdbcTemplate.query(sql, 
				new Object[] {ogid},
				new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int row) throws SQLException {
				Order order = new Order();
				order.setOgid(rs.getString("ogid"));
				order.setOgtotalprice(rs.getInt("ogtotalprice"));
				order.setOgtime(rs.getDate("ogtime"));
				order.setUser_id(rs.getString("user_id"));
				order.setSid(rs.getString("sid"));
				order.setOghowpay(rs.getString("oghowpay"));

				return order;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	//기간 주문 검색
	public List<Order> selectByTerm(int pageNo, int rowsPerPage, Date term1, Date term2) {
		String sql ="";
		sql += "select rn, ogid, ogtotalprice, ogtime, user_id, sid, oghowpay ";
		sql += "from( ";
		sql += "select rownum as rn, ogid, ogtotalprice, ogtime, user_id, sid, oghowpay ";
		sql += "from(select ogid, ogtotalprice, ogtime, user_id, sid, oghowpay from order_total where ogtime between ? and ? order by ogtime desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";

		List<Order> list = jdbcTemplate.query(sql,
				new Object[] { term1, term2,(pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int row) throws SQLException {
						Order order = new Order();
						order.setOgid(rs.getString("ogid"));
						order.setOgtotalprice(rs.getInt("ogtotalprice"));
						order.setOgtime(rs.getDate("ogtime"));
						order.setUser_id(rs.getString("user_id"));
						order.setSid(rs.getString("sid"));
						order.setOghowpay(rs.getString("oghowpay"));

						return order;
					}
				});

		return list;
	}

	
	//모든 주문 검색 페이지
	public List<Order> selectByPage(int pageNo, int rowsPerPage) {
		String sql ="";
		sql += "select rn, ogid, ogtotalprice, ogtime, user_id, sid, oghowpay ";
		sql += "from( ";
		sql += "select rownum as rn, ogid, ogtotalprice, ogtime, user_id, sid, oghowpay ";
		sql += "from(select ogid, ogtotalprice, ogtime, user_id, sid, oghowpay from order_total order by ogtime desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";

		List<Order> list = jdbcTemplate.query(sql,
				new Object[] { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int row) throws SQLException {
						Order order = new Order();
						order.setOgid(rs.getString("ogid"));
						order.setOgtotalprice(rs.getInt("ogtotalprice"));
						order.setOgtime(rs.getDate("ogtime"));
						order.setUser_id(rs.getString("user_id"));
						order.setSid(rs.getString("sid"));
						order.setOghowpay(rs.getString("oghowpay"));

						return order;
					}

				});

		return list;
	}
	
	//주문 삭제
	public int deleteOrder(String ogid) {
		String sql = "delete from order_total where ogid like ?";
		int row = jdbcTemplate.update(sql, ogid);
		return row;
	}
	
	//주문 카운트
	public int countOrder() {
		String sql = "select count(*) from order_total";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	//------------------------------------------------------------------


	//주문 기간 조회(완료)(주문할 때)(지워질 듯)
	public Order selectByTime(Date start, Date end) {
		String sql = "select ogid,ogtotalprice,ogtime,user_id,sid,oghowpay from order_total where ogtime between ? and ?";
		List<Order> list = jdbcTemplate.query(sql, 
				new Object[] {start, end},
				new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int row) throws SQLException {
				Order order = new Order();
				order.setOgid(rs.getString("ogid"));
				order.setOgtotalprice(rs.getInt("ogtotalprice"));
				order.setOgtime(rs.getDate("ogtime"));
				order.setUser_id(rs.getString("user_id"));
				order.setSid(rs.getString("sid"));
				order.setOghowpay(rs.getString("oghowpay"));

				return order;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}

	//주문 가격 수정(완료)
	public int updateOgprice(String ogid, int ogprice) {
		String sql = "update order_total set ogtotalprice = ? where ogid like ?";
		int row = jdbcTemplate.update(sql, ogprice, ogid);
		return row;
	}
}
