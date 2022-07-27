select * from tab;

select m.name from member m, bulletin b
where m.id = b.writer
and b.id = 5;

select * from member;

select * from notice;

select * from bulletin; --게시글

update bulletin
set hit = id;
insert into bulletin values(bulletin_seq.nextval, 'title', 'content', 'user1', sysdate, 0);

delete from bulletin where id > 5;

select notice_seq.currval from dual;

drop table product purge;
create table product (
 item_code varchar2(100) primary key, --상품코드
 item_name varchar2(1000), --상품명
 item_image varchar2(100),
 price number, --단가
 description varchar(3000), --상품설명
 like_it number, --좋아요
 sale char(1), --할인상품
 sale_price number
);

insert into product values('item001', '상품1', 'item01.png', 1000, '상품설명1', 4, 'Y', 800);
insert into product values('item002', '상품2', 'item01.png', 1600, '상품설명2', 4, 'Y', 800);
insert into product values('item003', '상품3', 'item01.png', 1900, '상품설명3', 3, 'N', 800);
insert into product values('item004', '상품4', 'item01.png', 2300, '상품설명4', 5, 'Y', 800);
insert into product values('item005', '상품5', 'item01.png', 2800, '상품설명5', 3, 'N', 800);
insert into product values('item006', '상품6', 'item01.png', 1200, '상품설명6', 5, 'Y', 800);
insert into product values('item007', '상품7', 'item01.png', 8900, '상품설명7', 4, 'N', 800);
insert into product values('item008', '상품8', 'item01.png', 2100, '상품설명8', 2, 'Y', 800);
insert into product values('item009', '상품9', 'item01.png', 2400, '상품설명9', 1, 'N', 800);
insert into product values('item0010', '상품10', 'item01.png', 2200, '상품설명10', 5, 'Y', 800);

select bulletin_seq.nextval from dual;
