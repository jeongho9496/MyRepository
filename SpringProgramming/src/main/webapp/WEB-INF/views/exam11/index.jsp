<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam11
		<hr/>
		
		1) <a href="/myapp/exam11/memberJoin">회원 가입</a><br/>
		2) <a href="/myapp/exam11/memberLogin">회원 로그인</a><br/>
		3) <a href="/myapp/exam11/memberLogout">회원 로그아웃</a><br/>
		
		<br/>

		4) <a href="/myapp/exam11/boardWrite">게시물 쓰기</a><br/>
		5) <a href="/myapp/exam11/boardList">게시물 목록</a><br/>
		<%-- 1013 --%>
		6) <a href="/myapp/exam11/boardView?bno=5">게시물 보기</a><br/><%-- Get 방식 --%>
		7) <a href="/myapp/exam11/boardUpdate?bno=5">게시물 수정</a><br/>
		8) <a href="/myapp/exam11/boardDelete?bno=5">게시물 삭제</a><br/>
		
	</body>
</html>