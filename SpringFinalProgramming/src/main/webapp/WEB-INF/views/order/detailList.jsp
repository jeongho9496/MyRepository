<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



{
	"detailList": [
		<c:forEach var="detailList" items="${detailList}" varStatus="status">
		{
			"mname":"${detailList.mname}",
			"hot_ice":"${detailList.hot_ice}",
			"sameItemCount":"${detailList.sameItemCount}",
			"xname":"${detailList.xname}",
			"sameItemPrice":"${detailList.sameItemPrice}",
			"oghowpay":"${detailList.oghowpay}"
			
		}
		<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	],
	
	"resultprice":${resultprice}
	
}