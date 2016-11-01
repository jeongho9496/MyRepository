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
		
			div.container{
				
				width: 100%;
				/*margin: auto; 중앙정렬 */
				border: 1px solid gray;
				/*      굵기   모양   색상 ; */
			}
			
			header, footer{
				padding: 1em;
				background-color: black;
				text-align: center;
				color: white;
			}
			
			footer {
				clear: both;/* float 특성을 없애 겠다. */
			}
			
			nav {
				float: left;
				max-width: 160px;
				margin: 0px;
				padding: 1em;
				background-color: orange;
				width: 300px;
			}
			
			nav ul{/* nav에 있는 ul tag를 선택하라 */
				list-style-type: none;/* . 부분이 사라지진만 영역은 남아있다. */
				padding: 0;		/* . 영역을 없애기 위해 사용 */
			}
			
			/* nav ul > a {} nav안의 ul tag 바로 밑에 a tag를 찾아라 */
			
			nav ul a {/* nav안의 ul tag 안에 있는 a tag를 찾아라 */
				text-decoration: none;
			}
			
			article {
				margin-left: 170px;/* 부모의 위치에서 옮김. */
				border-left: 1px solid gray;
				padding: 1em;/* 1em : 16px */
				overflow: hidden;/* article 내의 스크롤 정지 */
			}
			
			
			
			
		</style>
	</head>
	<body>
		<div class="container">
			
		<header>
		   <h1>City Gallery</h1>
		</header>
		  
		<nav>
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
		</nav>
		
		<article>
		  <h1>London</h1>
		  <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
		  <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
		</article>
		
		<footer>Copyright © W3Schools.com</footer>
		
		</div>
	</body>
</html>