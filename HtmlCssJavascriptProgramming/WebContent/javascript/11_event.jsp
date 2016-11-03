<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1103 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function changeImg1() {
				var img1 = document.querySelector("#img1");
				img1.src="../common/image/photo1.jpg";
			}
			
			
			function changeImg2() {
				var img2 = document.querySelector("#img2");
				img2.src="../common/image/photo2.jpg";
			}
			window.onload = function()	{ /* window라는 객체에서 onload가 실행 될때 함수 작용.(모든 자료들이 갖춰진 상태 사용자 에게 화면을 보여주기 직전에 발생) */
				console.log("window.onload");
				document.querySelector("#btn2").onclick = changeImg2;/* 함수 호출이 아닌 함수만 대입. */
				/* 앞으로 버튼의 onclick가 실행되면 해당 함수를 사용하겠다. 
				모든 코드들이 객체로 만들어 진 다음에 실행 하지 않으므로 null이 난다.
				window.onload 안에 들어 가면 해결
				window.onload : 모든 객체(DOM)를 만든 다음 로딩 한다.*/
			}
			
			function changeImg3(){
				var img3 = document.querySelector("#img3");
				img3.src="../common/image/photo3.jpg";
			}
			
			function init()	{
				console.log("init.onload");
				document.querySelector("#btn2").onclick = changeImg2;/* 함수를 대입 하므로 ()는 붙히지 않는다. */
				
				var btn3 = document.querySelector("#btn3");
				btn3.addEventListener("click", changeImg3);
			}
		</script>
	</head>
	<body onload="init()">
		Event 처리
		<hr/>
		
		<h3>[how1]</h3><%-- Block이므로 자동 개행 --%>
		
		<button onclick="changeImg1()"><%-- 함수 호출 형태 --%> 버튼 1 </button>
		<img id="img1" src=""  width="100px">
		
		<h3>[how2]</h3>
		<button id="btn2"> 버튼2 </button>
		<img id="img2" src="" width="100px">

		<h3>[how3]</h3>
		<button id="btn3"> 버튼3 </button>
		<img id="img3" src="" width="100px">
	</body>
</html>