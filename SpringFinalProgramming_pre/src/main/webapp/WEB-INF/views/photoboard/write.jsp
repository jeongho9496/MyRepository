<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1028 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		글쓰기
		<hr/>
		<form method="post" enctype="multipart/form-data"><%-- input type="file"일시 반드시 enctype="multipart/form-data 작성 --%>
			<table>
				<tr>
					<td style="background-color:orange; width:70px">제목</td>
					<td><input type="text" name="btitle" style="width: 600px;" value="${photoBoard.btitle}"/></td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">내용</td>
					<td><textarea name="bcontent" style="width:600px; height:200px;" rows="10" cols="50">${photoBoard.bcontent}</textarea></td>
				</tr>
				
				<tr>				
					<td style="background-color:orange; width:70px">사진</td>
					<td><input type="file" name="photo"/></td>
				</tr>
			</table>
			<input type="submit" value="글쓰기"/>
		</form>
	</body>
</html>