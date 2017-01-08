<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html >
<html>
	<head>
		<title> 2CM </title> 
			     
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">	
		<link href="${pageContext.servletContext.contextPath}/resources/css/style_1.css" rel="stylesheet"/>	
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />	 
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    	<link href="${pageContext.servletContext.contextPath}/resources/css/waves.css" rel="stylesheet" >
    	<link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet"/>
    	<link href="${pageContext.servletContext.contextPath}/resources/css/order.css" rel="stylesheet"/>
		<link href="${pageContext.servletContext.contextPath}/resources/css/index.css" rel="stylesheet"/>
		
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/waves.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
							
 		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/index.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/menuModal.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/loginModal.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/orderModal.js"></script>
  		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/storeModal.js"></script>		
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/joinModal.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/eventModal.js"></script>
	</head> 
	<body style="padding-top:-10px;">
		<div class="wrap">
			<!-- nav 영역을 호출할 버튼  -->
			<a class="btnMenu" href="#"><i class="fa fa-navicon"></i> </a>
			<!-- 실제 카테고리 메뉴가 들어갈 nav 영역 -->
			<nav>
				<h1 style="left:58px; top:0px;"><img src="resources/photo/logo.png" style="width:250px;"/></h1>
				<ul id="gnb">
					<li><a href="#">Home</a></li>
					<li><a id="btnStore" href="#">Store</a></li>
					<li><a id="btnMenu" href="#">Menu</a></li>
					<li><a id="btnEvent" href="#">Event</a></li>
					<li><a id="btnOrder" href="#">Order</a></li>
				</ul>
				
			<!--
				<div style="position:relative; top:85%;" class="form-group text-center">
                 	<a id="btnLogin" href="#">
                 		<button class="btn btn-success btn-login-submit">Login</button>
                 	</a>
                </div> 
                -->
                
                
                
            <c:if test="${empty login}">
                <div style="position:relative; top:85%;" class="form-group text-center">
               		<button id="btnLogin" style="display: inline; zindex:5000;" class="btn btn-info btn-login-submit">Login</button>
                 	<button id="btnLogout" style="display: none; zindex:5000;" class="btn btn-danger btn-login-submit">Logout</button>
                </div>
            </c:if>
            <c:if test="${not empty login}">
               <div style="position:relative; top:85%;" class="form-group text-center">
               		<button id="btnLogin" style="display: none; zindex:5000;"  class="btn btn-info btn-login-submit">Login</button>
                 	<button id="btnLogout" style="display: inline; zindex:5000;" class="btn btn-danger btn-login-submit">Logout</button>
                </div>
            </c:if>
                
                
			</nav>
			
			<!-- 3개의 컨텐츠 박스가 들어갈 section 영역 -->
			<section>
								
				<!-- 첫 번째 박스 -->
				<div class="box1 on">
					<p></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 두 번째 박스 -->
				<div class="box2">
					<p></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 세 번째 박스 -->
				<div class="box3">
					<p></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 네 번째 박스 -->
				<div class="box4">
					<p></p>
					<p></p>
					<p></p>
				</div>
				
				<!-- 다섯 번째 박스 -->
				<div class="box5">
					<p></p>
					<p></p>
					<p></p>
				</div>
			</section>
		</div>
		
		<%-- Modal --%>
		<%@ include file="store/loginModal.jsp" %>
		<%@ include file="store/loginResultModal.jsp" %>
		<%@ include file="store/storeModal.jsp" %>
		<%@ include file="store/joinModal.jsp" %>
		
 		<%@ include file="menu/menuModal.jsp" %>
		<%@ include file="menu/menuRegModal.jsp" %>
		<%@ include file="menu/menuModModal.jsp" %>
		<%@ include file="menu/menuInfoModal.jsp" %>
		
		<%@ include file="event/eventModal.jsp" %>
		<%@ include file="event/eventRegModal.jsp" %>
		<%@ include file="event/eventInfoModal.jsp" %>
		<%@ include file="event/eventModiModal.jsp" %>

		<%@ include file="order/orderModal.jsp" %>
		<%@ include file="order/detailListModal.jsp" %>
		<%@ include file="order/orderForm1Modal.jsp" %>
		<%@ include file="order/orderForm2Modal.jsp" %>
		<%@ include file="order/termListModal.jsp" %>
		
	</body>
</html>















