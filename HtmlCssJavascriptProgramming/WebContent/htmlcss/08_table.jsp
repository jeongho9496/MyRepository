<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1101 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			table {
			    border-collapse: collapse;
			    width: 100%;
			}
			
			th, td {
			    text-align: left;
			    padding: 8px;
			}
			
			tr:nth-child(even){background-color: #f2f2f2}
			
			th {
			    background-color: #4CAF50;
			    color: white;
			}
		</style>
	</head>
	<body>
		table 관련 CSS속성
		<hr/>
		<table id="table1">
		  <tr>
		    <th>Firstname</th>
		    <th>Lastname</th>
		    <th>Savings</th>
		  </tr>
		  <tr>
		    <td>Peter</td>
		    <td>Griffin</td>
		    <td>$100</td>
		  </tr>
		  <tr>
		    <td>Lois</td>
		    <td>Griffin</td>
		    <td>$150</td>
		  </tr>
		  <tr>
		    <td>Joe</td>
		    <td>Swanson</td>
		    <td>$300</td>
		  </tr>
		  <tr>
		    <td>Cleveland</td>
		    <td>Brown</td>
		    <td>$250</td>
		</tr>
		</table>
	</body>
</html>