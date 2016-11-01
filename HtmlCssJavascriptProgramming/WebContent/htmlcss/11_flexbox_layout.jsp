<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1101 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
		
			#container {
				width: 100%;/* 부모의 전체 크기를 차지  100%아닐시 margin: auto로 중앙정렬*/
				border: 1px solid gray;
				display: flex;	/* CSS3 사용 */
				flex-direction: column;/* flex방향 설정  column: 수직 row: 수평*/
				height: 98vh;
			}
		
			#header, #footer {
				padding: 1em;
				color: white;
				background-color: black;
				text-align: center;
			}
			
			#content {
				flex:1;/* 나머지 부분 차지 */
				display: flex;/* row방향 */
				flex-direction: row;/* row 수평 */
			}
			
			#content #menu {
				background-color: orange;
				width: 150px;/* max-width가 있을시 flex는 빠진다. */
				padding: 1em;
			}
			#content #center {
				flex:1;
				padding: 1em;
			}
			
			#content #menu ul{
				list-style-type: none;/* . 부분이 사라지진만 영역은 남아있다. */
				padding: 0;		/* . 영역을 없애기 위해 사용 */
			}
			
			
		</style>
	</head>
	<body>
		<div id="container">
			<div id="header"><h1>City Gallery</h1></div>
			<div id="content">
				<div id="menu">
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
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					    <li><a href="#">Tokyo</a></li>
					  </ul>
				</div>
				<div id="center">
					<h1>London</h1>
			  		<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
			  		<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
				</div>
			</div>
			<div id="footer">Copyright © W3Schools.com</div>
		</div>		
	</body>
</html>