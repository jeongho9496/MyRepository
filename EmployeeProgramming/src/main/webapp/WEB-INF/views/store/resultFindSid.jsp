<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 보나: 20161122 store 아이디/비번찾기 전체수정 --%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body> 
		아이디 찾기
		<hr/>
			아이디: ${findSid} 											<br/>
			<a href="login"><button>로그인</button></a>
	</body>
</html>