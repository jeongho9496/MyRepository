package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import finalsource.dao.BoardDao;
import finalsource.dto.Board;

public class TestBoardDao {
	// 1009
	public static void main(String[] args) {
		testInsert();
		//testSelectByBno();
		//testSelectByBtitle();
		//testUpdate();
		//testDeleteByBno();
	}

	private static void testInsert() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			Board board = new Board();
			board.setBno(100);
			board.setBtitle("인생이란...");
			board.setBcontent("부질없다...");
			board.setBwriter("김정호");
			board.setBhitcount(100);
			board.setBdate(new Date());
			
			int rowNo = dao.insert(board);
			System.out.println(rowNo+"행이 저장됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

	private static void testSelectByBno() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			Board board = dao.selectByBno(100);
			if (board != null) {
				System.out.print(board.getBno() + " : ");
				System.out.print(board.getBtitle() + " : ");
				System.out.print(board.getBcontent() + " : ");
				System.out.print(board.getBwriter() + " : ");
				System.out.print(board.getBhitcount() + " : ");
				System.out.print(board.getBdate());
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

	private static void testSelectByBtitle() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			List<Board> list = dao.selectByBtitle("제목");
			for (Board board : list) {
				System.out.print(board.getBno() + " : ");
				System.out.print(board.getBtitle() + " : ");
				System.out.print(board.getBcontent() + " : ");
				System.out.print(board.getBwriter() + " : ");
				System.out.print(board.getBhitcount() + " : ");
				System.out.print(board.getBdate());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

	private static void testUpdate() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			Board board = new Board();
			board.setBno(100);
			board.setBtitle("배고프다...");
			board.setBcontent("미치도록...");
			board.setBwriter("누군가");
			board.setBhitcount(1);
			board.setBdate(new Date());
			
			
			int rowNo = dao.update(board);
			System.out.println(rowNo + "행이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

	private static void testDeleteByBno() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
		
			int rowNo = dao.deleteByBno(100);
			System.out.println(rowNo+"행이 삭제됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
