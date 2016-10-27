<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--1027 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		로그인
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			아이디: <input type="text" name="mid" value="${findMid}"><br/>
			<c:if test="${error == 'LOGIN_FAIL_MID'}">*아이디가 존재하지 않음</c:if>
			<br/>
			패스워드: <input type="password" name="mpassword"><br/>
			<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}">*패스워드가 틀림</c:if>
			<br/>
			<input type="submit" value="로그인"/>
		</form>
		
		<a href ="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/><%--상대경로 --%>
		<a href ="findMid">아이디 찾기</a><br/>											<%--절대경로 --%>
		비밀번호 찾기
	</body>
</html>