--1020
--Section04 유일한 값만 허용하는 UNIQUE 제약 조건
drop table member;
create table member(
  mid    varchar(10) unique not null,
  mname  varchar(10) not null,
  mage   number(3) null,
  memail  char(50) unique null,
  mbirth date null
);

insert into member values('user1', '사용자1', 25, 'user1@sw.com', sysdate);
insert into member values('user2', '사용자2', 25, 'user2@sw.com', sysdate);
insert into member values('user3', '사용자3', 25, null, sysdate);--null 은 unique에 해당이 되지 않는다.
insert into member values('user4', '사용자4', 25, null, sysdate);

--Section06 데이터 구분을 위한 PRIMARY KEY 제약 조건.
--UNIQUE + NOT NULL
--한 테이블당 1개만 설정 가능.(<=> unique는 여러번 사용 가능)
--행을 구별하는 식별값으로 사용.
drop table member;
create table member(
  mid    varchar(10) primary key,-- primary key 한테이블당 하나만 설정 가능
  mname  varchar(10) not null,
  mage   number(3) null,
  memail  char(50) unique null,
  mbirth date null
);
--not null과 null을 입력안할시 기본 null로 설정된다.

--Section07 참조 무결성을 위한 FOREIGN KEY(관계설정에서 나오는 키) 제약조건.
--외부 테이블의 PK값만 입력(들어갈수)할 수 있도록 함.
drop table board;
create table board(
  bno       NUMBER(10) primary key,
  btitle    varchar(100) not null,
  bcontent  varchar(4000) not null,
  bwriter   varchar(10) references member(mid), --references 외부table(컬럼명) => 외부에 있는 컬럼명 값(대부분 primary key값)을 참조 하는 것.
  bhitcount number(5) null,
  bdate     date null
);

insert into board values(1,'제목1','내용1','user1',0,sysdate);
insert into board values(1,'제목2','내용2','user1',0,sysdate);

--section08 CHECK 제약 조건
drop table member;
create table member(
  mid    varchar(10) primary key,-- primary key 한테이블당 하나만 설정 가능
  mname  varchar(10) not null,
  mage   number(3) check(mage>=0 and mage<150),
  msex varchar(10) check(msex in ('남자','여자')),
  memail  char(50) unique null,
  mbirth date null
);

insert into member values('user1', '사용자1', 25, '남자','user1@sw.com', sysdate);
insert into member values('user2', '사용자1', 200, '여자','user1@sw.com', sysdate);--check 제약 조건에 위배됨. (null도 포함.)
insert into member values('user3', '사용자1', null, null,'user1@sw.com', sysdate);
insert into member values('user4', '사용자1', 30, '중성','user1@sw.com', sysdate);

--Section09 DEFAULT 제약조건
drop table board;
create table board(
  bno       NUMBER(10) primary key,
  btitle    varchar(100) not null,
  bcontent  varchar(4000) not null,
  bwriter   varchar(10) not null,
  bhitcount number(5) default 0,
  bkind     varchar(15) default '자유',
  bdate     date null
);

insert into board values(1,'제목1','내용1','user1',0,'자유',sysdate);
insert into board values(2,'제목2','내용2','user2',default,default,sysdate);

insert into board(bno, btitle, bcontent, bwriter)
values(3, '제목3', '내용3', 'user3'); --default값을 지정한 컬럼은 default값이 들어감

--Section05 컬럼 레벨로 제약 조건 설정 => 컬럼을 만들때 제약조건 설정
drop table board;   --foreign 설정되있는 테이블 명부터 지움
drop table member;  --primary 키는 그다음에 지움.

create table member(
  mid varchar(10) constraint pk_member_mid primary key,  --constraint 변경이름 제약조건에 이름 붙힘.
  mage varchar(10) constraint ch_member_mage check (mage>=0 and mage<150)
);

create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwrite varchar(10) constraint fk_board_bwriter REFERENCES member(mid)
);

