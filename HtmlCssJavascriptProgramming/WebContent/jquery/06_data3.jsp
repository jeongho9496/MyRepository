<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1104 --%>

<%
	String kind = request.getParameter("kind");
	String keyword = request.getParameter("keyword");
%>
<table style="width:600px">
			<tr>
				<td>
					<%for(int i=1; i<=3; i++) {%>
						<div style="width:120px; height:130px; margin:5px; background-image:url('../common/image/photo<%=i%>.jpg'); background-size: 120px 130px;display:inline-block;">
							
						<div>
							<table style="width:100%; height:30px; background-color:rgba(0, 0, 0, 0.3);">
								<tr>
									<td style="text-align:left; color:white;"><%=kind%></td>
									<td style="text-align:right; color:aqua;"><%=keyword+i%></td>
								</tr>
							</table>
						</div>
					</div>
					<%}%>
				</td>
			</tr>
</table>
