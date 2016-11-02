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
		String 객체의 메소드
		<hr/>
		<script type="text/javascript">
			var v1 = "abc";
			console.log(v1.length);
			/* Both the indexOf(), and the lastIndexOf() methods return -1 if the text is not found. */
			
			var v2 = "JavaScript is easy";
			/* console.log(v2.indexof("easy")); */
			console.log(v2.indexOf("easy"));
			console.log(v2.indexOf("spring"));
			console.log(v2.search("easy"));
		
			var v3 = "123456-9876543"
			console.log(v3.substring(7,14));/* 14번째 자리부터 7칸 내려가기 */
			console.log(v3.substr(7,7));/* 7번째 자리부터 7개 */
			console.log(v3.charAt(7));/* charAt(?) ?번째의 문자를 뽑아냄 */
			
			str = "Please visit Microsoft!";
			var n = str.replace(/Microsoft/g,"W3Schools");
			console.log(n);
			
			var v6 = "10:20:30";
			var v7 = v6.split(":");
			console.log(v7[0]);
			console.log(v7[1]);
			console.log(v7[2]);
		</script>
		
	</body>
</html>