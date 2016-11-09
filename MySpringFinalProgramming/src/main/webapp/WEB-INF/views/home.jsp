<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 1027 -->
<html>
	<head>
		<meta charset = "UTF-8">
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
	<body style="background-color: #d5b588;">
		<%-- MySpringFinalProgramming
		<hr/>
		1.
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/>
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
		
		2. <a href="<%=pageContext.getServletContext().getContextPath()%>/photoboard/list">포토 게시판</a><br/>
		
		3. <a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/> --%>
		
		<div class="jumbotron">
			<h1>나만의 PHOTO ALBUM</h1>
			<p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQeury,
				Ajax, Jsp, Spring</p>
			<p>
				<a class="btn btn-lg btn-success" href="<%=pageContext.getServletContext().getContextPath()%>/member/login" role="button">들어가기</a>
			</p>
		</div> 
	
	</body>
</html>
