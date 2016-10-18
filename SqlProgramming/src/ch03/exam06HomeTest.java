package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class exam06HomeTest {
	public static void main(String[] args) {
		//1017
		//과제 1001번에 해당하는 객체를 찾아 출력
		Employee emp = getEmployee(1001);
		System.out.println(emp.getEmpno()+" : "+emp.getEname()+" : "+emp.getSal());
		System.out.println();
		//개발 이라고 넣은면 개발 1팀 2팀 다 출력 되게 하기
		List<Department> result = getDepartment("개발");
		for(Department dept : result){
			System.out.println(dept.getDeptno() + " : "+ dept.getDname() + " : " + dept.getLoc());
		}
	}
	
	private static Employee getEmployee(int searchEmpno) {
		Connection conn = null;//null을 사용하지 않으면 초기화 에러가 난다. 변수 선어난 할시 메모리에 저장이 되지않는다.
		Employee emp = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where empno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {//중복된 값이 없는 단일 값이기 때문에 if문 사용
				emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
		
		return emp;
	}

	private static List<Department> getDepartment(String searchName) {
		List<Department> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from dept where dname like ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchName+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e1) {
			}
		}
		return list;
	}
	
}
