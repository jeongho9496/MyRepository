<%@ page contentType="application/json;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- {
	{
		"sname":"${store.sname}",
		"slocal":"${store.slocal}",
		"saddr":"${store.saddr}",
		"stel":"${store.stel}",
		"sopen":"${store.sopen}",
		"sclosed":"${store.sclosed}",
		"sbeacon":"${store.sbeacon}"
	}
	, }--%>
	[
	<c:forEach var="event" items="${list}" varStatus="status">
		{
			"eid":"${event.eid}",
			"estartperiod":"${event.estartperiod}",
			"elastperiod":"${event.elastperiod}",
			"etitle":"${event.etitle}",
			"econtents":"${event.econtents}",
			"esavedfile":"${event.esavedfile}",
			"sid":"${event.sid}",
			"mid":"${event.mid}"
		}
		<c:if test="${!status.last}">,</c:if>
	</c:forEach>
	]
