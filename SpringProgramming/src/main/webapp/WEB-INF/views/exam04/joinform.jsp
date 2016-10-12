<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 0930 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[회원 가입 폼]<br/>
		<form method="post" action="/myapp/exam04/join"><%-- method="post" 데이터를 본문에 담아 전송  --%>
			아 이 디:<input type="text" name="mid" value="fall"/><br/><%-- input type = "~" 데이터 타입 설정 name="~".jsp 데이터 파라미터 이름 , value="~" 기본 값 설정--%>
			
			이    름:<input type="text" name="mname" value="한가을"/><br/>
	
			비밀번호:<input type="password" name="mpassword" value="12345"/><br/>
			
			이 메 일:<input type="email" name="memail" value="fall@naver.com"/><br/>
			
			전화번호:<input type="tel" name="mtel" value="010-123-1234"/><br/>
			
			직    업:<input type="radio" name="mjob" value="대학생">대학생
					<input type="radio" name="mjob" value="회사원" checked>회사원
					<input type="radio" name="mjob" value="공무원">공무원<br/>
					
			개발분야:<input type="checkbox" name="mskill" value="web">웹개발<%--중복 선택 --%>
					<input type="checkbox" name="mskill" value="system" checked>시스템개발
					<input type="checkbox" name="mskill" value="bigdate">빅데이터개발
					<input type="checkbox" name="mskill" value="iot" checked>IoT개발<br/>
					
			주    소:<select name="maddress1">
						<option>서울특별시</option>
						<option selected>경기도</option>
						<option>부산광역시</option>
						<option>대구광역시</option>					
						<option>제주광역시</option>					
					</select> - 
					<select name="maddress2">
						<option>인천시</option>
						<option>수원시</option>
						<option selected>용인시</option>
						<option>부천시</option>					
						<option>의왕시</option>					
					</select><br/>
					
			생년월일:<input type="date"name="mbirth" value="2016-09-29"/>
					
					<br/>
					
					<%--  
					<input type="submit"value="가입"/> <!-- submit : 작성된 데이터를 서버로 전송 가장 일반적 -->
					<button>가입</button><!-- submit와 같은 기능을 제공(서버 전송) -->  
					--%>
					<input type="image"src="/myapp/resources/image/join.png"width="100" height="50"/><%-- 경로에 있는 이미지 클릭시 submit와 같다 --%> 
					
		</form>
	</body>
</html>