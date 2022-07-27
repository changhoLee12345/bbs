select * from tab;

select m.name from member m, bulletin b
where m.id = b.writer
and b.id = 5;

select * from member;

select * from notice;

select * from bulletin; --�Խñ�

update bulletin
set hit = id;
insert into bulletin values(bulletin_seq.nextval, 'title', 'content', 'user1', sysdate, 0);

delete from bulletin where id > 5;

select notice_seq.currval from dual;

drop table product purge;
create table product (
 item_code varchar2(100) primary key, --��ǰ�ڵ�
 item_name varchar2(1000), --��ǰ��
 item_image varchar2(100),
 price number, --�ܰ�
 description varchar(3000), --��ǰ����
 like_it number, --���ƿ�
 sale char(1), --���λ�ǰ
 sale_price number
);

insert into product values('item001', '��ǰ1', 'item01.png', 1000, '��ǰ����1', 4, 'Y', 800);
insert into product values('item002', '��ǰ2', 'item01.png', 1600, '��ǰ����2', 4, 'Y', 800);
insert into product values('item003', '��ǰ3', 'item01.png', 1900, '��ǰ����3', 3, 'N', 800);
insert into product values('item004', '��ǰ4', 'item01.png', 2300, '��ǰ����4', 5, 'Y', 800);
insert into product values('item005', '��ǰ5', 'item01.png', 2800, '��ǰ����5', 3, 'N', 800);
insert into product values('item006', '��ǰ6', 'item01.png', 1200, '��ǰ����6', 5, 'Y', 800);
insert into product values('item007', '��ǰ7', 'item01.png', 8900, '��ǰ����7', 4, 'N', 800);
insert into product values('item008', '��ǰ8', 'item01.png', 2100, '��ǰ����8', 2, 'Y', 800);
insert into product values('item009', '��ǰ9', 'item01.png', 2400, '��ǰ����9', 1, 'N', 800);
insert into product values('item0010', '��ǰ10', 'item01.png', 2200, '��ǰ����10', 5, 'Y', 800);

select bulletin_seq.nextval from dual;
