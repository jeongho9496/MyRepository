<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1101 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../common/bootstrap-3.3/css/bootstrap.min.css">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="../common/bootstrap-3.3/js/bootstrap.min.js"></script>
		<style type="text/css"> 
			div{
				border: 1px solid black;
			}</style>
	</head>
	<body>
		Grid System(Layout 작성)
		<hr/>
	<%--<div class="row">
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		</div>
		
		<div class="row">
		  <div class="col-md-8">.col-md-8</div>8공간 안에 내용 추가
		  <div class="col-md-4">.col-md-4</div>4공간 안에 내용 추가
		</div> --%>
		
		<div class="row">
		  <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div><%-- 부모의 컨테이너에 영향을 받음 부모가 600px이면 600px에 12등분으로 기준으로 나온다. --%>
		  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		</div>
	</body>
</html>