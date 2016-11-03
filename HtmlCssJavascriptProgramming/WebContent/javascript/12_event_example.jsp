<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1103 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function checkMid(){
				var mid = document.querySelector("#mid");
				mid.value = mid.value.toLowerCase();
			}
			
			function checkMid2(){
				var mid2 = document.querySelector("#mid2");
				mid2.value = mid2.value.toLowerCase();
			}
			
			function changeImg(img) {
				console.log(event.type);
			
				if(event.type == "mouseover") {
					img.src = "../common/image/photo2.jpg";
				} else if(event.type == "mouseout"){
					img.src="../common/image/photo1.jpg";
				}
			}
			
			function changeImg2() {
				console.log(event.type);
				var img = event.target;/* event를 통해 매개변수를 받음. */
				if(event.type == "mouseover") {
					img.src="../common/image/photo2.jpg";
				} else if(event.type == "mouseout"){
					img.src="../common/image/photo1.jpg";
				}
			}
			
			
			window.onload = function(){
				document.querySelector("#mid2").addEventListener("keypress",checkMid2);
				document.querySelector("#mid2").addEventListener("change",checkMid2);	
			}
			
			window.addEventListener("load", function(){
				var img1 = document.querySelector("#img1");
				
				img1.addEventListener("mouseover",changeImg2);	
				img1.addEventListener("mouseout",changeImg2);	
			});
			
			function changeColor(div) {
				if(event.type == "mouseover") {
					div.style.backgroundColor="blue";/* '-'는 minus개념이므로 background-color를 필드명으로 사용할 수 없다. */
				} else if(event.type == "mouseout"){
					div.style.backgroundColor="red";
				}
			}
				
		</script>
	</head>
	<body>
		다양한 Event 처리
		<hr/>
		<h3>[Exam1]</h3>
		<form>
			<input id="mid" type="text" name="mid" onchange="checkMid()" onkeypress="checkMid()"/>
			<input id = "mid2" type="text" name="mid"/>
		</form>
		
		<h3>[Exam2]</h3>
		<br/>
		<img id="img1" src="../common/image/photo1.jpg" width="200px"/>
		<br/>
		<img id="img2" onmouseover="changeImg(this)" onmouseout="changeImg(this)" src="../common/image/photo1.jpg" width="200px"/>
		<%-- this : 현재의 이벤트가 발생한 이벤트값이 들어감 --%>
		
		<h3>[Exam3]</h3>
		<div id="div1" style="width:200px;height:200px;background-color:red;" onmouseover="changeColor(this)" onmouseout="changeColor(this)"></div>
		
	</body>
</html>