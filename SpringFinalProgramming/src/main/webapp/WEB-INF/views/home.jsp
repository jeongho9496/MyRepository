<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<!-- 1025 -->
<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		SpringFinalProgramming
		<hr/>
		1. <a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/> <%-- <%=pageContext.getServletContext().getContextPath()%> 표현식 사용해서 context 얻어내기 --%>
		2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/> <%-- ${pageContext.servletContext.contextPath} EL 표현언어 사용해서 context 얻어내기--%>
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
	</body>
</html>
