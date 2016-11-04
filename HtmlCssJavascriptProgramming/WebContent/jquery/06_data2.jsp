<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1104 --%>
<% 
	boolean result = true;
	String mid = request.getParameter("mid");//mid 값을 받아옴.
	if(mid.equals("user1")) {
		result = false;
	}
%>

<%=result%>