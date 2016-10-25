package com.mycompany.kjhapp.exam12.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.kjhapp.exam12.dao.MemberDao;
import com.mycompany.kjhapp.exam12.dto.Member;



@Component
public class Exam12Service {
	//1024
	private static final Logger logger = LoggerFactory.getLogger(Exam12Service.class);
	
	@Autowired
	private DataSource dataSource;//servlet_context에서 구현한 dataSource구현객체 주입
	
	@Autowired
	private MemberDao dao;
	
	public void join(Member member){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();//dataSource의 connection 대여
			dao.setConn(conn);
			
			int rowNo = dao.insert(member);
			logger.info(rowNo + "행이 저장됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();//connection 반납
			} catch (SQLException e) {
			}
		}
	}
	
}
