--sys�� system �������� �α����ؼ� ����� ����, ���̺����̽� �����ϱ�
--sqlplus "/as sysdba  ==>�ý���dba����

--���̺� �����̽� ����
create tablespace herbmall
datafile 'C:\oraclexe\mydata\herbmall.dbf' size 48m
autoextend on next 10m;

/*
--���̺� �����̽� ����
drop tablespace herbmall including contents and datafiles;
*/

alter session set "_ORACLE_SCRIPT"=true; 

--����� ���� ����
create user herb
identified by herb123
default tablespace herbmall;

--����� ���Ѻο�
grant connect,resource to herb;
--grant connect, dba to herb with admin option;

--�� ���� ���� �ο��ϱ�
grant create view to herb;

grant unlimited tablespace to herb;  --���̺����̽��� ���� ���� �ο�


//
--sys�� system �������� �α����ؼ� ����� ����, ���̺����̽� �����ϱ�
--sqlplus "/as sysdba  ==>�ý���dba����

--���̺� �����̽� ����
create tablespace javauser
datafile 'C:\oraclexe\mydata\javauser.dbf' size 48m
autoextend on next 10m;

/*
--���̺� �����̽� ����
drop tablespace herbmall including contents and datafiles;
*/

alter session set "_ORACLE_SCRIPT"=true; 

--����� ���� ����
create user javauser
identified by javauser123
default tablespace javauser;

--����� ���Ѻο�
grant connect,resource to javauser;
--grant connect, dba to herb with admin option;

--�� ���� ���� �ο��ϱ�
grant create view to javauser;

grant unlimited tablespace to javauser;  --���̺����̽��� ���� ���� �ο�
