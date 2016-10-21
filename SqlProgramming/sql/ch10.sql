--1021
--Section03 Equi Join(Inner Join)
--조인 대상이 되는 두 테이블에서 공통을로 존재하는 컬럼의 값.
--일치하는 행을 연결하여 결과를 생성하는 조인 방법
select * from employees;
select * from departments;

--101번 사원의 부서 이름은?
select employees.FIRST_NAME,employees.last_name,department_name,employee_id
from departments, employees
where employee_id=101 
and departments.department_id = employees.department_id;

-- ANSI Inner Join 문법(SQL 표준 문법)
select e.FIRST_NAME,e.last_name,department_name,employee_id
from departments d
inner join employees e
on d.department_id = e.department_id  -- on : 연결조건 
where employee_id=101;

--Sales 부서가 있는 도서는 
select department_name, city
from departments d, locations l
where d.location_id=l.location_id -- 연결 조건
and department_name='Sales';  -- 일반적인 조건

--ANSI Inner Join 문
select department_name, city
from departments d  --  d : departments 별칭
inner join locations l  -- l : locations 별칭
on d.location_id=l.location_id -- 연결 조건
where department_name='Sales';  -- 일반적인 조건 

--101번 사원의 부서 번호와 부서 이름
select e.department_id, department_name --e. 은 두테이블이 중복된 컬럼이 있으면 테이블명.컬럼명 명시!
from employees e
inner join departments d 
on d.DEPARTMENT_ID = e.DEPARTMENT_ID
where e.EMPLOYEE_ID = 101;

--101번 사원의 근무 도시는?
--* 테이블 개수 -1 개의 연결 조건문이 있어야 정상 실행
select city
from employees e, departments d, locations l
where e.DEPARTMENT_ID = d.DEPARTMENT_ID --연결조건
and d.location_id = l.LOCATION_ID       --연결조건
and e.EMPLOYEE_ID = 101;

select city
from employees e
inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID --연결조건
inner join locations l on d.location_id = l.LOCATION_ID       --연결조건
where e.EMPLOYEE_ID = 101;

--101번의 사원의 사번, first_name, 부서번호, 부서이름, 나라, 도시는?
select employee_id, first_name, last_name, e.department_id, department_name, country_name, city
from employees e, departments d, locations l, countries c
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
and d.LOCATION_ID = l.LOCATION_ID
and l.COUNTRY_ID = c.COUNTRY_ID
and e.EMPLOYEE_ID = 101;

--ANSI 문법
select employee_id, first_name, last_name, e.department_id, department_name, country_name, city
from employees e
inner join departments d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
inner join locations l on d.LOCATION_ID = l.LOCATION_ID
inner join countries c on l.COUNTRY_ID = c.COUNTRY_ID
where e.EMPLOYEE_ID = 101;

--Section04 Self Join(=Inner Join)
select e2.EMPLOYEE_ID, e2.first_name, e2.last_name
from employees e1, employees e2 -- 테이블명 호칭을 바꿔 같은 테이블의 컬럼명으로 join 할 수 있다.
where e1.MANAGER_ID = e2.EMPLOYEE_ID
and e1.employee_id = 101;

--ANSI Outter Join
create table member(
  mid varchar(10) primary key,
  mname varchar(10) not null
);
drop table lefttable;
drop table righttable;

create table board(
  bno number(5) primary key,  
  btitle varchar(100) not null,
  bwriter varchar(10) references lefttable(mid)
);

insert into member values('user1', '사용자1');
insert into member values('user2', '사용자2');
insert into member values('user3', '사용자3');
insert into member values('user4', '사용자4');
insert into member values('user5', '사용자5');

insert into board values(1, '제목1', 'user1');
insert into board values(2, '제목2', 'user2');
insert into board values(3, '제목3', 'user3');

--게시물을 한번도 작성하지 않은 멤버의 mid는 ?
--left outter join 왼쪽 테이블명에 있는 컬럼은 다 나옴. 오른쪽 테이블이 연결되있지 않은 컬럼은 null 처리
select mid, mname, bno, btitle
from member
left outer join board  
on member.mid = board.bwriter
where bno is null;

--right outter join 오른쪽 테이블명에 있는 컬럼은 다 나옴. 왼쪽 테이블이 연결되있지 않은 컬럼은 null 처리
select bno, btitle , mid, mname
from board
right outer join member   
on member.mid = board.bwriter
where bno is null;

--FULL OUTTER JOIN 두 테이블의 컬럼명이 모두 나옴
select mid, mname, bno, btitle
from member
full outer join board  
on member.mid = board.bwriter;

--[참고] 오라클에서만 사용
--left outter join
select mid, mname, bno, btitle 
from member, board
where member.mid=board.bwriter(+);--(+)가 달린 칼럼명에서 존재하지 않는 것은 행으로 추가하되 null로 넣어라
--right outter join
select mid, mname, bno, btitle 
from  board,member
where board.bwriter(+)=member.mid;--(+)가 달린 칼럼명에서 존재하지 않는 것은 행으로 추가하되 null로 넣어라