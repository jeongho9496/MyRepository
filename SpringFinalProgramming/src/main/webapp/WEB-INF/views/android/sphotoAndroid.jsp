<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
	<c:forEach var="sphoto" items="${list}" varStatus="status">
		{
			"spic_id":"${sphoto.spic_id}",
			"spic_savedfile":"${sphoto.spic_savedfile}",
			"sid":"${sphoto.sid}"
		}
	<c:if test="${!status.last}">,</c:if>
	</c:forEach>
]