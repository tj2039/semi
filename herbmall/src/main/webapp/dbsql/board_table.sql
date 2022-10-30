create table board
(
	no		        number		primary key,	--번호
	name		varchar2(20)	not null,			--이름	
	pwd			varchar2(20)    not null,            --비밀번호
	title			varchar2(100)	 not null,			--제목
	email		varchar2(80)    null,            --이메일
	regdate 		date			default  sysdate,	--작성일
	--regip		varchar2(15)	 null,			--작성IP
	readcount	number		default 0	 null,		--조회수
	content		clob			null			--내용
);

create sequence board_seq
increment by 1
start with 1
nocache;

select * from board;

insert into board(no,name,pwd,title,email,content)
values(board_seq.nextval,'홍길동','hong123','안녕하세요','hong@naver.com','안녕하세요!');

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
where title like '%길동%';

select * from board 
where name like '%안녕%';

select * from board 
where content like '%안녕%';

insert into board
select board_seq.nextval,name,pwd,title,email,sysdate, readcount, content
from board;
select count(*) from board;
commit;