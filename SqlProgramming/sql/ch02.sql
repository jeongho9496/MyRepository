--1014 문장과 절
select * from emp;--여러행일시 실행문의 끝을 ; 으로 한다. select*(가져올 컬럼 이름)from emp(테이블 이름);
--특정 데이터만 보기
select empno, ename from emp;
--산술 연산자
select ename, sal, sal*12 from emp;--select 연산식도 올수 있음.
--NULL도 데이터 이다.(null 연산시 주의할 점)
select ename,sal,comm,sal*12+comm from emp;--null : 데이터가 없다. null로 연산시 해당 데이터가 null 처리 된다.
select ename,sal,comm,sal*12+nvl(comm,0) from emp;--nval( text , 0 ) =>text가 null이라면 0으로 대치 : 함수 호출 -> *함수:실행블록 VS 메소드()객체안에서 존재해야 하는 실행블록(기능)
--컬럼 이름에 별칭 지정하기
select ename as 이름 ,sal as 월급,comm 보너스,sal*12+nvl(comm,0) 연봉 from emp;--as 결과셋 컬럼명 변경 as는 넣어도 되고 안넣어도 된다.
--Concatenation 연산자(문자열 결합)
select (empno|| '-' || ename) as 이름 from emp;--(a|| '-' || b) : a,b 컬럼의 문자열 결합
select ename || '의 직급은' || job || '입니다.' as 직급 from emp;
--DISTINCT 키워드(중복 제거)
--사원이 있는 부서 번호는?
select distinct deptno from emp;-- distinct 컬럼명 : 해당하는 컬럼의 중복 값을 제거 한다.

-----------------------------------------------------------------------------------------------------------------------------
--조건절 작성
select ename,deptno from emp where deptno = 20; --where 컬럼명 = 조건식 : 해당 컬럼에서 조건식에 해당하는 데이터 출력
--비교연산자
