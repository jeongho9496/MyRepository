<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1027 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		글수정
		<hr/>
		<form method="post">
			<input type="hidden" name="bno" value="${freeBoard.bno}">
			<table>
				<tr>
				<td style="background-color:orange; width:70px">제목</td>
				<td><input type="text" name="btitle" style="width: 600px;" value="${freeBoard.btitle}"/></td>
				</tr>
				<tr>
				<td style="background-color:orange; width:70px">내용</td>
				<td><textarea name="bcontent" style="width:600px; height:200px;" rows="10" cols="50">${freeBoard.bcontent}</textarea></td>
				</tr>
			</table>
			<input type="submit" value="글수정"/>
		</form>
	</body>
</html>