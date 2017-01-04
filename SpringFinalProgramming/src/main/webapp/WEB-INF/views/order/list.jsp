<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


{
	"list": [
		<c:forEach var="order" items="${list}" varStatus="status">
		{
			"ogid":"${order.ogid}",
			"user_id":"${order.user_id}",
			"ogtime":"${order.ogtime}",
			"ogtotalprice":"${order.ogtotalprice}",
			"oghowpay":"${order.oghowpay}"
		}
		<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	],
	
	"pageNo":${pageNo},
	"rowsPerPage": ${rowsPerPage},
	"pagesPerGroup": ${pagesPerGroup},
	"totalBoardNo": ${totalBoardNo},
	"totalPageNo": ${totalPageNo},
	"totalGroupNo": ${totalGroupNo},
	"groupNo": ${groupNo},
	"startPageNo": ${startPageNo},
	"endPageNo": ${endPageNo}
}