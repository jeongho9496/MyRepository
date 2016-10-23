--1019
--Ch08: DML(Data Manipulation Language) - 데이터 관련 명령어 => 저장(insert), 수정(update), 삭제(delete), 조회(select)
--cf:   DDL(Data Definition Language) - 데이터 베이스 객체와 관련된 명령어 => 생성(create), 삭제(drop), 수정(alter))
--      DCL(Data Control Language) - 권한 및 사용자와 관련된 명령어 => 권한할당(grant), 권한삭제(revoke), 작업반영(commit), 작업취소(rollback)

--Section01 테이블에 내용을 추가하는 INSERT문
INSERT INTO MEMBER(MID, MNAME, MAGE, MBIRTH) 
VALUES('user3','사용자3',10,'2006.5.15');

INSERT INTO MEMBER(MID, MNAME) --조건이 not null인 부분은 무조건 삽입 해야함
VALUES('user4','사용자4');

insert into member values('user5','사용자5',null,null);--member에 매개값없으면 values는 not null 부분도 순서대로 나와야 한다.
insert into member values('user5','사용자5',10,'2006.10.06');

insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate)--데이터 값을 넣을 컬럼명 명시
values(4,'제목4','내용4','user2',0,sysdate);--데이터에 넣을 값

insert into board(bno, btitle, bcontent, bwriter) 
values(5,'제목5','내용5','user3');--한개의 행만 삽입할 수 있다. 삽입 성공시 1을 리턴, 삽입 실패시 예외

--Section02 테이블의 내용을 수정하는 UPDATE문
update member set mage=10 where mid='user4';--alter와 다름
update member set mage=20, mbirth='2001.08.10' where mid='user5';--alter와 다름
update member set mage=20, mbirth='2001.08.10' where mid='user5';--반드시 where절과 같이 사용한다.
update member set mage=mage+1 where mid='user4';--alter와 다름

--Section03 테이블의 내용을 삭제하는 DELETE문
delete member where mid='user5';
delete member where mage <= 20;

--Section04 트랜잭션 관리
create table account(
  ano varchar(20) not null,
  abalance number(10) null
);

insert into account(ano, abalance) values('111-111',10000000);
insert into account(ano, abalance) values('111-112',0);
commit;

--계좌이체: 출금작업 + 입금작업--> 트랜잭션 작업 = All or Nothing
    --출금작업
    update account set abalance=abalance-10000 where ano = '111-111';
    --입금작업
    update account set abalance=abalance+10000 where ano = '111-113';

--출금은 성공했으나, 입금이 실패했기 때문에 전체를 실패처리 해야함.
rollback;

--출금도 성공했고, 입금도 성공했다면 전체를 영구반영 처리해야함.
commit;


