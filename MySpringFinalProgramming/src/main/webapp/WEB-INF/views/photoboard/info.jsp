<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		글내용
		<hr/>
			<table style="width:570px">
				<tr>
					<td style="background-color:orange; width:70px">번호</td>
					<td>${photoBoard.bno}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">제목</td>
					<td>${photoBoard.btitle}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">내용</td>
					<td><pre>${photoBoard.bcontent}</pre></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">글쓴이</td>
					<td>${photoBoard.bwriter}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">조회수</td>
					<td>${photoBoard.bhitcount}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">날짜</td>
					<td>${photoBoard.bdate}</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:200px">사진</td>
					<td><img src="showPhoto?savedfile=${photoBoard.savedfile}" width="500px"/></td>
				</tr>
			</table>
			<div>
				<c:if test="${login == photoBoard.bwriter}">
					<a href="modify?bno=${photoBoard.bno}">[수정]</a>
					<a href="remove?bno=${photoBoard.bno}">[삭제]</a>
				</c:if>
					<a href="list">[목록]</a>
			</div>
	</body>
</html>