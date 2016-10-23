--01도전퀴즈
--1. 테이블
--2. column(열), row(행)
--3. select
--4. DML
--5. DDL
--6. DCL
--7. SQL
--8. SQL*plus
--9. 2 primary key

-- -----------------------------------------------------------------------------------------

--02도전퀴즈
--1. 3 LIKE
--2 급여를 400에서 500사이 받는 사원을 조회하기 위한 표현.
--2. 3 BETWEEN
select * from emp where sal between 400 and 500;
--3. 2 OR
--4. 4 like
--5. 1 order by
--6. 1 is null
--7 사원번호를 기준으로 내림차순으로 정렬하여, 사원번호와 사원명 컬럼을 출력
select empno, ename
from emp
ORDER BY empno desc;
--8 select 명령문 사용 시 중복되는 데이터를 제외하고 출력하라는 뜻
select DISTINCT sal
from emp
ORDER BY sal asc;

---------------------------------------------------------------------------------------

--03도전퀴즈
--1사원번호가 홀수인 사람들을 검색 하기
select *
from emp
where mod(empno,2)=1;

--2사원들의 입사일에 대해서 년도, 월, 일을 개별적으로 출력하기
select hiredate, substr(hiredate,1,2) 년 ,substr(hiredate,4,2) 월,substr(hiredate,6,2) 일
from emp;

--3 사원들의 근무일수 구하기
select round(sysdate-hiredate) 근무일수
from emp;

--4 상급자가 없는 사원만 출력하되, mgr 칼럼 값 NULL 대신 CEO 로 출력
select empno, ename ,nvl(TO_CHAR(mgr,'9999'), 'C E O')  직속상관
from emp
where mgr is Null;
--5. dual
--6 오늘을 기준으로 100일 후의 날짜를 출력
select sysdate+100 from dual;
--7. 오늘 속한 달의 마지막 날 출력
select last_day(sysdate) from dual;
--8. nvl2(comm, sal+comm, sal) 뜻?
--Comm을 검사하여 그 결과가 null이 아니면 sla+comm을 반환하고, null이면 sal을 반환.

----------------------------------------------------------------------------------------

--04 도전 퀴즈
--1. 3 group by
--2. 1 having
--3, 3 그룹 함수 중 sum()을 제외한 모든 함수가 null값을 무시합니다.
--4
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 500;
--5. 3. Sum
--6. case
--7. 30번 부서에 소속된 사원 중에서, 커미션을 받는 사원의 수를 구하기
select count(*) 사원수
from emp
where deptno = 30
and comm is not null;
--8. 가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력
select max(hiredate),min(hiredate)
from emp;
--9. 부서별로 각각의 급여 합계를 구하되, 결과 중에서 합계가 300 초과인 사람들만 구하기
select job, sum(sal)
from emp
group by job
having sum(sal)>300
order by job;

---------------------------------------------------------------------------------------
--07강 도전 퀴즈
--1. 3 ALTER
--2. 1. ALTER TABLE
--3. DDL 이란 ?
-- Data Definition Language : 테이블과 같은 데이터 구조를 정의하는데 사용됨
-- CREATE	- 데이터베이스 객체를 생성
-- DROP	- 데이터베이스 객체를 삭제
-- ALTER	- 기존에 존재하는 데이터베이스 객체를 다시 정의(수정)
-- RENAME	- 데이터베이스의 컬럼명을 변경
-- TRUNCATE- 테이블을 최초 생성된 초기상태로 만들며, ROLLBACK이 불가능

----------------------------------------------------------------------------------------

--08도전 퀴즈
--1,2
create table dept01(
  deptno NUMBER(2),
  dname VARCHAR2(14),
  loc VARCHAr(13)
);
insert into dept01 values(60, '생산부','포천');
insert into dept01(deptno, dname) values(60, '개발부');
--1. 4 insert into department values(60, ‘생산부’, ‘포천’);
--2. 1 insert into department(deptno, dname) values(70,’총무부’);
--3. 2 set
--4. 2 commit
--5. 3 update to where (=> update set where.)
--6. 3 트랜잭션
--7. DML 이란?
--Data Manipulation Language : 데이터 베이스의 테이블에 들어 있는 데이터에 변형을 가하는 종류의 명령어들과 데이터베이스에 들어 있는 데이터를 조회하거나 검색하기 위한 명령어.
--INSERT 데이터베이스 객체에 데이터를 입력
--DELETE 데이터베이스 객체에 데이터를 삭제
--UPDATE 기존에 존재하는 데이터베이스 객체안의 데이터 수정
--SELECT 데이터베이스 객체로부터 데이터를 검색

----------------------------------------------------------------------------------
--09강 도전 퀴즈 
--1. 1 NULL
--2. INSERT문에서 DEFAULT VALUES 또는 DEFAULT 키워드를 사용하면 자동으로 기본 값이 저장된다.
--3. 2 FOREIGN KEY

------------------------------------------------------------------------------------------------

