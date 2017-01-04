package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Menu;

// 보나 20161111~

@Component
public class MenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	   
	private static final Logger logger = LoggerFactory.getLogger(MenuDao.class);
	
	public int insert(Menu menu){
		String sql = "insert into menu(mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid) values(seq_menu_mid.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				menu.getMgroup(),
				menu.getMname(), 
				menu.getHot_ice(),
				menu.getMprice(),
				menu.getMcontents(),
				menu.getMsavedfile(),
				menu.getMmimetype(),
				menu.getSid()
		);
		return row;
	}
	
	public int update(Menu menu){
		String sql = "update menu set mgroup=?, mname=?, hot_ice=?, mprice=?, mcontents=?, msavedfile=?, mmimetype=? where mid=?";
		int row = jdbcTemplate.update(
				sql,
				menu.getMgroup(),
				menu.getMname(),
				menu.getHot_ice(),
				menu.getMprice(),
				menu.getMcontents(),
				menu.getMsavedfile(),
				menu.getMmimetype(),
				//menu.getSid(),
				menu.getMid()
		);
		return row;
	}
	
	public int delete(int mid){
		String sql = "delete from menu where mid=?";
		int row = jdbcTemplate.update(sql, mid);
		return row;
	}
	 
	public Menu selectByMid(int mid){ 
		String sql = "select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where mid=?";
		List<Menu> list = jdbcTemplate.query(sql, new Object[]{mid}, new RowMapper<Menu>(){
			
			@Override
			public Menu mapRow(ResultSet rs, int row) throws SQLException {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMgroup(rs.getString("mgroup"));
				menu.setMname(rs.getString("mname"));
				menu.setHot_ice(rs.getString("hot_ice"));
				menu.setMprice(rs.getInt("mprice"));
				menu.setMcontents(rs.getString("mcontents"));
				menu.setMsavedfile(rs.getString("msavedfile"));
				menu.setMmimetype(rs.getString("mmimetype"));
				menu.setSid(rs.getString("sid"));
				return menu;
			}
		}); 
		logger.info("selectByMid 접근완료, 리턴값(list.size(): " + list.size());
		return (list.size() != 0)? list.get(0) : null;
	}
	
	
	public List<Menu> selectByPage(int pageNo, int rowsPerPage, String sid){
		String sql="";
		sql += "select rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( ";
		sql += "select rownum as rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu order by mid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? and sid=?";
		List<Menu> list = jdbcTemplate.query(
				sql,
				new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1), sid},
				new RowMapper<Menu>(){
					@Override
					public Menu mapRow(ResultSet rs, int row) throws SQLException {
						Menu menu = new Menu();
						menu.setMid(rs.getInt("mid"));
						menu.setMgroup(rs.getString("mgroup"));
						menu.setMname(rs.getString("mname"));
						menu.setHot_ice(rs.getString("hot_ice"));
						menu.setMprice(rs.getInt("mprice"));
						menu.setMcontents(rs.getString("mcontents"));
						menu.setMsavedfile(rs.getString("msavedfile"));
						menu.setMmimetype(rs.getString("mmimetype"));
						menu.setSid(rs.getString("sid"));
						return menu;
					}
				}
		);
		return list;
	}
	
	public List<Menu> selectByPageMgroup(int pageNo, int rowsPerPage, String sid, String mgroup){
		String sql="";
		sql += "select rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( ";
		sql += "select rownum as rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where sid=? and mgroup=?order by mid desc) ";
		sql += "where rownum<=?";
		sql += ") ";
		sql += "where rn>=?";
		
		Object[] sqlCondition = new Object[]{ sid, mgroup, (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1) };

		if(mgroup == null){
			sql = "select rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
			sql += "from ( ";
			sql += "select rownum as rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
			sql += "from ( select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where sid=?order by mid desc) ";
			sql += "where rownum<=?" ;
			sql += ") ";
			sql += "where rn>=?";

			sqlCondition = new Object[]{ sid, (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)};

		}
		
		List<Menu> list = jdbcTemplate.query(
				sql,
				sqlCondition,
				new RowMapper<Menu>(){
					@Override
					public Menu mapRow(ResultSet rs, int row) throws SQLException {
						Menu menu = new Menu();
						menu.setMid(rs.getInt("mid"));
						menu.setMgroup(rs.getString("mgroup"));
						menu.setMname(rs.getString("mname"));
						menu.setHot_ice(rs.getString("hot_ice"));
						menu.setMprice(rs.getInt("mprice"));
						menu.setMcontents(rs.getString("mcontents"));
						menu.setMsavedfile(rs.getString("msavedfile"));
						menu.setMmimetype(rs.getString("mmimetype"));
						menu.setSid(rs.getString("sid"));
						return menu;
					}
				}
		);
		System.out.println("menuSelectByPaging");
		return list;
	}
	
	//[명진]
	public List<Menu> selectByMgroup(String sid, String mgroup){
		String sql="select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where sid=? and mgroup=? order by mid desc";
		Object[] conditions = new Object[]{sid, mgroup};
		if(mgroup == null) {
			sql="select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where sid=? order by mid desc";
			conditions = new Object[]{sid};
		}
		List<Menu> list = jdbcTemplate.query(
				sql,
				conditions,
				new RowMapper<Menu>(){
					@Override
					public Menu mapRow(ResultSet rs, int row) throws SQLException {
						Menu menu = new Menu();
						menu.setMid(rs.getInt("mid"));
						menu.setMgroup(rs.getString("mgroup"));
						menu.setMname(rs.getString("mname"));
						menu.setHot_ice(rs.getString("hot_ice"));
						menu.setMprice(rs.getInt("mprice"));
						menu.setMcontents(rs.getString("mcontents"));
						menu.setMsavedfile(rs.getString("msavedfile"));
						menu.setMmimetype(rs.getString("mmimetype"));
						menu.setSid(rs.getString("sid"));
						return menu;
					}
				}
		);
		return list;
	}
	
	//[명진]
	public List<Menu> selectByMname(int pageNo, int rowsPerPage, String mname) {
		String mnameMody = "%"+mname+"%";
		String sql="";
		sql += "select rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( ";
		sql += "select rownum as rn, mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid ";
		sql += "from ( select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu order by mid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? and mname like ?";
		List<Menu> list = jdbcTemplate.query(
				sql,
				new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1), mnameMody},
				new RowMapper<Menu>(){
					@Override
					public Menu mapRow(ResultSet rs, int row) throws SQLException {
						Menu menu = new Menu();
						menu.setMid(rs.getInt("mid"));
						menu.setMgroup(rs.getString("mgroup"));
						menu.setMname(rs.getString("mname"));
						menu.setHot_ice(rs.getString("hot_ice"));
						menu.setMprice(rs.getInt("mprice"));
						menu.setMcontents(rs.getString("mcontents"));
						menu.setMsavedfile(rs.getString("msavedfile"));
						menu.setMmimetype(rs.getString("mmimetype"));
						menu.setSid(rs.getString("sid"));
						return menu;
					}
				}
		);
		return list;
	}
	
	//[명진]
	public List<Menu> selectByMname(String mname) {
		String sql = "select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where mname like ?";
		List<Menu> list = jdbcTemplate.query(sql, 
				new Object[]{mname}, 
				new RowMapper<Menu>(){
			
			@Override
			public Menu mapRow(ResultSet rs, int row) throws SQLException {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMgroup(rs.getString("mgroup"));
				menu.setMname(rs.getString("mname"));
				menu.setHot_ice(rs.getString("hot_ice"));
				menu.setMprice(rs.getInt("mprice"));
				menu.setMcontents(rs.getString("mcontents"));
				menu.setMsavedfile(rs.getString("msavedfile"));
				menu.setMmimetype(rs.getString("mmimetype"));
				menu.setSid(rs.getString("sid"));
				return menu;
			}
		}); 
		return list;
	}
	
	//[명진]
	public Menu selectByMnameHot_Ice(String mname, String hot_ice) {
		String sql = "select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where (mname like ? and hot_ice like ?)";
		List<Menu> list = jdbcTemplate.query(sql, 
				new Object[]{mname, hot_ice}, 
				new RowMapper<Menu>(){
			
			@Override
			public Menu mapRow(ResultSet rs, int row) throws SQLException {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMgroup(rs.getString("mgroup"));
				menu.setMname(rs.getString("mname"));
				menu.setHot_ice(rs.getString("hot_ice"));
				menu.setMprice(rs.getInt("mprice"));
				menu.setMcontents(rs.getString("mcontents"));
				menu.setMsavedfile(rs.getString("msavedfile"));
				menu.setMmimetype(rs.getString("mmimetype"));
				menu.setSid(rs.getString("sid"));
				return menu;
			}
		}); 
		return (list.size() != 0)? list.get(0) : null;
	}
	
	//[명진]//지우게 될 듯
	public List<Menu> selectByMidforList(int mid) {
		String sql = "select mid, mgroup, mname, hot_ice, mprice, mcontents, msavedfile, mmimetype, sid from menu where mid=?";
		List<Menu> list = jdbcTemplate.query(sql, 
				new Object[]{mid}, 
				new RowMapper<Menu>(){
			
			@Override
			public Menu mapRow(ResultSet rs, int row) throws SQLException {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMgroup(rs.getString("mgroup"));
				menu.setMname(rs.getString("mname"));
				menu.setHot_ice(rs.getString("hot_ice"));
				menu.setMprice(rs.getInt("mprice"));
				menu.setMcontents(rs.getString("mcontents"));
				menu.setMsavedfile(rs.getString("msavedfile"));
				menu.setMmimetype(rs.getString("mmimetype"));
				menu.setSid(rs.getString("sid"));
				return menu;
			}
		}); 
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from menu";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	
	public int countMgroup(String sid, String mgroup){
		if(mgroup == null) {
			String sql = "select count(*) from menu where sid=?";
			int count = jdbcTemplate.queryForObject(sql, new Object[] {sid}, Integer.class);
			return count;
		} else {
			String sql = "select count(*) from menu where sid=? and mgroup=?";
			int count = jdbcTemplate.queryForObject(sql, new Object[] {sid, mgroup}, Integer.class);
			return count;
		}
	}
	
}