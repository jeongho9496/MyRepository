<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1101 --%>
<!DOCTYPE html>
<%-- static:
	absolute: 부모가 relative면 부모 최상단을 기준으로 위치 한다. 아니라면 브라우저 최상단을 기준으로 위치한다.
	fixed: 위치가 고정 되어 화면이 스크롤 되도 화면에 따라 움직 이지 않는다. --%>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			#div1 {
				position: absolute;
				left: 100px;/* absolute 영향을 받음 */
				top: 200px; /* absolute 영향을 받음 */
				width: 100px;
				height: 100px;
				background-color: red;
			}
			#div2 {
				width: 100px;
				height: 100px;
				background-color: blue;
			}
			#div3 {
				position: fixed;
				left: 300px;/* fixed 영향을 받음 */
				top: 200px; /* fixed 영향을 받음 */
				width: 100px;
				height: 100px;
				background-color: black;
			}
			#div4 {
				position: relative;
				left: 500px;
				top: 100px; 
				width: 300px;
				height: 300px;
				background-color: transparent;
				border: 5px solid black;
			}
			
			#div5 {/* default: static */
				position: absolute;
				left:150px;
				top:150px;
				width: 50px;
				height: 50px;
				background-color: green;
				border: 5px solid black;
			}
			#div6 {/* default: static */
				position: relative;
				left:0px;
				top:0px;
				width: 50px;
				height: 50px;
				background-color: red;
				border: 5px solid black;
			}
			#div7 {/* default: static */
				position: relative;
				left:0px;
				top:0px;
				width: 50px;
				height: 50px;
				background-color: yellow;
				border: 5px solid black;
			}
		</style>
	</head>
	<body>
		<div id="div1"></div>
		<div id="div2"></div>
		<div id="div3"></div>
		<div id="div4">
			<div id="div5"></div>
			<div id="div6"></div>
			<div id="div7"></div>
		</div>
		<%for(int i=0; i<30; i++) {%>
		<br/>
		<%}%>
	</body>
</html>