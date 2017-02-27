<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	response.setHeader("Content-Disposition", "attachment; filename=employeeList.xls");
	response.setHeader("Content-Description", "JSP Generated Data");
	response.setContentType("application/vnd.ms-excel");
%>
<style type="text/css">
td {
	mso-number-format: 000000;
}
</style>

<h3>회원 목록</h3>

<table border="1">
	<thead>
		<tr>
			<th>직원번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>직급</th>
			<th>이메일 주소</th>
		</tr>
	</thead>

	<tbody>
		<c:if test="${ not empty employeeList }">
			<c:forEach var="employee" items="${ employeeList }">
				<tr>
					<td style='mso-number-format:"\@";'>${ employee.EMP_NO }</td>
					<td>${ employee.EMP_NAME }</td>
					<td style='mso-number-format:"\@";'>${ employee.EMP_PHONE }</td>
					<td>${ employee.EMP_POSITION }</td>
					<td>${ employee.EMP_EMAIL }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>