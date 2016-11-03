<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1103 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function checkLoginForm() {
				var mid = document.querySelector("#mid").value;
				var mpassword = document.querySelector("#mpassword").value;
				
				if (mid.length<4 || mid.length>10) {
					alert("서버 실패(아이디 입력)");
					return false;
				} else if (mpassword.length<4 || mpassword.length>10) {
					alert("서버 실패(패스워드 입력)");
					return false;
				} else {
					return true;
				}
			}
		</script>
	</head>
	<body>
		유효성 검사(입력 값 검사)
		<hr/>
		<form id="loginForm" onsubmit="return checkLoginForm()" action="a.jsp"><%-- return checkLoginForm() => checkLoginForm()의 false값 리턴 (서버 전송 막음.) --%>
			아이디: <input id="mid" type="text" name="mid"/><br/>
			비밀번호: <input id="mpassword" type="password" name="mpassword"/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</body>
</html>