--1017
--Section01 DUAL 테이블
select * from dual;--dual: oracle가 사용하는 가상 테이블
select 10+20 from dual;
select sysdate from dual;--sysdate : 프로시저 중 하나 현재 시간 출력.

--Section02 숫자 함수
--절대값을 구하는 ABS함수
select abs(-10) from dual;
SELECT ABS(-15) "Absolute" FROM DUAL;
update emp set sal=sal/7;
select * from emp;
rollback; -- rollback : 전으로 돌리기

select sal from emp;
--소수 첫째자리까지 나타내기(반올림)
select sal, round(sal,1) from emp;
--바로 아래 정수(소수를 정수로 만드는 방법 내림 효과)
select sal, floor(sal) from emp;
--반올림해서 정수 만들기(소수를 정수로 만드는 방법)
select sal, round(sal) from emp;
--바로 위 정수(올림 효과)
select sal, ceil(sal) from emp;
--소수 첫째자리 까지 잘라내기로 나타내기
select sal, trunc(sal,1) from emp;

--Section03 문자 처리 함수
--대소문자 변환 함수
select * from employees;
select phone_number,first_name,last_name from employees where lower(first_name)='steven'; --데이터 부분은 대소문자 가림

--문자 조작 함수
--문자열 일부만 추출하는 SUBSTR 함수
select * from employees;
select substr(first_name,1,5) from employees;
--특정 기호로 채우는 LPAD/RPAD함수
select lpad('oracl',20,'*')from dual;--문자열(orcal) 왼쪽(lpad)에 특수기호(*) 갯수(20) 만큼 채움
select rpad('oracl',20,'*')from dual;--문자열(orcal) 오른쪽(rpad)에 특수기호(*) 갯수(20) 만큼 채움
--10자리에 사원 이름을 5자리 까지만 나오게 하고 나머지는 오른쪽(*) 처리를 하시오
select rpad(substr(first_name, 1,5), 10, '*') from employees;--게시판 유효글자 표시 할때 사용 ex. 가나다...

--Section 04 형 변환 함수
--날짜형을 문자형으로 변환하기
select hire_date, to_char(hire_date,'YYYY.MM.DD DAY HH:mm:ss') from employees;
--문자형을 날짜형으로 변환하기
select first_name, hire_date from employees where hire_date=to_date('2003.06.17');
