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
		배열
		<hr/>
		<script type="text/javascript">
			var cars = ["Saab", "Volvo", "BMW", 12, 44, 22, 55];/* {} -> 객체 선언 */
			console.log(cars[0]);
			console.log(cars[1]);
			console.log(cars[2]);
			for (var i = 0; i < cars.length; i++) {
				console.log(cars[i]);
			}
			
			var cars2 = new Array("Saab", "Volvo", "BMW");
			cars2.sort();
			for (var i = 0; i < cars2.length; i++) {
				console.log(cars2[i]);
			}
			
			var fruits = ["Banana", "Orange", "Apple", "Mango"];
			fruits.push("Lemon");
			fruits.pop();
			fruits[5] = "포도";
			
			for (var i = 0; i < fruits.length; i++) {
				console.log(fruits[i]);
			}
		</script>
		
	</body>
</html>