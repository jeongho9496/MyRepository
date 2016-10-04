<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1004 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		데이터 찾기
		<hr/>
		[HttpServletRequest를 이용해서 찾기]<br/>
		데이터1: <%=(String)request.getAttribute("data1")%><br/><%-- String 값을 <%= %>란에 넣어라 --%>
		데이터2: <%=(String)request.getAttribute("data2")%><br/><br/><%-- HttpServletRequest에 저장된 데이터 가져온다. --%>

		[HttpSession를 이용해서 찾기]<br/>
		데이터1: <%=(String)session.getAttribute("data1")%><br/><%-- HttpSession에 저장된 데이터 가져온다. --%>
		데이터2: <%=(String)session.getAttribute("data2")%><br/><br/>
		
		<%-- request와 session은 변수 없이 사용 가능 --%>

		[EL을 이용해서 찾기]<br/><%-- 기본적으로 HttpServletRequest에서부터 데이터를 찾는다. --%>
		데이터1: ${data1}<br/>
		데이터2: ${data2}<br/><br/>
		
	</body>
</html>