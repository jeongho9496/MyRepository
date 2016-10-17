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

--1017
--비교연산자
select ename,deptno from emp where deptno != 20;
select ename,deptno from emp where deptno <> 20;
select ename,deptno,sal from emp where sal >= 500;

--문자 데이터 조회
select * from emp where ename='이문세'; --문자열을 찾을시 ""가 아닌 ''를 사용

--날짜 데이터 조회
--2005년 1월 1일 이전에 입사한 사원의 정보
select * from emp where HIREDATE < '2005-01-01';
select * from emp where HIREDATE < to_date('2005-01-01','YYYY-MM-DD');--to_date -> 문자열을 날짜로 바꿔줌.

--논리연산자
--And 연산자
--10번 부서에 소속된 사원 중에서 직급이 과장인 사원
select * from emp where deptno=10 and job='과장';
--월급이 400이상 500이하
select * from emp where 400<=sal and sal<=500;

--OR 연산자
--10번 부서에 소속된 사원또는 직급이 과장인 사원
select * from emp where deptno=10 or job='과장';

--NOT 연산자
--10번 부서가 아닌 사원의 정보
select * from emp where deptno!=10;
select * from emp where deptno<>10;
select * from emp where not deptno=10;

--BETWEEN AND 연산자
--월급이 400이상 500이하
select * from emp where 400<=sal and sal<=500;  --연산자 3개사용(400<=sal, sal<=500, and)
select * from emp where sal between 400 and 500;--연산자 1개 사용 연산자가 적을수록 계산속도가 더 빠르다.
select * from emp where ename between '가' and '자';

--IN 연산자
--보너스가 80이거나, 100이거나, 200인 사원의 정보
select * from emp where comm=80 or comm=100 or comm=200;--연산자 5개 사용(comm=80,comm=100,comm=200,or,or)
select * from emp where comm in (80,100,200);--연산자 1개 사용. 문자열도 가능

--LIKE 연산자와 와일드 카드
--와일드카드(%) 사용하기
--성이 이씨인 사원의 정보
select * from emp where ename between '이' and '익';
select * from emp where ename like '이%';--'%'는 LIKE연산자가 와야 사용가능
--이름 중에 '성'이 포함된 사원의 정보
select * from emp where ename like '%성%';--성이 포함된 모든 문자 찾아내기
--와일드카드(_) 사용하기
--이름중에 두번째 글자가 '성'인 사원의 정보
select * from emp where ename like '_성%';
--이름중에 '성'이 포함되지 않는 사원의 정보
select * from emp where not ename like '%성%';--조건 자체 부정

--NULL을 위한 연산자
--보너스가 없는(null)인 사원의 정보
select * from emp where comm is null;--null인 컬럼 출력
--보너스가 있는 사원의 정보
select * from emp where comm is not null;

--오름차순 정렬을 위한 ASC
select * from emp order by sal;
select * from emp order by sal asc;

--내림차순 정렬을 위한 DESC
select * from emp order by sal desc;
select * from emp order by hiredate desc;
--가장 최근에 입사한 순서(1차 정렬) -> 이름순 올림 차순(2차 정렬)
select * from emp order by hiredate desc, ename asc ;

--30번 부서에서 월급이 400이상인 사원의 번호, 이름, 연봉(내림차순)을 가져오기(시험)
select empno,ename,sal*12+nvl(comm,0) as yearsal from emp 
where sal>400 and deptno=30
order by yearsal desc;