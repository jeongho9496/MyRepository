--02도전퀴즈
--02 급여를 400에서 500사이 받는 사원을 조회하기 위한 표현.
select * from emp where sal between 400 and 500;

--07 사원번호를 기준으로 내림차순으로 정렬하여, 사원번호와 사원명 컬럼을 출력
select empno, ename
from emp
ORDER BY empno desc;

--08 select 명령문 사용 시 중복되는 데이터를 제외하고 출력하라는 뜻
select DISTINCT sal
from emp
ORDER BY sal asc;

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

--6 오늘을 기준으로 100일 후의 날짜를 출력
select sysdate+100 from dual;
--7. 오늘 속한 달의 마지막 날 출력
select last_day(sysdate) from dual;

--04 도전 퀴즈
--4
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 500;

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

--08도전 퀴즈
--1,2
create table dept01(
  deptno NUMBER(2),
  dname VARCHAR2(14),
  loc VARCHAr(13)
);
insert into dept01 values(60, '생산부','포천');
insert into dept01(deptno, dname) values(60, '개발부');

--10 도전 퀴즈
--2.
SELECT ename
from emp member, emp manager
where member.empno = manager.empno;

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

--11강 도전 퀴즈
--2. 
select ename, sal from emp where sal > (select min(sal) from emp);
--3. 급여가 500이 넘는 사원과 같은 부서에 근무하는 직원을 조회하는 쿼리문을 완성하기 위해서 들어갈 수 없는 것
select ename, sal, deptno
from emp
where deptno in(select distinct deptno from emp where sal>500);
--5??
update table (emp)
set sal=sal+100
where deptno = (select deptno from dept where deptno=10);

--7
create table emp06
as select * from emp;

--8
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

--3
select dept_no.currval from dual;

--6 idx_emp_empno삭제
drop index idx_emp_empno;

--7 seq_empno 시퀀스 삭제
drop sequence seq_empno;
