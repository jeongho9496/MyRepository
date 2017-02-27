<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
   
</head>

<body>
  Employee
  <hr/>

	<table border="1">
		<c:if test="${ not empty employeeList }">
			<c:forEach var="employee" items="${ employeeList }">
				<tr>
					<td><a href="${pageContext.request.contextPath}/employee/info?no=${ employee.EMP_NO }">${ employee.EMP_NO }</a></td>
					<td>${ employee.EMP_NAME }</td>
					<td>${ employee.EMP_PHONE }</td>
					<td>${ employee.EMP_POSITION }</td>
					<td>${ employee.EMP_EMAIL }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<form action="${pageContext.request.contextPath}/searchEmployee" method="post">
		<div>
			<select name="searchType">
				<option value="0" <c:if test="${ not empty searchType and searchType == '0'}">selected="selected"</c:if>>전체</option>
				<option value="1" <c:if test="${ not empty searchType and searchType == '1'}">selected="selected"</c:if>>직원번호</option>
				<option value="2" <c:if test="${ not empty searchType and searchType == '2'}">selected="selected"</c:if>>이름</option>
				<option value="3" <c:if test="${ not empty searchType and searchType == '3'}">selected="selected"</c:if>>전화번호</option>
				<option value="4" <c:if test="${ not empty searchType and searchType == '4'}">selected="selected"</c:if>>직급</option>
				<option value="5" <c:if test="${ not empty searchType and searchType == '5'}">selected="selected"</c:if>>이메일 주소</option>
			</select>
			<input type="text" name="searchParam" value="<c:if test="${ not empty searchParam }">${ searchParam }</c:if>">
			<input type="submit" value="검색">
		</div>
	</form>
	
	<a href="${pageContext.request.contextPath}/csvDown">csv 다운</a>
	<a href="${pageContext.request.contextPath}/xlsDown">xls 다운</a>
	<a href="${pageContext.request.contextPath}/startScheduler">스케줄러 시작</a>
	<a href="${pageContext.request.contextPath}/employee/write">등록</a>

</body>
</html>
