<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1025 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[회원 가입 폼]<br/>
		<form method="post" action="/myapp/exam13/join"><%-- method="post" 데이터를 본문에 담아 전송  --%>
			아 이 디:<input type="text" name="mid" value="fall"/><br/><%-- input type = "~" 데이터 타입 설정 name="~".jsp 데이터 파라미터 이름 , value="~" 기본 값 설정--%>
			
			이    름:<input type="text" name="mname" value="한가을"/><br/>
	
			비밀번호:<input type="password" name="mpassword" value="12345"/><br/>
			
			나    이:<input type="number" name="mage" value="28"/><br/> 
					
			생년월일:<input type="date"name="mbirth" value="2016-09-29"/><br/><br/>
				
					<input type="submit" value="회원가입"/> 
					
		</form>
	</body>
</html>