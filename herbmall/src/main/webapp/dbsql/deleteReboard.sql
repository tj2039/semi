--deleteReboard.sql
--exec deleteReboard(1);
create or replace procedure deleteReboard --���ν��� �̸� 
(
--�Ű�����
    m_no  number
)
is
--���������
    cnt number;
    v_groupNo   number;
    v_step  number;
begin
--�亯�� �ִ� �������� ��쿡�� ���ڵ带 �������� ���� DelFlag = Y �� update
select step, groupno into v_step, v_groupNo
from reboard
where no=m_no;

    --�������� ���
    if v_step=0 then
        --�亯���� �����ϴ��� üũ
        select count(*) into cnt
        from reboard
        where groupno=v_groupNo;
        
        --�亯���� �����Ѵٸ�
        if cnt>1 then
            update reboard
            set delflag='Y'
            where no=m_no;
        else --�亯���� ���� ���
            delete from reboard
            where no=m_no;
        end if;
    else  --�亯���� ���
        delete from reboard
        where no=m_no;
    end if;
    
    commit;
EXCEPTION
    WHEN OTHERS THEN
   raise_application_error(-20001, '�� ���� ����!');
        ROLLBACK;
end;