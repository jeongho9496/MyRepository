--1021
--Section01 서브쿼리의 기본 개념

--단일행 서브 쿼리
--이문세 사원의 부서 이름은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');

--테이블간의 데이터를 연결(Join문으로 변경가능)
--서브쿼리가 속도가 더 빠름 값만 얻어서 넘김 행이 많으면 많을 수록 속도가 느려짐
select dname
from emp, dept
where emp.deptno = dept.deptno
and emp.ename = '이문세';

--최저 봉급을 받아가는 사원의 정보는 ?
select *
from emp
where sal=(select min(sal) from emp);

--평균봉급 이상을 받아가는 사원의 수는?
select count(*)
from emp
where sal>=(select avg(sal) from emp);

--Section02 다중행 서브 쿼리
--서울에 근무하는 사원의 이름은 ? (시험)
select ename
from emp
where deptno in (select deptno from dept where loc='서울');
--한개의 행이 나오면 안되기에(다중 값) in을 사용하여 반복을 돌린다.

--EXITSTS 연산자(시험)
--사원이 1명도 존재하지 않는 부서의 이름은?
select dname
from dept
where exists (select * from emp where emp.deptno=dept.deptno);

--사원이 1명이라도 존재하는 부서의 이름은?
select dname
from dept
where not exists (select * from emp where emp.deptno=dept.deptno);


select dname, empno
from emp
left outer join dept
on dept.DEPTNO = emp.deptno
where empno is null;

select dname
from dept
where not dname in(
  select distinct dname
  from emp e, dept d
  where d.deptno=e.deptno
);

--Section03 
--emp 테이블 복제해서 emp2로 만드세요?(DDL로만 작성하시오)
--제약조건(PK, FK, Check, not null)은 복제가 안됨, 인덱스 또한 복제가 안됨.
create table emp2
as
select * from emp;

--emp 테이블의 구조만 복제해서 emp3로 만드세요
--제약조건과 인덱스는 복하지 않아도 됨.
create table emp3
as
select * from emp where 1=0;
select * from emp3;

--서브쿼리로 데이터를 삽입하기
--emp3을 만들었다면 10번 부서의 사원들만 복사하세요
insert into emp3 
select * from emp where deptno=10;

--서브쿼리를 이용한 데이터 변경
update dept set loc=(select loc from dept where deptno=40)  where deptno = 20;

--서브쿼리를 이용한 데이터 삭제
--영업부서의 사원을 삭제하세요.
delete emp where deptno=(select deptno from dept where dname='영업부');