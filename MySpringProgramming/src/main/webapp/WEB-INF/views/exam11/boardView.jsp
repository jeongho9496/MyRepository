<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 상세 보기
		<hr/>
		제목: 	${board.btitle}		<br/><%-- board라는 이름의 객체의 btitle메소드 리턴값을 받아온다. --%>
		내용: 	${board.bcontent}	<br/>
		글쓴이: 	${board.bwriter}	<br/>
	</body>
</html>