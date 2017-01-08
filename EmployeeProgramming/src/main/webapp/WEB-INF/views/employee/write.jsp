<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		
	</head>
	<body>
		등록
		<hr/>
		<form method="post">
			직원번호: <input type="text" name="no" value="${emp.no}"><br/>
			이름: <input type="text" name="name" value="${emp.name}"><br/>
			휴대전화: <input type="text" name="phone" value="${emp.phone}"><br/>
			직급: <input type="text" name="position" value="${emp.position}"><br/>
			이메일: <input type="email" name="email" value="${emp.email}"><br/>
			<input type="submit" value="등록"/>
		</form>
	</body>
</html>