package com.mycompany.empweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.empweb.dto.Sphoto;

/*작성자: 이윤주*/

@Component
public class SphotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Sphoto sphoto) {
		String sql = "insert into Sphoto(spic_id, spic_savedfile, spic_mimetype, sid) values(SEQ_SPHOTO_SPID.nextval,?,?,?) ";

		int row = jdbcTemplate.update(sql, sphoto.getSpic_savedfile(), sphoto.getSpic_mimetype(), sphoto.getSid());

		return row;
	}

	public int update(Sphoto sphoto) {
		String sql = "update sphoto set spic_savedfile=?, spic_mimetype=? where spic_id=? ";

		int row = jdbcTemplate.update(sql, sphoto.getSpic_savedfile(), sphoto.getSpic_mimetype(), sphoto.getSpic_id());

		return row;
	}
	
	public int updateAll(Sphoto sphoto) {
		String sql = "update sphoto set spic_savedfile=?, spic_mimetype=? where sid=? ";

		int row = jdbcTemplate.update(sql, sphoto.getSpic_savedfile(), sphoto.getSpic_mimetype(), sphoto.getSid());

		return row;
	}

	public int delete(int spic_id) {
		String sql = "delete from sphoto where spic_id=? ";
		int row = jdbcTemplate.update(sql, spic_id);
		return row;

	}

	public int deleteAll(int sid) {
		String sql = "delete from sphoto where sid=? ";
		int row = jdbcTemplate.update(sql, sid);
		return row;

	}

	public Sphoto selectBySpic_id(int spic_id) {
		String sql = "select spic_id, spic_savedfile from sphoto where spic_id=? ";

		List<Sphoto> list = jdbcTemplate.query(sql, new Object[] { spic_id }, new RowMapper<Sphoto>() {

			@Override
			public Sphoto mapRow(ResultSet rs, int row) throws SQLException {
				Sphoto sphoto = new Sphoto();
				sphoto.setSpic_id(rs.getInt("spic_id"));
				sphoto.setSpic_savedfile(rs.getString("savedfile"));
				sphoto.setSpic_mimetype(rs.getString("smimetype"));
				sphoto.setSid(rs.getString("sid"));

				return sphoto;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}

	public List<Sphoto> selectAll(String sid) {
		String sql = "select spic_id, spic_savedfile, spic_mimetype, sid from sphoto where sid=?";

		List<Sphoto> list = jdbcTemplate.query(sql, new Object[] { sid }, new RowMapper<Sphoto>() {
			@Override
			public Sphoto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sphoto sphoto = new Sphoto();
				sphoto.setSpic_id(rs.getInt("spic_id"));
				sphoto.setSpic_savedfile(rs.getString("spic_savedfile"));
				sphoto.setSid(rs.getString("sid"));
				sphoto.setSpic_mimetype(rs.getString("spic_mimetype"));
				return sphoto;
			}
		});

		return list;
	}

}