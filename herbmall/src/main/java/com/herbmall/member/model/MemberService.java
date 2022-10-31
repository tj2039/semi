package com.herbmall.member.model;

import java.sql.SQLException;
import java.util.List;

import com.herbmall.zipcode.model.ZipcodeVO;

//jsp -> DAO
//jsp -> Service -> Dao

public class MemberService {
	//아이디 중복확인에서 사용할 상수
	public static final int EXIST_ID=1;	//이미 존재하는 아이디 
	public static final int NOT_EXIST_ID=2;	//존재하지 않는 아이디- 사용가능
	
	private MemberDAO memberDao;
	
	public MemberService()	{
		memberDao=new MemberDAO();
	}
	public int insertMem(MemberVO vo) throws SQLException {
		int cnt=memberDao.insertMem(vo);
		return cnt;
	}
	
	public int duplicateUserid(String userid) throws SQLException {
		return memberDao.duplicateUserid(userid);
	}
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		return memberDao.selectZipcode(dong);
	}
}
