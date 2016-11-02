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
		날짜 얻기
		<hr/>
		<script type="text/javascript">
			var now = new Date();
			console.log(now);
			console.log("년: " + now.getFullYear());
			console.log("월: " + (now.getMonth()+1));/* 문자가 앞에 오므로 문자열로 취함. */
			console.log("일: " + now.getDate());
			console.log("요일: " + now.getDay());/* 0: 일요일, 1: 월요일, 2: 화요일, 3: 수요일, 4: 목요일, 5: 금요일, 6: 토요일 */
		</script>
		
	</body>
</html>