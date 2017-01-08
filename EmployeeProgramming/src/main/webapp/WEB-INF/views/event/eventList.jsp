<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
	"eventList":[
		<c:forEach var="event" items="${eventList}" varStatus="status">
		{
			"eid":"${event.eid}",
			"etitle":"${event.etitle}",
			"econtents":"${event.econtents}",
			"estartperiod":"${event.estartperiod}",
			"elastperiod":"${event.elastperiod}"
		}
		<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	]	
}  

