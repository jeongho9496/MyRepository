package com.mycompany.empweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dto.User;

/*작성자: 이윤주*/

@Component
public class UserDao {
   
   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   public int insert(User user){
      String sql = "insert into user_table(user_id, user_email, user_pw, user_tel) values(?,?,?,?)";
      int row = jdbcTemplate.update(   //jdbcTemplate.update 성공시 1리턴
            sql,
            user.getUser_id(),
            user.getUser_email(),
            user.getUser_pw(),
            user.getUser_tel()
            );
      return row;
   }
   public int update(User user){
      String sql = "update user_table set user_email=?, user_pw=?, user_tel=? where user_id=?";
      int row = jdbcTemplate.update(
            sql,
            user.getUser_email(),// 사용자가 입력한 멤버 입력을 sql문의 ?표 순서대로 대입 된다.
            user.getUser_pw(),
            user.getUser_tel(),
            user.getUser_id()
            );
      return row;
   }
   public int delete(String user_id){
      String sql = "delete from user_table where user_id=?";
      
      int row = jdbcTemplate.update(sql, user_id);
      return row;
   }
   
   public User selectByUser_id(String user_id){
		/*Object[] arr;
		arr = new Object[]{"a","b","c"};//배열 선언된 후 배열 대입시 new 생성자를 명시한다.*/		
		
		String sql = "select user_id, user_email, user_pw, user_tel from user_table where user_id=?";
		List<User> list = jdbcTemplate.query(sql, new Object[]{user_id}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_tel(rs.getString("user_tel"));
				return user;
			}
		
		});
		return (list.size() != 0)? list.get(0):null;
	}
	
   public String selectByUser_pw(String user_id, String user_email){//비밀번호 찾기
      String sql = "select user_pw from user_table where user_id=? and user_email=?";
      List<String> list = jdbcTemplate.query(sql, new Object[]{user_email}, new RowMapper<String>(){

         @Override
         public String mapRow(ResultSet rs, int row) throws SQLException {
            
            return rs.getString("user_pw");
         }
      
      });
      return (list.size() != 0)? list.get(0):null;
   }
   
	public String selectByUser_email(String user_email){
		
		String sql = "select user_id from user_table where user_email=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{user_email}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getString("user_id");
			}
		
		});
		return (list.size() != 0)? list.get(0):null;
	}
	
}