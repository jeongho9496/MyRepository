<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1012 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[로그인 폼]<br/>
		<form method="post" action="/myapp/exam11/memberLogin"><%-- method="post" 데이터를 본문에 담아 전송  --%>
			아 이 디:<input type="text" name="mid" value="fall"/><br/><%-- input type = "~" 데이터 타입 설정 name="~".jsp 데이터 파라미터 이름 , value="~" 기본 값 설정--%>
			비밀번호:<input type="password" name="mpassword" value="12345"/><br/>
			<br/>
			<input type="submit"value="로그인"/> <!-- submit : 작성된 데이터를 서버로 전송 가장 일반적 -->
		</form>
	</body>
</html>