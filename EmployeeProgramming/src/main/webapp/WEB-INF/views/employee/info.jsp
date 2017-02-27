<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		
	</head>
	<body>
		사원 정보
		<hr/>
		<form method="post">
			직원번호: ${emp.no}<br/>
			이름: ${emp.name}<br/>
			휴대전화: ${emp.phone}<br/>
			직급: ${emp.position}<br/>
			이메일: ${emp.email}<br/>
			<a href="modify?no=${emp.no}">[수정]</a>
			<a href="remove?no=${emp.no}">[삭제]</a>
			<a href="${pageContext.request.contextPath}/index">[목록]</a>
		</form>
	</body>
</html>