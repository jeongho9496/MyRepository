<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 1027 -->
<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		SpringFinalProgramming
		<hr/>
		1.
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/>
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
		
		2. <a href="<%=pageContext.getServletContext().getContextPath()%>/photoboard/list">포토 게시판</a><br/>
		
		3. <a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/>
	
	</body>
</html>
