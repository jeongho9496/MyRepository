<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 목록
		<hr/>
		<table style = "border-collapse: collapse;border: 1px solid black; width: 600px"><%-- tr => row 설정 th,td => columns 설정 --%>
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">제목</td>
				<td style="border: 1px solid black;">내용</td>
				<td style="border: 1px solid black;">글쓴이</td>
			</tr>
			
			
			<c:forEach var="board" items="${boardlist}"><%-- 컨트롤러가 넘겨준 list를 items로 찾아줌 items에 들어온 객체를 뽑아 var="b" 에 넣는다. null 처리 필요없음 --%>
				<tr>
					<td style="border: 1px solid black;">${board.btitle}</td>
					<td style="border: 1px solid black;">${board.bcontent}</td>
					<td style="border: 1px solid black;">${board.bwriter}</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>