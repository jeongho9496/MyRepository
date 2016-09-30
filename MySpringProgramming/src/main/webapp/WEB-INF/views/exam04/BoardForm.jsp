<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[게시판 폼]<br/>
		<form method="post" action="/kjhapp/exam04/board1">
			제목:<input type="text" height="50" width="50" name="mtitle" value="제목 없음"/><br/>
			내용:<input type="text" name="mcontent" value="내용 없음"/><br/>
			카테고리:<select name="mcategory">
						<option selected>게시글</option>
						<option>자유글</option>
						<option>비방글</option>
					</select><br/>
			파일:<input type="text" name="mfile" value="첨부 없음"/><br/>
			<button>등록</button>
		</form>
	</body>
</html>