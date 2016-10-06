<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mycompany.kjhapp.exam07.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		데이터 찾기
		<hr/>
		[HttpServletRequest를 이용해서 찾기]<br/>
		데이터1: <%=(String)request.getAttribute("data1")%><br/>
		데이터1: <%=(String)request.getAttribute("data2")%><br/><br/>
		
		[HttpSession을 이용해서 찾기]<br/>
		데이터1: <%=(String)session.getAttribute("data1")%><br/>
		데이터1: <%=(String)session.getAttribute("data2")%><br/><br/>
		
		[EL을 이용해서 찾기]<br/>
		데이터1: ${data1}<br/>
		데이터1: ${data2}<br/><br/>
		
		[객체의 속성(필드)값 얻기]<br/>
		번호:${board.bno}<br/>
		제목:${board.title}<br/>
		내용:${board.content}<br/>
		조회수:${board.hitcount}<br/>
		<br/>
		
		[컬랙션 이용하기]<br/>
		<table style="board-collapse: collapse;border: 1px solid black; width: 600px">
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black">번호</td>
				<td style="border: 1px solid black">제목</td>
				<td style="border: 1px solid black">내용</td>
				<td style="border: 1px solid black">조회수</td>
			</tr>
			
			<c:forEach var="b" items="${boardlist}">
				<tr>
					<td style="border: 1px solid black">${b.bno}</td>
					<td style="border: 1px solid black">${b.title}</td>
					<td style="border: 1px solid black">${b.content}</td>
					<td style="border: 1px solid black">${b.hitcount}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>