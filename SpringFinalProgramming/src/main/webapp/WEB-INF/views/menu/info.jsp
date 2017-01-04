<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 보나 20161117--%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
   </head>
   <body>
   		<h2>메뉴 상세보기</h2>
   		<hr/>
   		<a href="${pageContext.servletContext.contextPath}/menu/list">[메뉴 목록]</a>
   		<a href="${pageContext.servletContext.contextPath}/index">[메인ㄱㄱ]</a> <br/>
   		
   		<table style="width:570px">
   			<tr>
   				<td style="background-color:gold; width:70px">분류</td>
   				<td>${menu.mgroup}</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">메뉴명</td>
   				<td>${menu.mname}</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">아이스/핫</td>
   				<td>${menu.hot_ice}</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">가격</td>
   				<td>${menu.mprice}</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">설명</td>
   				<td>${menu.mcontents}</td>
   			</tr>
   			<tr>
   				<td style="background-color:gold; width:70px">사진</td>
   				<td><img src="showPhoto?msavedfile=${menu.msavedfile}" width="500px"/></td>
   			</tr>
   		</table>
   		
   			<div>
   			<c:if test="${login==menu.sid}">
				<a href="modify?mid=${menu.mid}">[수정]</a>
				<a href="remove?mid=${menu.mid}">[삭제]</a>
			</c:if>
			 
			<a href="list">[취소]</a>
   			</div>
   		
   </body>
</html>