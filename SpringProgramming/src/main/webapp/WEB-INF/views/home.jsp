<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<!-- 0927 -->
<!-- 0929 -->
<html>
	<head>
		<meta charset = "UTF-8">
	</head>
	<body>
		SpringProgramming
		<hr/><!-- 수평선 -->
		<!-- 1. <a href="http://localhost:8080/myapp/exam01/join">컨트롤러 및 요청 매핑 메소드 작성</a><a> -> 클릭가능<br/><br/> 개행 -->
		<!-- "http://localhost:8080/myapp/exam01/join" => (절대경로)절대경로 모든 주소 지정 ex)외부의 웹서버 접근시 사용 -->
		<!-- 3. <a href="exam01/join">컨트롤러 및 요청 매핑 메소드 작성</a><a> -> 클릭가능<br/> -->
		<!-- "exam01/join" => (상대경로)http://localhost:8080/myapp/(현재의 경로)까지 똑같다는 뜻 -->
		1. <a href="/myapp/exam01/index">Exam01</a>: 컨트롤러 및 요청 매핑 메소드 작성<!-- <a> -> 클릭가능 --><br/>
		<!-- "/myapp/exam01/join" => (절대경로)http://localhost:8080(포트번호)까지 똑같다는 뜻 -->
		
		2. <a href="/myapp/exam02/index">Exam02</a>: 요청 파라미터 값 받기<br/>
		3. <a href="/myapp/exam03/index">Exam03</a>: 폼 입력 값 받기<br/>
		4. <a href="/myapp/exam04/index">Exam04</a>: 요청 방식별 처리<br/>
		5. <a href="/myapp/exam05/index">Exam05</a>: 요청 처리 메소드의 리턴 타입<br/>
		6. <a href="/myapp/exam06/index">Exam06</a>: 요청 처리 메소드의 매개변수 타입<br/>
		7. <a href="/myapp/exam07/index">Exam07</a>: 컨트롤러에서 JSP로 데이터 객체 전달<br/>
		8. <a href="/myapp/exam08/index">Exam08</a>: Redirect<br/>
		<br/>
		9. <a href="/myapp/exam09/index">Exam09</a>: 의존성 주입(DI): XML설정 파일 이용<br/>
		10. <a href="/myapp/exam10/index">Exam10</a>: 의존성 주입(DI): @어노테이션 이용<br/>
		
		<br/>
		11. <a href="/myapp/exam11/index">Exam11</a>: 서비스 계층과 데이터(Persistance) 계층<br/>
		
		<%--1024 --%>
		12. <a href="/myapp/exam12/index">Exam12</a>: Connection Pool설정<br/>
		
		<%-- 1025 --%>
		13. <a href="/myapp/exam13/index">Exam13</a>: Jdbc템플릿을 이용한 DAO<br/><br/>
	</body>
</html>
