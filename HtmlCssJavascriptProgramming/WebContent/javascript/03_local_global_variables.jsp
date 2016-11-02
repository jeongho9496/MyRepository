<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1102 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			var v1 = "A";
			
			function fun1() {
				var v2 = "b";
				v3 = "C";/* 해당 함수 안에서 변수로 사용 가능? */
				console.log("v1: " + v1);
				console.log("v2: " + v2);
				console.log("v3: " + v3);
			}
			function fun2() {
				console.log("v1: " + v1);
				console.log("v3: " + v3);
				console.log("v2: " + v2);
			}
			function fun3() {
				if(true) {
					var v4 = "D";
					/* 자바는 block단위의 지역변수가 존재 하지만 javascript는 block단위의 지역변수가 존재 하지 않고,
					함수단위의 지역변수가 존재한다. */
				}
				
				console.log("v4: " + v4);
			}
			
		</script>
	</head>
	<body>
		지역 변수와 전역 변수
		<hr/>
		<script type="text/javascript">
			fun1();
			console.log("-----------------");
			/* fun2(); */
			fun3();
		</script><%-- 선언문은 head에 실행문은 body에 작성한다.(* 반드시 선언문은 실행문 위에 있어야 한다.) --%>
		
	</body>
</html>