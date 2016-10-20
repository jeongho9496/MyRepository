--1020
--Section01 시퀀스 생성
create sequence seq_1;
--다음 수 얻기
select seq_1.nextval from dual;
--현재부여된 번호
select seq_1.currval from dual;

--시퀀스 옵션 설정
create sequence seq_2
  start with 101  --처음시작
  increment by 10 --10씩증가
  maxvalue 1000   --최대값
  nocycle         --다시 돌아가지 않는다.
  nocache;        --메모리에 미리 저장?
  
select seq_2.nextval from dual;

drop sequence seq_1;--create로 생성한것은 drop으로 지운다.
drop sequence seq_2;
drop sequence seq_3;

--Section04 인덱스 개요 조회를 빠르게 하기 위해 (cost 차이가 남) where 절에서 조건이 많이 쓰일때 해당 컬럼에 인덱스를 적용시키는게 효율적 ex)게시판 검색 내용, 사용자, 제목 컬럼에 인덱스를 걸어 놓으면 좋음.
set timing on;
select * from board where btitle like '%9333%';
--db에서 하나씩 내려가며 해당 데이터를 찾는다.

create index idx_board_btitle on board(btitle);
--create index 중복 허용 할 때 만듬
select * from board where btitle like '%9333%';
drop index idx_board_btitle;

select * from board where bno = 9333;

create unique index seq_board_bno on board(bno);
--create unique index 중복 허용 하지 않을 때 만듬 (primary key 나 unique 설정시 자동 생성)
select * from board where bno = 9333;
drop index seq_board_bno;