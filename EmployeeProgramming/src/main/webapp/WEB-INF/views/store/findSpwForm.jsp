<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 보나: 20161122 store 아이디/비번찾기 전체수정 --%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript"
				src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript"
				src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
		<link
			href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/css/bootstrap.min.css"
			rel="stylesheet" />
		<link
			href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css"
			rel="stylesheet" />
	</head>
	<body>
		비밀번호 찾기
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			아이디: <input type="text" name="sid"><br/>
			이메일: <input type="email" name="semail"><br/>
			${error}
			<input type="submit" value="찾기"/>
			<a href="login"> <input type="button" value="돌아가기"/> </a>
		</form>
		
		<a href ="findSid">아이디 찾기</a><br/>											<%--절대경로 --%>
		
	</body>
</html>