CREATE TABLE bbs_member (
 id varchar2(10) PRIMARY KEY,
 name varchar2(100),
 password varchar2(30),
 address varchar2(100),
 tel varchar2(20),
 enterdate DATE,
 author varchar2(100)
);

CREATE TABLE bbs_notice(
 ntc_no NUMBER primary key
 ,ntc_title VARCHAR2(300)
 ,ntc_from_date DATE
 ,ntc_to_date DATE
 ,ntc_reg_date DATE
 ,ntc_content VARCHAR2(1000));
