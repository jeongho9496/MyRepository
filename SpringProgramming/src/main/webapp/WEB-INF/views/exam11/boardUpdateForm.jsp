<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1013 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	게시물 수정
	<hr/>
	<form method="post" action="/myapp/exam11/boardUpdate"><%-- form 태그의 요청 방식은 post로한다. --%>
		글쓴이:<input type="text" name="bwriter" value="${board.bwriter}"/><br/>
		제목:<input type="text" name="btitle" value="${board.btitle}"/><br/>
		내용:<textarea rows="5" cols="20" name="bcontent">${board.bcontent}</textarea><br/><%-- textarea : 여러줄 입력 rows: 행제한 cols : 한행의 글자수제한(A크기가 기본 제한) --%>
		<input type="submit" value="수정하기"/> 
	</form>
	</body>
</html>