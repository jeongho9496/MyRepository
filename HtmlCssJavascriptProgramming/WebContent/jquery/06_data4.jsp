<%@ page contentType="application/json;charset=UTF-8" %><%-- json 파일 설정 --%>
<%-- 1104 --%>

[
	{"ano":1, "alocation":"독일", "ahitcount":10, "aimg":"../common/image/photo1.jpg"},
	{"ano":2, "alocation":"독일", "ahitcount":4, "aimg":"../common/image/photo2.jpg"},
	{"ano":3, "alocation":"독일", "ahitcount":16, "aimg":"../common/image/photo3.jpg"}
]

<%-- JSON 특징 
	속성 이름은 반드시 ""로 감싸야 함. 
	문자열 값도 ""로 감싸야함. (숫자는 상관 없음)
	값은 null도 가능.
	배열은 [], 객체는 {}로 구분
	--%> 
<%-- {} 객체만 전달 --%>
<%-- 안드로이드에서도 데이터 받을 수 있음 --%>