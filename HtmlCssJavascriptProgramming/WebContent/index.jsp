<%@ page contentType="text/html;charset=UTF-8" %><%-- 역할 1. 파일 저장 인코딩 지정. 2. HTML내용이 어떤 문자셋인지 브라우저에 전달 --%>
<%@ page pageEncoding="UTF-8" %><%--파일 저장 인코딩 지정(어떤 형식으로 지정 할건지) --%>

<%-- 1031 --%>
<!DOCTYPE html>		<%-- 문서 유형 션연 브라우저에서 문서 유형 선언을 가지고 버전을 확인함(브라우저가 파서(해독)기능을 가지고 있음) --%>
<html>				<%-- 문서 형식 --%>
	<head>			<%-- 인코딩/style/Javascript 등등 선언 가능 --%>
		<meta charset="UTF-8">	<%-- 브라우저가 어떻게 해석헤야 하는지 명시 --%>
		<title>index</title>	<%-- 홈페이지 제목 으로 나옴 --%>
	</head>
	<body>			<%-- UI TAG(엘리먼트) --%>
		HTML, CSS, JavaScript 학습<!-- !----=> 결과과 브라우저에 나옴 --> <%-- <%----> 실행에서 제외 --%>
		<hr/>
		<img src="">
		
		1. <a href="htmlcss/index.jsp"> HTML/CSS </a> <br/>
		2. <a href="javascript/index.jsp"> JavaScript </a> <br/><%-- <br/> 시작과 끝이 같을 때 한꺼번에 사용(<br>내용없음</br>) --%>
		3. <a href="jquery/index.jsp"> jQuery </a> <br/>
	</body>
	
</html>
<%-- 속성(TAG) 확인 할 시 http://www.w3schools.com/tags/tag_img.asp에서 확인 --%>