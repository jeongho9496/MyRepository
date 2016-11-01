<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1031 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		HTML,CSS
		<hr/>
		1) <a href="01_block.jsp">Block 엘리먼트(태그)</a> <br/>
		2) <a href="02_iframe.jsp">iFrame</a> <br/>
		3) <a href="03_layout.jsp">Layout 관련 엘리먼트(태그)</a> <br/>
		4) <a href="04_css_selector.jsp">CSS 선택자</a> <br/>
		5) <a href="05_css_location.jsp">CSS 작성 위치</a> <br/>
		6) <a href="06_background.jsp">Background 관련 CSS속성</a> <br/>
		7) <a href="07_icon.jsp">icon 관련 CSS속성</a> <br/>
		8) <a href="08_table.jsp">table 관련 CSS속성</a> <br/>
		9) <a href="09_location.jsp">location 관련 CSS속성</a> <br/>
		10) <a href="10_float_layout.jsp">float 속성을 이용한 레이아웃</a> <br/>
		11) <a href="11_flexbox_layout.jsp">flexbox 속성을 이용한 레이아웃</a> <br/>
		
		<p data="3&lt;5"> 3 &lt; 5 &gt;4 </p> <%-- 3 &lt;:~보다 작다 5 &gt;:~보다 크다 4 --%>
		<%-- &lt; Less than: < , &gt; Greater than: > --%>

		<p>	&#165;30</p><%-- Entities : 키보드로 입력할수 없는 문자는 아스키 코드(&#165;)를 사용 --%>		
		
		<p>I will display &euro;</p>
		<p>I will display &#8364;</p>
		<p>I will display &#x20AC;</p>
		
		<%-- form Tag 안에 Button 태그는 submit 기능을 한다. --%>
		<%-- novalidate 브라우저 마다 다다른 유효성 검사를 무시한다. --%>
		<%-- 정규표현식 :[한글자]{최대 작성수} --%>
		
		<input type="reset"><%-- reset : 초기화 --%>
	</body>
</html>