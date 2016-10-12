<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1012 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	게시물 쓰기
	<hr/>
	<form method="post" action="/myapp/exam11/boardWrite"><%-- form 태그의 요청 방식은 post로한다. --%>
		글쓴이:<input type="text" name="bwriter" value="늦가을"/><br/>
		제목:<input type="text" name="btitle" value="단풍은 왔는가?"/><br/>
		내용:<textarea rows="5" cols="20" name="bcontent">단풍은 오기도 전에 겨울이 왔어요.</textarea><br/><%-- textarea : 여러줄 입력 rows: 행제한 cols : 한행의 글자수제한(A크기가 기본 제한) --%>
		<input type="submit" value="글쓰기"/> 
	</form>
	</body>
</html>