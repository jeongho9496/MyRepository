--1018
--Section01 테이블 구조를 만드는 CREATE TABLE문
create table member(  --테이블 선언부
  --컬럼 정의
  mid varchar(10) not null,  -- varchar(var:variable + char ) => 데이터 크기가 동적으로 변경될 때 사용 char => 크기가 고정일때 사용(ex. 주민등록 번호) *varchar생성하면 내부적으로 varchar2생성
  mname varchar(10) not null,-- ms949는 한글이 2byte  =>varchar(10) 5글자. utf-8은 3byte  =>varchar(10)3글자
  mage number(3,0) null, -- number(3,0) (정수부분, 소수부분)
  mbirth date null
);
--중요한 데이터 타입 교재 p.39 참고

--게시판 테이블 생성
create table board(
  bno NUMBER(10) not null,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) not null,
  bhitcount number(5) null,
  bdate date null
);

--Section02 테이블의 구조를 변경하는 ALTER TABLE 문
--컬럼 추가
alter table member add email varchar(100) null;
--컬럼 수정
alter table member modify email varchar(50);
--컬럼 삭제
alter table member drop column email;

--Section03 테이블명을 변경하는 RENAME문
alter table member2 rename to member;

--Section04 테이블 삭제하는 DROP TABLE문
drop table member;
drop table board;

select * from member where mid = 'user1';
select * from board where bno = '1';

