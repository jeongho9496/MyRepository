<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1031 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%-- External Style Sheet --%>
		<link rel="stylesheet" type="text/css" href="05_style.css">
		<!-- <link rel="외부 파일과 관계" type="타입" href="외부 파일 연결"> -->
		
		<%-- Internal Style Sheet --%>
		<style type="text/css">
			.menu {
				background-color: #ffffff;
			}
			
			.menu li {
				color: orange;
			} <%--다른 jsp 파일에서 재사용 불가 --%>
		</style>
	</head>
	<body>
		CSS Location
		<hr/>
		
		<header>제목</header>
		<p>내용</p>
		<a href="http://tomcat.apache.org">톰캣</a>
		
		<div class="menu">
			<ul>
				<li>menu1</li>
				<li>menu2</li>
				<li>menu3</li>
			</ul>
		</div>
		
		<div style="background-color: yellow; text-align: center;"><%-- 재사용 불가 --%>
			본문 내용 입니다.
		</div>
	</body>
</html>