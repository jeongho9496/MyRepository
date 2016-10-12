<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mycompany.myapp.exam07.*" %><%-- class의 위치 찾기 --%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- taglib: EL과 같이 사용할수 있는 표준 태그를 불러온다. --%>
<%-- <%@ taglib prefix="접두사" uri="네임스페이스" %> --%>
<%-- taglib 사용방법 --%>


<%-- 1004 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		데이터 찾기
		<hr/>
		[HttpServletRequest를 이용해서 찾기]<br/>
		데이터1: <%=(String)request.getAttribute("data1")%><br/><%-- String 값을 <%= %>란에 넣어라 1개 값을 반드시 얻어야 한다. --%>
		데이터2: <%=(String)request.getAttribute("data2")%><br/><br/><%-- HttpServletRequest에 저장된 데이터 가져온다. --%>

		[HttpSession를 이용해서 찾기]<br/>
		데이터1: <%=(String)session.getAttribute("data1")%><br/><%-- HttpSession에 저장된 데이터 가져온다. --%>
		데이터2: <%=(String)session.getAttribute("data2")%><br/><br/>
		
		<%-- request와 session은 변수 없이 사용 가능 --%>

		[EL을 이용해서 찾기]<br/><%-- 기본적으로 HttpServletRequest에서부터 데이터를 찾는다. --%>
		데이터1: ${data1}<br/>
		데이터2: ${data2}<br/><br/>
		
		<%-- 1006 --%>
		[객체의 속성(필드)값 얻기]<br/><%-- 컨트롤러에서 jsp로 데이터 객체 전달 --%>
		<%-- 
		번호:${board.bno}<br/><%-- EL내부에서 '.'은 getter매소드를 호출한다. ex)${board.bno} == board.getBno()
		제목:${board.title}<br/>
		내용:${board.content}<br/>
		조회수:${board.hitcount}<br/><br/> --%>
		
		<%-- '<%  %>' 자바코드만 실행하는 목적(값이 목적이 아님) --%>
		<%-- '<%@ %>' 지시자를 사용하겠다. ex)'<%@ page contentType="text/html;charset=UTF-8" %>' --%>
		<%-- '<%= %>' 하나의 값을 출력하겠다. --%>
		
		<%-- JSP 버전 --%>
		<%Board board = (Board) request.getAttribute("board"); %>
		<%if(board !=null) { %>
			번호:<%=board.getBno()%><br/><%-- EL내부에서 '.'은 getter매소드를 호출한다. ex)${board.bno} == board.getBno() --%>
			제목:<%=board.getTitle()%><br/>
			내용:<%=board.getContent()%><br/>
			조회수:<%=board.getHitcount()%><br/>
		<%}%>
		<br/>
		[컬렉션 이용하기]<br/> <%-- 컨트롤러에서 jsp로 데이터 객체 전달 --%>
		<table style = "border-collapse: collapse;border: 1px solid black; width: 600px"><%-- tr => row 설정 th,td => columns 설정 --%>
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black;">번호</td>
				<td style="border: 1px solid black;">제목</td>
				<td style="border: 1px solid black;">내용</td>
				<td style="border: 1px solid black;">조회수</td>
			</tr>
			
			<%-- <%List<Board> list = (List<Board>)request.getAttribute("boardlist");%>
			<%if(list != null) {%>
				<%for(Board b : list){%>
				<tr>
					<td style="border: 1px solid black;"><%=b.getBno()%></td>
					<td style="border: 1px solid black;"><%=b.getTitle()%></td>
					<td style="border: 1px solid black;"><%=b.getContent()%></td>
					<td style="border: 1px solid black;"><%=b.getHitcount()%></td>
				</tr>
				<%}%>
			<%}%> --%>
			
			<c:forEach var="b" items="${boardlist}"><%-- 컨트롤러가 넘겨준 list를 items로 찾아줌 items에 들어온 객체를 뽑아 var="b" 에 넣는다. null 처리 필요없음 --%>
				<tr>
					<td style="border: 1px solid black;">${b.bno}</td>
					<td style="border: 1px solid black;">${b.title}</td>
					<td style="border: 1px solid black;">${b.content}</td>
					<td style="border: 1px solid black;">${b.hitcount}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>