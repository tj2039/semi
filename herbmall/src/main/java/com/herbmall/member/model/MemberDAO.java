package com.herbmall.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.herbmall.db.ConnectionPoolMgr2;


public class MemberDAO {
	private ConnectionPoolMgr2 pool;
	
	public MemberDAO() {
		pool=new ConnectionPoolMgr2();
	}
	
	public int insertMem(MemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2
			con=pool.getConnection();
			
			//3
			String sql="insert into member(no,userid,name,pwd,email,hp,zipcode,address,addressDetail)"
					+ " values(member_seq.nextval, ?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getUserid());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getHp());
			ps.setString(6, vo.getZipcode());
			ps.setString(7, vo.getAddress());
			ps.setString(8, vo.getAddressDetail());
			
			int cnt=ps.executeUpdate();
			
			if(cnt>0) {
				System.out.println("회원등록 성공");
			}else {
				System.out.println("회원등록 실패");
			}
			return cnt;
		} finally {
			pool.dbClose(ps, con);
		} 
	}
	
}
