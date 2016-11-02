<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1031 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			*{/* color: red;  */font-stretch: extra-expanded; font: bold; font-size: large;}
			
			div{background-color: yellow;}	<%-- 모든 div에 적용 --%>
			
			#div2{background-color: aqua;}	<%-- id가 div2인 객체에 적용 id: 유일한 값 --%>
			
			.div3{background-color: green;}	<%-- class가 div3인 객체에 적용 class:그룹 --%>
			
			#div4,#p1,#h1{background-color: orange;} /* ' , ' -> and 기호 */
			
			#div5 p {background-color: blue;}
			
			#div6 > p {background-color: fuchsia;} <%-- 바로 밑에 --%>

			#div7 + p {background-color: maroon;}
			
			[checked]{color:green;} /* 속성이 checked가 있는 태그에 영향 */
			
			[selected=true] {color:blue;}
			#form1 [checked]{background-color: green;}
			
			a {color:black; text-decoration: none;}
			a:active {color:red;}/* 클릭 시 나오는 색 */
			a:link {color:green;}/* 기본 색 */
			a:hover {color:green; text-decoration: underline;}/* 마우스를 갖다 델때 색깔 변화 */
		</style>
	</head>
	<body>
		CSS 선택자
		<hr/>
		<div>A</div>
		<div id="div2" class="div3">B</div> <%-- 우선 순위 id > class > div --%>
		<div id="div2">D</div><%-- id가 똑같은게 2개 있음 안된다. --%>
		<div class="div3">C</div>
		<div class="div3">E</div><%-- class(그룹이름)는 같은 그룹 표시 이므로 같은 이름이 여러개 있어도 된다. --%>
		
		<br/>
		<div id="div4">F</div>
		<p id="p1">G</p>
		<h3 id="h1">H</h3>
		
		<br/>
		<div id="div5">
			<p>A</p>
			<p>B</p>
		</div>
		
		<br/>
		<div id="div6">
			<div><p>A div6</p></div>
			<p>B</p>
		</div>
		
		<br/>
		<div id="div7">div7</div>
		<p>A</p>
		<p>B</p>
		
		<br/>
		<div>
			<div checked="true">A</div>
			<div checked="false">B</div>
			
			<div selected="false">C</div>
			<div selected="true">D</div>
			<div selected="true">E</div>
		</div>
		
		<form id="form1">
			<div checked="true">A</div>
			<div checked="false">B</div>
		</form>
		
		<br/>
		<div style="background-color: white">
			<a href="http://www.naver.com">네이버</a><br/>
			<a href="http://tomcat.apache.org">톰캣</a><br/>
			<a href="http://www.w3c.org">W3C</a><br/>
		</div>
		
		<br/>
		<form id="form1">
			<div checked="true">A</div>
			<div checked="false">B</div>
		</form>
		
	</body>
</html>