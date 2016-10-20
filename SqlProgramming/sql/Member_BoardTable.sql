--1020
--Table정리
CREATE TABLE board
  (
    bno       NUMBER (10) NOT NULL ,
    btitle    VARCHAR2 (100) NOT NULL ,
    bcontent  VARCHAR2 (4000) NOT NULL ,
    bwriter   VARCHAR2 (10) NOT NULL ,
    bhitcount NUMBER (5) ,
    bdate     DATE
  ) ;
ALTER TABLE board ADD CONSTRAINT pk_board_bno PRIMARY KEY ( bno ) ;
CREATE TABLE member
  (
    mid       VARCHAR2 (10) NOT NULL ,
    mname     VARCHAR2 (10) NOT NULL ,
    mpassword VARCHAR2 (15) NOT NULL ,
    mage      NUMBER (3) ,
    mbirth    DATE
  ) ;
ALTER TABLE member ADD CONSTRAINT pk_member_mid PRIMARY KEY ( mid ) ;
ALTER TABLE board ADD CONSTRAINT fk_board_bwriter FOREIGN KEY ( bwriter ) REFERENCES member ( mid ) ON
DELETE CASCADE ;
