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
			*{
				margin:0px;
				padding:0px;
			}
			
			#header, #footer {
				background-color: black;
				color: white;
				background-color: black;
				text-align: center;
			}
			
			#content #menu {
				background-color: orange;
				padding: 1em;
			}
			#content #center {
				padding: 1em;
			}
			
			#content #menu ul{
				list-style-type: none;/* . 부분이 사라지지만 영역은 남아있다. */
				padding: 0;		/* . 영역을 없애기 위해 사용 */
			}
			
			/* #container {
				border: 1px solid gray;
				height: 98vh;
			} */
			
			</style>
	</head>
	<body>
		<div id="container" class="container-fluid">
		<div id="header" class="row">
			<div class="col-md-12">
				<h1>City Gallery</h1>
			</div>
		</div>
		<div id="content" class="row">
			<div id="menu" class="col-xs-12 col-md-3">
				<ul>
					    <li><a href="#">London</a></li>
					    <li><a href="#">Paris</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					  </ul>
			</div>
			<div id="center" class="col-md-9">
				<h1>London</h1>
			  		<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
			  		<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
			</div>
		</div>
		<div id="footer" class="row">
			<div class="col-md-12">Copyright © W3Schools.com</div>
		</div>
		</div>
	</body>
</html>