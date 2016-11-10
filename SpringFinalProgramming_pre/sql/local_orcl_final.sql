-- 생성자 Oracle SQL Developer Data Modeler 4.1.5.907
--   위치:        2016-10-26 12:27:43 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g




CREATE TABLE freeboard
  (
    bno    NUMBER (10) NOT NULL ,
    btitle VARCHAR2 (100) NOT NULL ,
    bcontent CLOB NOT NULL ,
    bwriter   VARCHAR2 (15) NOT NULL ,
    bhitcount NUMBER (5) NOT NULL ,
    bdate     DATE NOT NULL
  ) ;
ALTER TABLE freeboard ADD CONSTRAINT freeboard_PK PRIMARY KEY ( bno ) ;


CREATE TABLE member
  (
    mid       VARCHAR2 (15) NOT NULL ,
    mname     VARCHAR2 (20) NOT NULL ,
    mpassword VARCHAR2 (15) NOT NULL ,
    maddress  VARCHAR2 (100) ,
    mtel      VARCHAR2 (15) NOT NULL ,
    memail    VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE member ADD CONSTRAINT member_PK PRIMARY KEY ( mid ) ;


CREATE TABLE photoboard
  (
    bno    NUMBER (10) NOT NULL ,
    btitle VARCHAR2 (100) NOT NULL ,
    bcontent CLOB NOT NULL ,
    bwriter      VARCHAR2 (15) NOT NULL ,
    bhitcount    NUMBER (5) NOT NULL ,
    bdate        DATE NOT NULL ,
    originalfile VARCHAR2 (50) NOT NULL ,
    savedfile    VARCHAR2 (50) NOT NULL ,
    minetype     VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE photoboard ADD CONSTRAINT photoboard_PK PRIMARY KEY ( bno ) ;


ALTER TABLE freeboard ADD CONSTRAINT freeboard_member_FK FOREIGN KEY ( bwriter ) REFERENCES member ( mid ) ;

ALTER TABLE photoboard ADD CONSTRAINT photoboard_member_FK FOREIGN KEY ( bwriter ) REFERENCES member ( mid ) ;


-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
