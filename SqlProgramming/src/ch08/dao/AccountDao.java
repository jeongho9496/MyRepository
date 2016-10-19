package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ch08.dto.Account;

public class AccountDao {
	//1019
	//Dao를 만들시 주의사항
	//1. Try/Catch문을 붙히면 안된다. => Throws사용.
	//2. Connection을 만드는 코드가 들어가면 안된다. => setter사용.
	//3. insert, update, delete 는 실행된 행수(rowNo => int)를 리턴값으로 한다.
	
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;	//Connection 추가
	}
	
	public int update(Account account) throws Exception{//사용하는 쪽(main)에서 트랜잭션 처리를 해야 하므로 꼭! throws로 넘긴다.
		String sql = "update account set abalance=? where ano = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		
		int rowNo = pstmt.executeUpdate();
		
		return rowNo;
	}
	
}
