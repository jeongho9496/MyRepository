<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1031 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#btn1").on("click", function() {
					$("#div1").html("수정내용");
				});				
			});
		</script>
	</head>
	<body>
		jQuery 라이브러리 로드
		<hr/>
		<button id="btn1">버튼 1</button>
		<div id="div1">최초내용</div>
	</body>
</html>