--Section10 테이블 레벨로 제약 조건 설정 => 컬럼을 다 만들고 제약조건 설정
create table member(
  ssn1 varchar(6) not null, --not null은 컬럼정의시 필수!
  ssn2 varchar(7) not null,
  mage varchar(10) not null,
  constraint pk_member_ssn primary key(ssn1,ssn2), --constraint pk_member_ssn primary key(ss1,ss2) 두개의 컬럼을 묶어서 하나의 primary key로 만듬. (ss1,ss2) => 복합키 
  constraint ch_member_mage check (mage>=0 and mage<150)
);

create table board(
  bno number(10), 
  bwrite varchar(10), 
  constraint pk_board_bno primary key (bno),
  constraint fk_board_bwriter FOREIGN key(bwrite) REFERENCES member(mid) --테이블 레벨에서는 foreign key가 될 컬럼명 지정
);

--Section11 제약 조건 변경하기
-- 제약 조건 추가하기
drop table member;
create table member(
  ssn1 varchar(6) not null, --not null은 컬럼정의시 필수!
  ssn2 varchar(7) not null,
  mage varchar(10) not null
);
alter table member
 add constraint pk_member_ssn primary key(ssn1,ssn2); -- add에 컬럼, 제약조건 추가 가능
 
alter table member
 add constraint ch_member_mage check (mage>=0 and mage<150);
 
create table board(
  bno number(10), 
  bwriter varchar(10)
);

alter table board
 add constraint pk_board_bno primary key (bno);
 
alter table board
 add constraint fk_board_bwriter FOREIGN key(bwriter) REFERENCES member(mid);

-- 제약 조건 제거하기
drop table board;
drop table member;
create table member(
  ssn1 varchar(6) not null, --not null은 컬럼정의시 필수!
  ssn2 varchar(7) not null,
  mage varchar(10) not null,
  constraint pk_member_ssn primary key(ssn1,ssn2), --constraint pk_member_ssn primary key(ss1,ss2) 두개의 컬럼을 묶어서 하나의 primary key로 만듬. (ss1,ss2) => 복합키 
  constraint ch_member_mage check (mage>=0 and mage<150)
);

alter table member
drop primary key; --테이블의 primary key 제거

alter table member
drop constraint ch_member_mage; -- 테이블 foreign 제거

--Section12 제약조건의 비활성화와 CASCADE
drop table board;   --foreign 설정되있는 테이블 명부터 지움
drop table member;  --primary 키는 그다음에 지움.

create table member(
  mid varchar(10) constraint pk_member_mid primary key,  --constraint 변경이름 제약조건에 이름 붙힘.
  mage varchar(10) constraint ch_member_mage check (mage>=0 and mage<150)
);

create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwrite varchar(10) constraint fk_board_bwriter REFERENCES member(mid)
);

--제약조건의 비활성화
alter table board disable primary key;--비활성화

--제약조건의 활성화
alter table board enable primary key; --활성화

--CASCADE
alter table member disable primary key cascade; --cascade 계단식, 지정한 테이블의 primary key와 해당 테이블을 참조(foreign)를 하고 있는 모든 테이블이 비활성화 된다.
alter table member enable primary key;
alter table board enable constraint fk_board_bwriter;
 
--ON DELETE CASCADE
delete from board where bwrite='user1';
delete from member where mid='user1';

drop table board;   --foreign 설정되있는 테이블 명부터 지움
drop table member;  --primary 키는 그다음에 지움.

create table member(
  mid varchar(10) constraint pk_member_mid primary key,  --constraint 변경이름 제약조건에 이름 붙힘.
  mage varchar(10) constraint ch_member_mage check (mage>=0 and mage<150)
);

create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwriter varchar(10) constraint fk_board_bwriter REFERENCES member(mid) on delete cascade --on delete cascade PK가 삭제가 될때 자동적으로 FK가 삭제될 수 있도록 하는 조건
);

insert into member values('user1',25);
insert into board values(1,'user1');
insert into board values(2,'user1');

delete from member where mid='user1';

