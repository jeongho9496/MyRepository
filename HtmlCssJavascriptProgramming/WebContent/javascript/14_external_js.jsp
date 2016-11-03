<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1103 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="14_library.js"></script><!-- 외부 라이브러리 사용 -->
		<script type="text/javascript">
			/* function sum(from, to) {
				var sum = 0;
				for (var i = from; i <= to; i++) {
					sum += i;
				}
				return sum;
			} */
			
			function calculator(){/* $ => 변수 면서 객체 이다. */
				var x = parseInt(document.querySelector("#x").value);
				var y = parseInt(document.querySelector("#y").value);
				var result = $.sum(x, y);
				document.querySelector("#result").value = result;
				
				
				
			}
		</script>

	</head>
	<body>
		외부 스크립트 파일 로딩
		<hr/>
		<input type="number" id="x"/> 에서
		<input type="number" id="y"/> 까지의 합
		<button onclick="calculator()">계산</button>
		<input type="text" id="result" readonly/> 
		
	</body>
</html>