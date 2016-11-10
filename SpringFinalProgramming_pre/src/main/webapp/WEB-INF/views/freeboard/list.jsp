<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 1027 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			a{
			text-decoration:none;
			color:black;
			}
			a:HOVER {
				color: green;
			}
		</style>
	</head>
	<body>
		자유 게시판
		<hr/>
		<c:if test="${login != null}">
			<a href="write">[글쓰기]</a>
		</c:if>
		
		<table style = "border-collapse: collapse;border: 1px solid black; width: 600px"><%-- tr => row 설정 th,td => columns 설정 --%>
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">번호</td>
				<td style="border: 1px solid black;">제목</td>
				<td style="border: 1px solid black;">글쓴이</td>
				<td style="border: 1px solid black;">조회수</td>
				<td style="border: 1px solid black;">날짜</td>
			</tr>
			
			
			<c:forEach var="freeBoard" items="${list}"><%-- 컨트롤러가 넘겨준 list를 items로 찾아줌 items에 들어온 객체를 뽑아 var="b" 에 넣는다. null 처리 필요없음 --%>
				<tr>
					<td style="border: 1px solid black;">${freeBoard.bno}</td>
					<td style="border: 1px solid black;">
						<a href="info?bno=${freeBoard.bno}">${freeBoard.btitle}
						</a>
					</td>
					<td style="border: 1px solid black;">${freeBoard.bwriter}</td>
					<td style="border: 1px solid black;">${freeBoard.bhitcount}</td>
					<td style="border: 1px solid black;">${freeBoard.bdate}</td>
				</tr>
			</c:forEach>
		</table>
		<div style = "width: 600px">
		<a href="list?pageNo=1">[처음]</a>
		<c:if test="${groupNo>1}">
			<a href="list?pageNo=${startPageNo-1}">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
		 	<a href="list?pageNo=${i}" <c:if test="${pageNo==i}">style="color:red"</c:if> > ${i} </a>
		</c:forEach>
		 
		<c:if test="${groupNo<totalGroupNo}">
		 	<a href="list?pageNo=${endPageNo+1}">[다음]</a>
		</c:if>
		 <a href="list?pageNo=${totalPageNo}">[맨끝]</a><%-- 제일 끝의 그룹 번호 --%>
		</div>
	</body>
</html>