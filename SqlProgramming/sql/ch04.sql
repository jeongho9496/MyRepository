--1018
--Section01 그룹함수
--사원들의 전체 봉급의 합
select sum(sal) from emp;
--월급을 가장 많이 받아가는 사원의 정보
select * from emp where sal = (select max(sal) from emp); --서브 쿼리 사용 서브쿼리 안에서 최대 값을 구함.
select * from emp where sal = (select min(sal) from emp); --서브 쿼리 사용 서브쿼리 안에서 최대 값을 구함. 그룹 함수는 select 앞에만 올수 있다. where 절에 올수 없음
--평균 월급 보다 많이 받아가는 사원의 정보
select * from emp where sal > (select avg(sal) from emp);
--전체 사원의 수 = 전체 행수
select count(*) from emp;--전체 행수 count
select count(empno) from emp;--empno 총 갯수
select count(comm) from emp;--comm 총 갯수 null은 count되지 않음.
--평균 월급 보다 많이 받아가는 사원의 수
select count(*) from emp where sal > (select avg(sal) from emp);

--그룹함수와 NULL값
--그룸함수와 단순 컬럼
select avg(comm) as from emp;--null값 제거 하여 값이 있는 테이블끼리 평균을 구함.
select sum(comm)/count(*) from emp;
select sum(comm)/count(comm) from emp;--전체의 사원수로 평균값구할애 사용
--사원의 직급 개수?
select count(DISTINCT(job)) from emp;

--Section02 데이터 그룹 : group by 절
--부서별로 평균 봉급은?
select deptno, sal from emp order by deptno;
select deptno, round(avg(sal),1) from emp group by deptno;--group by 뒤에 있는 컬럼은 반드시 select 뒤에 나와야 한다. select 그룹핑 컬럼 + 집계함수 from emp group by 그룹핑 컬럼
--직급별 평균 봉급
select job, round(avg(sal),1) from emp group by job;--group by 뒤에 있는 컬럼은 반드시 select 뒤에 나와야 한다. select 그룹핑 컬럼 + 집계함수 from emp group by 그룹핑 컬럼
--부서별(1차 그룹핑) 직급별(2차그룹핑) 평균 봉급은?
select deptno, job, avg(sal) from emp group by deptno, job order by deptno,avg(sal) desc;

--Section03 그룸 결과 확인 : HAVING절
--부서의 평균 봉급이 500 이상인 부서 번호와 평균 봉급은?
select deptno, avg(sal) from emp group by deptno having avg(sal)>500; --where 절에 집계 함수를 작성할 수 없다.
--그룹핑전의 조건 where
--그룹핑후의 조건 having
--사원 중에서(where) 부서별(그룹핑) 평균 봉급이 300이상인(having) 부서와 평균 봉급(select문)은? (시험)
select deptno,avg(sal) from emp where job='사원' group by deptno having avg(sal)>=300; --group by 앞에 where절이 올수 있다.
--사원 중에서(where) 부서별(그룹핑) 평균 봉급이 300이상인(having) 부서와 평균 봉급(select문)및 수는? (시험)
select deptno,avg(sal),count(empno)as 사원수 from emp where job='사원' group by deptno having avg(sal)>=300; --group by 앞에 where절이 올수 있다.
--급여 총액이 1000이상인(having) 직급(group by)에 대해서 직급과 급여 총액(select)을 표시하되 직급이 사원인 사람은 제외(where)시킨 후 급여 총액에 따라 정렬(order by)하시오(시험)
select job,sum(sal) 
from emp 
where job <> '사원' 
group by job
having sum(sal)>=1000 
order by sum(sal) desc;

select job,sum(sal)as salary 
from emp 
where job not like '%사원%' 
group by job
having sum(sal)>=1000 
order by salary desc;



