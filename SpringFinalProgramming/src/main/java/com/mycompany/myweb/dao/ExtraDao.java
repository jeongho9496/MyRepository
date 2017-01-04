package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Event;
import com.mycompany.myweb.dto.Extra;



/*DAO를 처리하기 위해 Spring에서 JDBC를 지원하는데
지원하는 방식에는 JdbcTemplate, namedParameterJdbcTemplate, SimpleJdbcTemplate이 있다.abstract

JdbcTemplate 을 사용하려면, 일단  DataSource 를 다음과 같이 넣어준 후 생성해야 한다.

<bean id="DataSource" class="org.apache.commons.dbcp.BasicDataSource"
      destroy-method = "close"
      p: url =:jdbc:oracle:thin:@127.0.0.1:1521:ORCL"
      p: username ="SCOTT"
      P:password =""/>


<bean id="JdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate"
      p:dataSource-ref ="DataSource" />
      

<bean id = "SimpleJdbcTmeplate" class="org.spirngframework.jdbc.core.simple.SimpleJdbceTemplate">
	<!-- p:dataSource-ref =" DataSource" /> -->
	<constructor-arg ref="DataSource"/>
</bean>

 Template는 두가지 방식으로 선언했다. 
 p:dataSource-ref는 프로퍼티 방식으로 클래스를 주입하는 것이다.
 JdbcTempalte는 프로퍼티 방식으ㅗㄹ setter를 이용해서 DataSource를 넣어준 후에 클래스를 생성한다.
 SimpleJdbcTempalte는 setter가 마려뇌어 있지 않아 생성자 방식으로만 클래스 생성이 가능하다.
 
 이제 자바 클래스에서는 Template를 선언 후에 생성자로 받던지 프로퍼티로 받아서 사용하면 된다.
 
*/
@Component
public class ExtraDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Extra extra){
		
		String sql = "insert into extra(xid, xname, xprice) "
				+ "values(seq_extra_xid.nextval, ?, ?)"; //nextval: 시퀀스에 새로운 값을 할당한다
		
		int row = jdbcTemplate.update(
				sql,
				extra.getXname(),
				extra.getXprice()
				);
		return row;
	}
	
	public int update(Extra extra){
		String sql = "update extra set xname=?, xprice=? where xid=?";
		int row = jdbcTemplate.update(
				sql,
				extra.getXname(),
				extra.getXprice(),
				extra.getXid()
				);
		return row;
	}
	
	public int delete(int xid){
		String sql = "delete from extra where xid=?";
		
		int row = jdbcTemplate.update(sql,xid);
		return row;
	}
	
	public Extra selectByXid(int xid){
		String sql="select xid, xname, xprice from extra where xid=?";
		List<Extra> list = jdbcTemplate.query(sql, 
				new Object[]{xid}, 
				new RowMapper<Extra>(){
			    //Spring JDBC API로 select문을 수행하는 경우 결과값을 단순하게 정수값이나 문자열로 받지 않고,
			    //VO(Value Object)객체에 담아야 하는 경우가 있다. 이 경우 VO 객체에 DB에서 select한 데이터가 어떻게 매핑 되어야 하는지에 대한 정의가 필요하다. 
			    //이 매핑과 관련된 설정을 위해서 제공되는 것이 RowMapper 인터페이스이다.
			    //RowMapper는 인터페이스이기 때문에 객체를 생성할 수 없다. 따라서 RowMapper 인터페이스를 구현한 클래스 내에 결과값의 매핑 정보를 담고 
			    //그것을 JdbcTemplate 메소드의 매개변수로 넘겨주면 된다.
                
			    //만약 RowMapper를 사용했다면 mapRow() 메소드 내에 Extra의 새성자로부터 Extra를 생성한다.
			    //생성된 Extra를 구문을 적어주면 된다.
			@Override
			public Extra mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Extra extra = new Extra();
				extra.setXid(rs.getInt("xid"));
				extra.setXname(rs.getString("xname"));
				extra.setXprice(rs.getInt("xprice"));
				return extra;
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
	
	public List<Extra> selectAll(int xid){
		String sql = "select xid, xname, xprice from extra where xid=?";
		List<Extra> list = jdbcTemplate.query(sql, new Object[]{xid}, new RowMapper<Extra>(){
			
			@Override
			public Extra mapRow(ResultSet rs, int rowNum) throws SQLException {
				Extra extra = new Extra();
				extra.setXid(rs.getInt("xid"));
				extra.setXname(rs.getString("xname"));
				extra.setXprice(rs.getInt("xprice"));
				return extra;
			}
			
		}
		);
		return list;
	}
	
	//[명진]
	public Extra selectByXname(String xname) {
		String sql="select xid, xname, xprice from extra where xname like ?";
		List<Extra> list = jdbcTemplate.query(sql, 
				new Object[]{xname}, 
				new RowMapper<Extra>(){
			@Override
			public Extra mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Extra extra = new Extra();
				extra.setXid(rs.getInt("xid"));
				extra.setXname(rs.getString("xname"));
				extra.setXprice(rs.getInt("xprice"));
				return extra;
			}
			
		});
		
		return (list.size() != 0)? list.get(0):null;
	}
}

