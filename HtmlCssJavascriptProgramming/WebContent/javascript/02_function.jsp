<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1102 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			/* function(함수 => 자바에 비유 하면 메소드 역할) */
			/* function() {} vs method() {}
				method(){} 는 Object의 번지를 이용해서 호출.
				function(){} 은 함수이름으로 호출 가능.
				function 선언시 리턴 타입과 매개변수 타입을 지정 하지 않는다.
			*/
			function sum(from, to) {
					var sum=0;
					for(var i=from; i<=to; i++){
						sum += i;
					}
					return sum;
				}
			
		</script>
	</head>
	<body>
		함수 선언
		<hr/>
		<script type="text/javascript">
			console.log ("1부터 10까지의 합 : " + sum(1,10));
		</script><%-- 선언문은 head에 실행문은 body에 작성한다.(* 반드시 선언문은 실행문 위에 있어야 한다.) --%>
		
	</body>
</html>