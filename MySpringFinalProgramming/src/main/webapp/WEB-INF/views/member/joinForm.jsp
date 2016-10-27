<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		회원가입
		<hr/>
		<form method="post">
			아이디: <input type="text" name="mid" value="${member.mid}">
			<a href="checkMid">중복 체크</a><br/>
			이름: <input type="text" name="mname" value="${member.mname}"><br/>
			패스워드: <input type="password" name="mpassword"><br/>
			휴대전화: <input type="tel" name="mtel" value="${member.mtel}"><br/>
			이메일: <input type="email" name="memail" value="${member.memail}"><br/>
			주소: <input type="text" name="maddress" value="${member.maddress}"><br/>
			<input type="submit" value="가입"/>
		</form>
	</body>
</html>