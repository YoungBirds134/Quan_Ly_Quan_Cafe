CREATE TABLE LOGIN
(
TAIKHOAN CHAR(20) PRIMARY KEY,
MATKHAU CHAR(20)
)


CREATE TABLE BAN
(
SOBAN INT PRIMARY KEY,
TINHTRANG INT CHECK(TINHTRANG=0 OR TINHTRANG=1)
)


CREATE TABLE THUCUONG
(
MADU CHAR(10) ,
TENDU VARCHAR2(50)PRIMARY KEY,
DONGIA INT,
SOLUONGTON INT CHECK (SOLUONGTON>=0)
)


--------------------------------------

CREATE TABLE HOADON
(
MAHOADON NUMBER,
TINHTRANG NUMBER,
TONGTIEN NUMBER,
CONSTRAINT Movie_pk PRIMARY KEY (MAHOADON)
)
------------------------------------
CREATE SEQUENCE AUTO_INCREMENT_SEQUENCE
START WITH 1
INCREMENT BY 1;
-------------TAO_TRIGGER--------------------
CREATE OR REPLACE TRIGGER AUTO_INCREMENT_TRIGGER
BEFORE INSERT ON
HOADON
REFERENCING NEW AS NEW
    FOR EACH ROW BEGIN SELECT
    AUTO_INCREMENT_SEQUENCE.NEXTVAL INTO :NEW.MAHOADON
    FROM DUAL;
END;
/
--------------------------------
CREATE TABLE CHITIETHOADON
(
MAHD NUMBER,
SOBAN CHAR(10),
TENDU VARCHAR2(50),
SOLUONG INT CHECK (SOLUONG>=0),

PRIMARY KEY(MAHD,TENDU,SOLUONG)
)
TRUNCATE table hoadon
TRUNCATE table chitiethoadon
select * from hoadon
select * from CHITIETHOADON
select * from THUCUONG
select * from LOGIN
select * from BAN
-------------------------------------------------------INSERT--------------------------
INSERT INTO LOGIN
(TAIKHOAN,MATKHAU)
VALUES
('admin','admin');
INSERT INTO LOGIN
(TAIKHOAN,MATKHAU)
VALUES
('long','123');
INSERT INTO LOGIN
(TAIKHOAN,MATKHAU)
VALUES
('huy','123');
INSERT INTO LOGIN
(TAIKHOAN,MATKHAU)
VALUES
('xuan','123');
-------------------------------------
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES(1,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(2,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(3,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(4,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(5,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(6,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(7,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(8,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(9,0);
INSERT INTO BAN (SOBAN,TINHTRANG)
VALUES
(10,0);

-------------------------------------------------
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU001','CAFE DEN',15000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU002','SODA BAC HA',20000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU003','SODA VIET QUAT',20000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU004','SODA CHANH DAY',15000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU005','TRA SU TRAN CHAU DUONG DEN',20000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU006','NUOC CAM EP',10000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU007','NUOC DUA',12000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU008','SINH TO VIET QUAT',8000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU009','BAC SIU',15000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU0010','TRA TRAI CAY',12000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU0011','KHOAI MON MIX SUA DUA',20000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU0012','HONG TRA',15000,20);
INSERT INTO THUCUONG(MADU, TENDU, DONGIA, SOLUONGTON)
VALUES('DU0013','NUOC EP CAROT',12000,20);

---------------------------------------------
INSERT INTO HOADON(MAHOADON,TINHTRANG,TongTien)
values(null,1,20000)
------------------------------------
select soban,chitiethoadon.tendu,soluong,dongia 
from CHITIETHOADON,HOADON,THUCUONG
where CHITIETHOADON.TENDU and chitiethoadon.mahd=hoadon.mahoadon and hoadon.tinhtrang=0
----------------KIEM_TRA_SESION--------------------------
SELECT b.sid,
       b.serial#,
       a.spid processid,
       b.process clientpid
  FROM v$process a, v$session b
 WHERE a.addr = b.paddr AND b.audsid = USERENV ('sessionid');
 --------------
 SELECT b.sid,    b.serial#,    a.spid processid,   b.process clientpid FROM v$process a, v$session b WHERE a.addr = b.paddr AND b.audsid = USERENV ('sessionid');
 -------------------KIEM_TRA_POLICY_HIEN_CO-------------------------------------------------------
 Select * from dba_audit_policies;
 ---------------------------------
 show parameter audit;
 select * from dba_audit_trail;
 ---------TAO_POLICY------------------
begin 
dbms_fga.add_policy(
object_schema => 'admin',
object_name => 'Login',
policy_name=>'fga_Login',
statement_types =>'select,insert,delete'
);
end;


---------
begin 
dbms_fga.add_policy(
object_schema => 'admin',
object_name => 'ThucUong',
policy_name=>'fga_THUCUONG',
statement_types =>'select,insert,delete'
);
end;
begin 
dbms_fga.add_policy(
object_schema => 'admin',
object_name => 'HOADON',
policy_name=>'fga_HOADON',
statement_types =>'select,insert,delete'
);
end;
begin 
dbms_fga.add_policy(
object_schema => 'admin',
object_name => 'CHITIETHOADON',
policy_name=>'fga_CHITIETHOADON',
statement_types =>'select,insert,delete'
);
end;
------------------KIEM_TRA_AUDIT----------------
column username format a9;column owner format a5;column obj_name format a10;column action_name format a11;column sql_text format a40;
select username, owner, obj_name,action_name, sql_text ,extended_timestamp from dba_audit_trail;
select * from dba_audit_trail;
---------------------------------------------------
select owner,table_name, tablespace_name from dba_tables where owner ='ADMIN' or owner='SYS';
---
select * from dba_tables where tablespace_name='VD2' ;
-------------XEM_DATA_FILE----------------------
select file_name,file_id,tablespace_name from DBA_DATA_FILES
------------------XEM_USER--------------------------------
select username, created,expiry_date, account_status,last_login,Profile from dba_users where username='OE'
--------------------
select * from dba_users where account_status ='OPEN'
--------
SELECT * FROM user_sys_privs;
-------
SELECT * FROM DBA_TAB_PRIVS where owner='ADMIN';
------------
SELECT username,user_id FROM dba_users where account_status='OPEN' 
SELECT * FROM USER_TAB_PRIVS;
SELECT * FROM USER_ROLE_PRIVS;
---------------------------------------
select * from dba_directories where directory_name='DATA_PUMP_DIR'
--------
expdp sys/sys dumpfile=abv.dpdmp;