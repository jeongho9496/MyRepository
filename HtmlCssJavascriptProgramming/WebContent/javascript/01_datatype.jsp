<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1102 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
		/* var 은 값이 대입 될떼 타입이 자동으로 지정된다. */
			var v1 = 10;
			var v2 = "자바 스크립트";
			var v3 = true;
			var v4 = {name:"홍길동", age:27};/* 객체 필드:필드값 */
			var v5 = function() {};/* 함수(자바에 비유 하면 메소드 역할) */
			/* function() {} vs method() {}
				method(){} 는 Object의 번지를 이용해서 호출.
				function(){} 은 함수이름으로 호출 가능.
				function 선언시 리턴 타입과 매개변수 타입을 지정 하지 않는다.
			*/
			var v6 = null;
			var v7 = new Date();
			var v8 = [1,2,3];/* 배열 */
			
			console.log("v1: "+ typeof(v1));
			console.log("v2: "+ typeof(v2));
			console.log("v3: "+ typeof(v3));
			console.log("v4: "+ typeof(v4));
			console.log("v5: "+ typeof(v5));
			console.log("v6: "+ typeof(v6));
			console.log("v7: "+ typeof(v7));
			console.log("v8: "+ typeof(v8));
			
			v1= 3.14;
			var v1= v1%"JAVA";
			console.log("v1: "+ typeof(v1));
			
		</script>
	</head>
	<body>
		데이터 타입
		<hr/>
		
	</body>
</html>