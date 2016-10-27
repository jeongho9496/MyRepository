package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {
	//1025
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeBoard){
		String sql = "insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) "
				+ "values(seq_freeboard_bno.nextval,?,?,?,0,sysdate)";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBwriter()
				);
		return row;
	}
	
	//** Spring 사용시 좋은점
	/*
	 * 1.의존성 관리가 수월하다.
	 * 2.코드가 간결해짐
	 */
	
	public int update(FreeBoard freeBoard){
		String sql = "update freeboard set btitle=?, bcontent=?, bhitcount=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBhitcount(),
				freeBoard.getBno()
				);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from freeboard where bno=?";
		
		int row = jdbcTemplate.update(sql,bno);
		return row;
	}
	
	public FreeBoard selectByBno(int bno){
		String sql="select bno, btitle, bcontent, bwriter, bhitcount, bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<FreeBoard>(){

			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBcontent(rs.getString("bcontent"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage){//rowsPerPage : 한 페이지의 갯수 pageNo : 페이지 번호(ex. 1page, 2page, 3page)
	      String sql="";
	      sql += "select rn, bno, btitle, bwriter, bhitcount, bdate ";//rn => rownum
	      sql += "from ( ";
	      sql += "select rownum as rn, bno, btitle, bwriter, bhitcount, bdate ";
	      sql += "from (select bno, btitle, bwriter, bhitcount, bdate from freeboard order by bno desc) ";
	      sql += "where rownum<=? ";
	      sql += ") ";
	      sql += "where rn>=? ";
	      List<FreeBoard> list = jdbcTemplate.query(
	            sql, 
	            new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)},
	            //((pageNo-1)*rowsPerPage+1) => 한페이당 시작 번호 (1,11,21,31.....)
	            //(pageNo*rowsPerPage) => 한페이지당 나오는 게시판 개수
	            new RowMapper<FreeBoard>(){
	               @Override
	               public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
	                  FreeBoard freeBoard = new FreeBoard();
	                  freeBoard.setBno(rs.getInt("bno"));
	                  freeBoard.setBtitle(rs.getString("btitle"));
	                  freeBoard.setBwriter(rs.getString("bwriter"));
	                  freeBoard.setBhitcount(rs.getInt("bhitcount"));
	                  freeBoard.setBdate(rs.getDate("bdate"));
	                  return freeBoard;
	               }
	            }
	      );
	      return list;
	   }
	
	public int count(){
		String sql = "select count(*) from freeboard";//count(*) => 무조건 하나의 값이 넘어 온다. (0도 값)
		int count = jdbcTemplate.queryForObject(sql, Integer.class);//queryForObject = select 문으로 무조건 값이 넘어 오는 경우 사용
		
		return count;
	}
	
}
