--사원의 이름과 급여와 입사일자만을 출력하기
select ename, sal, hiredate from emp;
--컬럼이름에 별칭을 지정하기
select ename 이름, sal 급여, hiredate as 입사일자 from emp;
--직급을 중복하지 않고 한 번씩 나열하기
select distinct job 직급 from emp;
--급여가 300이하인 사원의 사원번호, 사원 이름, 급여를 출력하기
select deptno, ename, sal from emp where sal<=300;
--이름이 "오지호인" 사원의 사원번호, 사원명, 급여를 출력하기
select deptno, ename, sal from emp where ename='오지호';
--급여가 250이거나, 300이거나, 500인 사원들의 사원 번호와 사원명과 급여를 검색하기
select deptno, ename, sal from emp where sal in(250, 300, 500);
--급여가 250, 300, 500도 아닌 사원들을 검색하기
select deptno, ename, sal from emp where sal not in(250, 300, 500);
--LIKE 연산자와 와일드카드를 사용하여 사원들 중에서 이름이 "김"으로 시작하는 사람과 이름 중에 "기"를 포함하는 사원의 사원번호와 사원이름을 출력하기
select deptno, ename, sal from emp where ename like '김%' or ename like '%기%';
--상급자가 없는 사원 검색하기
select job, ename from emp where mgr is null;
--사원 테이블에서 최근 입사한 직원 순으로 사원번호, 사원명, 직급, 입사일 컬럼만 출력하기
select deptno, ename, job, hiredate from emp order by hiredate desc;
--부서번호가 빠른 사원부터 출력하되, 같은 부서 내의 사원을 출력할 경우, 입사한지 가장 오래된 사원부터 출력하기
select deptno, ename,hiredate from emp order by deptno, hiredate;