<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1102 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			
			
		</script>
	</head>
	<body>
		String -> 숫자 형변환
		<hr/>
		<script type="text/javascript">
			var v1 = "10";
			var v2 = Number(v1);
			var v3 = parseInt(v1);
			console.log(v2);
			console.log(v3);
			console.log(v2+v3);
			
			var v4 = "3.14";
			var v5 = parseInt(v4);
			var v6 = parseFloat(v4);
			var v7 = Number(v4);
			console.log(v5);
			console.log(v6);
			console.log(v7);
		</script>
		
	</body>
</html>