<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1103 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			//함수 대입
			var $ = function (selector) {//#div1이 들어감.
				console.log("aaa");
				return document.querySelectorAll(selector) //#div1 정보가 리턴
				//return document.querySelectorAll(selector)//선택 되어진 모든 객체를 배열로 연결하라
				
			};
			
			//동적 메소드 추가
			$.ajax = function(){
				console.log("BBB");
			};
			
			function test() {
				$("#div1")[0].innerHTML = "수정 내용";//함수
				$.ajax();/* ajax메소드 호출 */				
			}
		
		</script>
	</head>
	<body>
		$는 함수형 객체
		<hr/>
		<button onclick="test()"> 버튼 </button>
		<div id="div1">최초 내용</div>
		
	</body>
</html>