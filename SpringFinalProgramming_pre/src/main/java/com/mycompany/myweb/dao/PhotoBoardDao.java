package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;


@Component
public class PhotoBoardDao {
	//1025
	
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public int insert(PhotoBoard photoBoard){
			
			String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) "
					+ "values(seq_photoboard_bno.nextval,?,?,?,0,sysdate,?,?,?)";
			
			int row = jdbcTemplate.update(
					sql,
					photoBoard.getBtitle(),
					photoBoard.getBcontent(),
					photoBoard.getBwriter(),
					photoBoard.getOriginalfile(),
					photoBoard.getSavedfile(),
					photoBoard.getMimetype()
					);
			
			return row;
		}
		
		//** Spring 사용시 좋은점
		/*
		 * 1.의존성 관리가 수월하다.
		 * 2.코드가 간결해짐
		 */
		
		public int update(PhotoBoard photoBoard){
			String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
			
			int row = jdbcTemplate.update(
					sql,
					photoBoard.getBtitle(),
					photoBoard.getBcontent(),
					photoBoard.getBhitcount(),
					photoBoard.getOriginalfile(),
					photoBoard.getSavedfile(),
					photoBoard.getMimetype(),
					photoBoard.getBno()
					);
			
			return row;
		}
		
		public int delete(int bno){
			String sql = "delete from photoboard where bno=?";
			
			int row = jdbcTemplate.update(sql,bno);
			return row;
		}
		
		public PhotoBoard selectByBno(int bno){
			String sql="select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype "
					+ "from photoboard where bno=?";
			List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<PhotoBoard>(){

				@Override
				public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
					// TODO Auto-generated method stub
					PhotoBoard photoBoard = new PhotoBoard();
					photoBoard.setBno(rs.getInt("bno"));
					photoBoard.setBtitle(rs.getString("btitle"));
					photoBoard.setBcontent(rs.getString("bcontent"));
					photoBoard.setBwriter(rs.getString("bwriter"));
					photoBoard.setBhitcount(rs.getInt("bhitcount"));
					photoBoard.setBdate(rs.getDate("bdate"));
					photoBoard.setOriginalfile(rs.getString("originalfile"));
					photoBoard.setSavedfile(rs.getString("savedfile"));
					photoBoard.setMimetype(rs.getString("mimetype"));
					
					return photoBoard;
				}
				
			});
			
			return (list.size() != 0)? list.get(0):null;
		}
		
		public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){//rowsPerPage : 한 페이지의 갯수 pageNo : 페이지 번호(ex. 1page, 2page, 3page)
		      String sql="";
		      sql += "select rn, bno, btitle, bhitcount, bdate, savedfile ";//이미지는 화면에 보여 지기만 하면 되므로 서버에 저장 되있는 이미지인 savedfile만 적는다.
		      sql += "from ( ";
		      sql += "select rownum as rn, bno, btitle, bhitcount, bdate, savedfile ";
		      sql += "from (select bno, btitle, bhitcount, bdate, savedfile from photoboard order by bno desc) ";
		      sql += "where rownum<=? ";
		      sql += ") ";
		      sql += "where rn>=? ";
		      List<PhotoBoard> list = jdbcTemplate.query(
		            sql, 
		            new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)},
		            //((pageNo-1)*rowsPerPage+1) => 한페이당 시작 번호 (1,11,21,31.....)
		            //(pageNo*rowsPerPage) => 한페이지당 나오는 게시판 개수
		            new RowMapper<PhotoBoard>(){
		               @Override
		               public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
		            	  PhotoBoard photoBoard = new PhotoBoard();
		            	  photoBoard.setBno(rs.getInt("bno"));
		                  photoBoard.setBtitle(rs.getString("btitle"));
		                  photoBoard.setBhitcount(rs.getInt("bhitcount"));
		                  photoBoard.setBdate(rs.getDate("bdate"));
		                  photoBoard.setSavedfile(rs.getString("savedfile"));
		                  return photoBoard;
		               }
		            }
		      );
		      return list;
		   }
		
		public int count(){
			String sql = "select count(*) from photoBoard";//count(*) => 무조건 하나의 값이 넘어 온다. (0도 값)
			int count = jdbcTemplate.queryForObject(sql, Integer.class);//queryForObject = select 문으로 무조건 값이 넘어 오는 경우 사용
			
			return count;
		}
}
