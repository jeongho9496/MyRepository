<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1102 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function onClickButton1() {
				console.log("onClickButton1() 실행");
				/* var div1 = document.getElementById("div1"); */
				/* document.getElementById(id); 해당 아이디로 같은 아이디를 가지고 있는 객체를 찾는다. */
				var div1 = document.querySelector("#div1");/* # -> 아이디 이름 */
				div1.innerHTML = "수정 내용";/* 최초 내용을 수정 내용으로 바꿈 */
				console.log(div1);
			}
			
			function onClickButton2() {
				/* var imgArr = document.getElementsByTagName("img"); *//* 리턴값이 배열이므로 배열형식으로 담는다. */
				/* var imgArr = document.getElementsByClassName("photo"); */
				var imgArr = document.querySelectorAll(".photo");/* . -> 클래스 이름 */
				imgArr[0].src="../common/image/photo2.jpg";
			}
			
			function onClickButton3() {
				var mid;
				var mpassword;
				//how1
				/* var inputMid = document.querySelector("#form1 [name=mid]");
				mid = inputMid.value;
				console.log(mid);
				mpassword = document.querySelector("#form1 [name=mpassword]").value;
				console.log(mpassword);
				 */
				 
				//how2
				mid = document.form1.mid.value;/* 조건 : 태그에 name값이 있어야함. */
				mpassword = document.form1.mpassword.value;
			
				//1차 유효성 검사(client에서 검사)
				if (mid == "") {/* 값을 주지 않으면 ""(빈값)이 들어가므로 null처리 할 필요 없다. */
					alert("가장 안좋은 방법이지만... 아이디를 입력하세요")
				} else if (mpassword == "") {
					alert("가장 안좋은 방법이지만... 비밀번호를 입력하세요")
				}
				
				//서버전송
				/* document.queryselector("#form1").submit; */
				/*var form1 = document.queryselector("#form1");
				 form1.submit; */
				document.form1.submit();
			}
			
			
		</script>
	</head>
	<body>
		DOM 사용<%-- DHTML(Dynamic HTML) --%>
		<hr/>
		<button onclick="onClickButton1()">버튼1</button>		
		<div id="div1">최초 내용</div><%-- <div></div> 객체! --%>
		
		<button onclick="onClickButton2()">버튼2</button>	
		<%-- button(=>Event Source) onclick(=>Event)="..."(=>Event Handler or Event Listener) --%>	
		<div id="div2">
			<img class="photo" src="../common/image/photo1.jpg" width="200px"/>
		</div>
		
		<button onclick="onClickButton3()">버튼3</button>
		<div>
			<form id="form1" name="form1">
				아이디: <input id="mid" type="text" name="mid"/><br/>
				비밀번호: <input id="mpasword" type="password" name="mpassword"/><br/>
			</form>
			
		</div>
	</body>
</html>