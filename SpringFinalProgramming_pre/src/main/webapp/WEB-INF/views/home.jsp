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
	<body>
		<!--
		1.
		<c:if test="${login == null}">
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/>
		</c:if><%-- <%=pageContext.getServletContext().getContextPath()%> 표현식 사용해서 context 얻어내기 --%>
		
		<c:if test="${login != null}">
		<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
		</c:if>
	
		2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/> <%-- ${pageContext.servletContext.contextPath} EL 표현언어 사용해서 context 얻어내기--%>
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>

		4. <a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/>
		 -->
		<div class="jumbotron">
			<h1>Spring Final Programming</h1>
			<p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQeury,
				Ajax, Jsp, Spring</p>
			<p>
				<a class="btn btn-lg btn-success" href="#" role="button">많이 배웠네...</a>
			</p>
		</div> 
		  
	</body>
</html>
