<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
<c:forEach var="light" items="${list}" varStatus="status"><%-- list로 된 객체를 찾음 --%> 
<%-- varStatus="status" 루프정보를 담는 객체를 저장할 변수명을 값으로 갖는다. --%>
	{
		"image":"${light.image}",
		"imageLarge":"${light.imageLarge}",
		"title":"${light.title}",
		"content":"${light.content}"
	}
	<c:if test="${!status.last}">,</c:if><%-- 마지막 행 전까지 ','를 넣어라 --%>
</c:forEach>
]