--10강 도전 퀴즈
--1. 4 WHERE
--2. 4 where member.manager = manager.empno
SELECT ename
from emp member, emp manager
where member.empno = manager.empno;
--3. 3 Alias를 사용하지 않아도 된다.
--4. 4 select w.ename, m.ename from emp w, emp m where w.manager = m.empno;
--5. 1 equi join(inner join)
--6. 3 innerjoin
--7. 4 세 개 이상의 테이블은 조인할 수 없다.
--8. 4 where (on)
--9. 1 emp.ename
--10. 1 self join을 사용하면서 outer join을 동시에 사용할 수 있다.
--11. 사원테이블과 부서테이블을 조인하여 사원이름과 부서번호와 부서명을 출력.
select ename, dept.deptno, dname
from emp inner join dept
on emp.deptno = dept.deptno;
--12. 경리부 부서 소속 사원의 이름과 입사일을 출력.
select e.ename, e.hiredate
from emp e, dept d
where d.dname='경리부'
and e.deptno = d.deptno;
--13. 직급이 과장인 사원의 이름, 부서명을 출력
select e.ename, d.dname
from emp e, dept d
where e.job ='과장'
and e.deptno = d.deptno;
--14. 직속상관이 감우성인 사원들의 이름과 직급을 출력.
select work.ename, work.job
from emp work, emp manager
where manager.ename='감우성'and work.mgr = manager.empno;
--15 감우성과 동일한 근무지에서 근무하는 사원의 이름을 출력
select work.ename, friend.ename
from emp work, emp friend
where work.deptno = friend.deptno
and work.ename='감우성'
and friend.ename!='감우성';

-----------------------------------------------------------------------------------------

--11강 도전 퀴즈
--1. 2 메인 쿼리에서 서브 쿼리의 결과 값으로 하나만 리턴받으려면, 서브 쿼리에서 group by를 사용해야 한다.
--2. 3 max(sal), min(sal)
select ename, sal from emp where sal > (select min(sal) from emp);
--3. 급여가 500이 넘는 사원과 같은 부서에 근무하는 직원을 조회하는 쿼리문을 완성하기 위해서 들어갈 수 없는 것 2 not exists 3. =
select ename, sal, deptno
from emp
where deptno in(select distinct deptno from emp where sal>500);
--4. 4 group by 문
--5??
update table (emp)
set sal=sal+100
where deptno = (select deptno from dept where deptno=10);
--6. 4 select * into emp2 from emp;
--7. emp를 emp06테이블에 복사
create table emp06
as select * from emp;
--8. 사원 정보 중 과장들의 최소 급여보다 많은 급여를 받는 사원의 이름,급여,직급을 출력하되, 과장은 출력하지 않는 SQL문
select ename,sal,job
from emp06
where sal>any(
  select sal
  from emp06  
  where job='과장') and job != '과장';
--9. emp06 테이블에 저장된 사원 정보 중 인천에 위치한 부서에 소솔된 사원들의 급여를 100 인상하는 SQL문 완성
update emp06
set sal=sal+100
where deptno = (select deptno from dept where loc='인천');
select * from emp06;
--10 emp06 테이블에서 경리부에 소속된 사원들만 삭제하는 sql문을 완성하기
delete from emp06
where deptno=(select deptno from dept where dname='경리부');
--11 '이문세'와 같은 부서에서 근무하는 사원의 이름과 부서 번호를 출력.
select *
from emp06
where deptno = (select deptno from emp06 where ename='이문세')
and ename != '이문세';
--12 이문세와 동일한 직급을 가진 사원을 출력
select *
from emp06
where job = (select job from emp06 where ename='이문세')
and ename != '이문세';
--13 '이문세'의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력
select ename,sal
from emp06
where sal>=(select sal from emp06 where ename='이문세')
and ename != '이문세';
--14 '인천'에서 근무하는 사원의 이름, 부서 번호를 출력
select ename, deptno
from emp06
where deptno = (select deptno from dept where loc='인천');
--15 직속 상관이 감우성인 사원의 이름과 급여를 출력
select ename , sal
from emp06
where mgr = (select empno from emp06 where ename='감우성');
--16 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 사원 이름, 급여, 부서번호)를 출력 잘 모르겠습니다.
select e.*
from emp06 e
where sal = (select max(sal) from emp06 where deptno = e.deptno);??
--17 직급이 과장인 사원이 속한 부서의 부서 번호와 부서명과 지역을 출력
select deptno, dname, loc
from dept
where deptno in (select deptno from emp06 where job='과장');
---18 과장보다 급여를 많이 받는 사원들의 이름과 급여와 직급을 출력하되, 과장은 출력하지 않는다.
select sal from emp06 where job ='과장';
select ename, sal, job
from emp06
where sal >all (select sal from emp06 where job ='과장')
and job != '과장';


------------------------------------------------------------------------------------------------

--13강 도전 퀴즈
--1. 시퀀스
--2. CURRVAL: CURRENT VALUE의 약어로서 현재 값을 반환합니다.
--NEXTVAL: NEXT VALUE의 약어로서 다음 값이란 의미를 가지며, 현재 시퀀스 값의 다음 값을 반환합니다.
--3. 1 dept_no sequence의 현재 값
select dept_no.currval from dual;
--. Index
--5. 고유(Unique) Index
--6 idx_emp_empno삭제
drop index idx_emp_empno;
--7 seq_empno 시퀀스 삭제
drop sequence seq_empno;
