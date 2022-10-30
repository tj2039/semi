create table board
(
	no		        number		primary key,	--��ȣ
	name		varchar2(20)	not null,			--�̸�	
	pwd			varchar2(20)    not null,            --��й�ȣ
	title			varchar2(100)	 not null,			--����
	email		varchar2(80)    null,            --�̸���
	regdate 		date			default  sysdate,	--�ۼ���
	--regip		varchar2(15)	 null,			--�ۼ�IP
	readcount	number		default 0	 null,		--��ȸ��
	content		clob			null			--����
);

create sequence board_seq
increment by 1
start with 1
nocache;

select * from board;

insert into board(no,name,pwd,title,email,content)
values(board_seq.nextval,'ȫ�浿','hong123','�ȳ��ϼ���','hong@naver.com','�ȳ��ϼ���!');

commit;
rollback;
update board
set title=?,name=? ,email=?,content=?
where no=? and pwd=?;

delete from board
where no=7;

update board
set readcount=readcount+1
where no=1;

select * from board 
where title like '%�浿%';

select * from board 
where name like '%�ȳ�%';

select * from board 
where content like '%�ȳ�%';

insert into board
select board_seq.nextval,name,pwd,title,email,sysdate, readcount, content
from board;
select count(*) from board;
commit;