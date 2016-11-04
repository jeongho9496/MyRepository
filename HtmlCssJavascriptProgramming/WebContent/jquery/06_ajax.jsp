<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 1104 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#btn1").on("click", function(){
					$.ajax({ //$.ajax({}) 매개변수의 타입이 객체
						url: "06_data1.jsp",
						success: function (data, status, jqXHR) { //html조각 전체 html에서 특정부분만 받아옴 data=> 응답 내용이 들어옴 server http의 본문 부분이 들어간다.
							console.log(data);
							console.log(status);
							console.log(jqXHR);
							$("#div1").html(data);
						}//plainObject => $.ajax({object})
					});					
				});
			});
			
			function checkMid() {
				var mid = $("#mid").val();
				console.log(mid);
				$.ajax({
					url:"06_data2.jsp",
					//data: "mid="+mid,	//String 방법
					data: {"mid":mid},	//plainObject 방법
					success: function(data) {
						console.log(data.trim());//.trim() 앞뒤 공백 제거
						if (data.trim()=="true") {
							$("#btn2Result").html("사용할 수 있음");
						} else {
							$("#btn2Result").html("사용할 수 없음");
						}
					}
				});
			}
			
			function getAd(kind, keyword) {
				$.ajax({
					url: "06_data3.jsp",
					data: {"kind":kind, "keyword":keyword},
					success: function(data, status) {
						console.log(status)
						$("#div3").html(data);
					}
				});
			}
			
			function getJson() {
				$.ajax({
					url: "06_data4.jsp",
					success: function(data){
						console.log(data);
						console.log(data[0]);
						
						var html='<table>';
						html += '<tr>';
						html += '<td>';
						for(var i=0; i<data.length; i++){
							html += '<div style="width:120px; height:130px; margin:5px; background-image:url('+data[i].aimg+'); background-size: 120px 130px;display:inline-block;">';
							html += 	'<div>';
							html += 		'<table style="width:100%; height:30px; background-color:rgba(0, 0, 0, 0.3);">';
							html += 			'<tr>';
							html += 				'<td style="text-align:left; color:white;">'+data[i].alocation +'</td>';
							html += 				'<td style="text-align:right; color:aqua;">'+data[i].ahitcount+'</td>';
							html += 			'</tr>';
							html += 		'</table>';
							html += 	'</div>';
							html += '</div>';
						}
						html += '</td>';
						html += '</tr>';
						html += '</table>';
						$("#div4").html(html);
					}
				});
				
			}
		</script>
	</head>
	<body>
		AJAX 통신
		<hr/>
		<button id="btn1">버튼1</button>
		<div id="div1" style="height:100px; border:1px solid black"></div>
		<br/>
		
		<button id="btn2" onclick="checkMid()">아이디 중복 체크</button>
		<input id="mid" type="text" name="mid"/>
		<span id="btn2Result"></span>
		<br/>
		
		<button id="btn3" onclick="getAd('book', 'java')">광고 정보 얻기</button>
		<div id="div3"></div>
		<br/>
				
		<button id="btn4" onclick="getJson()">Json 응답 이용</button>
		<div id="div4"></div>
	</body>
</html>