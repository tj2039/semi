package com.mymvc.pd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mymvc.db.ConnectionPoolMgr2;


/*
  DAO(Data Access Object)
- 데이터베이스 작업(CRUD)을 전담하는 객체

  CRUD
 C : create, insert
 R : read, select
 U : update
 D : delete
*/
public class PdDAO {
	private ConnectionPoolMgr2 pool;
	
	public PdDAO() {
		pool=new ConnectionPoolMgr2();
	}
	
	//1. 매개변수가 dto인 메서드 - 입력, 수정시 사용	
	/**
	 * 상품 테이블에 insert하는 메서드
	 * @param dto
	 * @return
	 * @throws SQLException
	*/
	public int insertPd(PdDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int cnt=0;
		try {
			//1, 2. con
			con=pool.getConnection();
			
			//3. ps
			String sql="insert into pd(no, pdname, price)"
					+ " values (pd_seq.nextval, ?, ?)";
			ps=con.prepareStatement(sql);
			
			//in parameter setting
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			
			//4. exec
			cnt=ps.executeUpdate();	
			System.out.println("상품 등록 결과, cnt="+cnt
				+", 매개변수 dto="+dto);
		}finally {
			//5. 자원반납,해제			
			pool.dbClose(ps, con);
		}
		
		return cnt;
	}
	
	//2. 반환타입이 dto인 메서드 - select 결과가 레코드 하나인 경우 사용
	/**
	 * 상품번호로 조회하는 메서드
	 * @param no
	 * @return
	 * @throws SQLException
	 */
	public PdDTO selectByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		PdDTO dto = new PdDTO(); //결과 레코드 하나를 dto에 넣어서 리턴
		try {
			//1,2
			con=pool.getConnection();
			
			//3
			String sql="select * from pd where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4.
			rs=ps.executeQuery();
			if(rs.next()) {
				String pdName=rs.getString("pdName");
				int price=rs.getInt("price");
				Timestamp regdate=rs.getTimestamp("regdate");
				
				//하나의 레코드는 하나의 DTO
				//결과 레코드를 DTO로 묶어준다
				dto.setNo(no);
				dto.setPdName(pdName);
				dto.setPrice(price);
				dto.setRegdate(regdate);
			}
			System.out.println("번호로 조회 결과 dto="+dto); //디버깅용
			
			return dto;
		}finally {
			pool.dbClose(rs, ps, con);
		}		
	}
	
	//3. 반환타입이 List인 메서드 - select 결과가 여러 개의 레코드인 경우 사용
	/**
	 * 전체 상품을 조회하는 메서드
	 * @return
	 * @throws SQLException
	 */
	public List<PdDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//결과 레코드 여러개를 ArrayList에 묶어서 리턴
		List<PdDTO> list = new ArrayList<>();
		try {
			//1,2
			con=pool.getConnection();
			
			//3. ps
			String sql="select * from pd order by no desc";
			ps=con.prepareStatement(sql);
			
			//4. exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt(1);
				String pdName=rs.getString(2);
				int price=rs.getInt(3);
				Timestamp regdate=rs.getTimestamp(4);				
				
				//[1] 하나의 레코드를 하나의 DTO로 묶어준다
				PdDTO dto = new PdDTO(no, pdName, price, regdate);
				
				//[2] 각각의 DTO를 ArrayList에 묶어준다
				list.add(dto);
			}
			System.out.println("전체 조회 결과 list.size="+list.size());
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int updatePd(PdDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3 ps
			String sql="update pd"
					+ " set pdname=?, price=?"
					+ " where no=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getNo());
			
			//4 exec
			int cnt=ps.executeUpdate();
			System.out.println("상품 수정 결과 cnt="+cnt);
			
			return cnt;
		}finally {
			//5
			pool.dbClose(ps, con);
		}
	}
	
	public int deletePd(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3 ps
			String sql="delete from pd"
					+ " where no=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			//4 exec
			int cnt=ps.executeUpdate();
			System.out.println("상품 삭제 결과 cnt="+cnt);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public List<PdDTO> selectByPdName(String pdName) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<PdDTO> list = new ArrayList<>();
		
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3 ps
			String sql="select * from pd where pdname=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, pdName);
			
			//4 exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				int price=rs.getInt("price");
				Timestamp regdate=rs.getTimestamp("regdate");
				
				PdDTO dto = new PdDTO(no, pdName, price, regdate);
				list.add(dto);
			}
			
			System.out.println("상품명으로 조회 결과 list.size="+list.size()
					+", 매개변수 pdName="+pdName);
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
}

