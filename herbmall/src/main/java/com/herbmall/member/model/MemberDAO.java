package com.herbmall.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.herbmall.db.ConnectionPoolMgr2;
import com.herbmall.zipcode.model.ZipcodeVO;


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
	/*
	 * 아이디 중복확인
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public int duplicateUserid(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="select count(*) from member where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			//4
			int result=0;
			rs=ps.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				if(count>0) {
					result=MemberService.EXIST_ID; //이미 존재
				}else {
					result=MemberService.NOT_EXIST_ID;	//사용 가능
				}
			}
			System.out.println("아이디 중복확인 결과 result="+result
					+", 매개변수 userid="+userid);
			return result;
		} finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<ZipcodeVO> list=new ArrayList<>();
		try {
			//1,2
			con=pool.getConnection();
			
			//3
			String sql="select * from zipcode"
					+ " where dong like '%' || ? || '%'";
			ps=con.prepareStatement(sql);
			ps.setString(1, dong);
			
			//4
			rs=ps.executeQuery();
			while(rs.next()) {
				String zipcode=rs.getString("zipcode");
				String sido=rs.getString("sido");
				String gugun=rs.getString("gugun");
				String dong2=rs.getString("dong");
				String startbunji=rs.getString("startbunji");
				String endbunji=rs.getString("endbunji");
				int seq=rs.getInt("seq");
				
				ZipcodeVO vo = new ZipcodeVO(zipcode, sido, gugun, 
					dong2, startbunji, endbunji, seq);
				list.add(vo);
			}
			System.out.println("우편번호 찾기 결과 list.size="+list.size()
				+"매개변수 dong="+dong);
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
}
