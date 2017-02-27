<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	response.setHeader("Content-Type", "text/csv;charset=MS949");
	response.setHeader("Content-Disposition","attachment; filename=employeeList.csv");
	response.setHeader("Content-Description", "JSP Generated Data");
	response.setHeader("Cache-Control", "max-age=0");
%>
<c:if test="${ not empty employeeList }">
	직원번호, 이름, 전화번호, 직급, 이메일 주소
	<c:forEach var="employee" items="${ employeeList }">
		${ employee.EMP_NO }, ${ employee.EMP_NAME }, ${ employee.EMP_PHONE }, ${ employee.EMP_POSITION }, ${ employee.EMP_EMAIL }
	</c:forEach>
</c:if>
