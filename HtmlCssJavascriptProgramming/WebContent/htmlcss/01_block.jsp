<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1031 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Block 엘리먼트
		<hr/>
		<h1>Block</h1>
		<%-- block은 부모 컨테이너에 꽉차게 들어간다(부모 전체를 차지) --%>
		<div style="background-color:#ff0000; height:50px; border:1px solid green"></div>
		<div style="background-color:#0000FF; height:50px; border:1px solid yellow"></div>
		<h1 style="background-color:#0000FF; height:50px; border:1px solid yellow">제목</h1>
		<p style="background-color:#0000FF; height:50px; border:1px solid yellow">내용</p>
		<form style="background-color:#0000FF; height:50px; border:1px solid yellow"></form>
		
		<h1>In-line</h1>
		<%-- In-line은 자신의 크기만큼만 차지 한다. --%>
		<span style="color:red; border:1px solid green;">Important</span>
		<span style="color:green">Important</span>
		<span style="color:blue">Important</span>
		<img src="../common/image/naver.gif" style="border:1px solid green;"/>
		
		<h1>Block -> Inline</h1>
		<div style="height:50px; width:200px; border:1px solid green; display:inline-block;"></div>
		<div style="height:50px; width:200px; border:1px solid red; display:inline-block;"></div>
		
		<h1>Example1</h1>
		<div style="height:50px; width:200px; border:1px solid green; display:inline-block;">
			<div style="background-color:#ff0000; height:30px"><%-- 부모 전체를 차지 하므로 width:200px 이다. --%> </div>
			<%-- <div> -> 하나의 컨테이너로 많이 쓰임 --%>
		</div>
	</body>
</html>