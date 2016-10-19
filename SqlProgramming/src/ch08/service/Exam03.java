package ch08.service;

import ch08.dao.MemberDao;

public class Exam03 {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		dao.deleteByMid("user5");
	}
}
