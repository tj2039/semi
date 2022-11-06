package com.mybook.book.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.mybook.db.DBUtillBook2;

public class BookDAO2 {
	private DBUtillBook2 DBUtillBook;
	
	public BookDAO2() {
		DBUtillBook=DBUtillBook2.getInstance();
	}

	public int insertBook(BookDTO dto) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		int cnt=0;
		
		try {
			con=DBUtillBook.getConnection();
			
			String sql="insert into book2(no, title, price, publisher,groupno,fileName, fileSize,"
					+ " originalFileName)"
					+ " values (book2_seq.nextval, ?, ?, ?,book2_seq.nextval,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			ps.setString(4, dto.getFileName());
			ps.setLong(5, dto.getFileSize());
			ps.setString(6, dto.getOriginalFileName());
			
			cnt=ps.executeUpdate();
			
			return cnt;
		} finally {
			DBUtillBook.dbClose( ps, con);
		}
	}
	
	public BookDTO selectByTitle(String title) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BookDTO dto=new BookDTO();
		try {
			con= DBUtillBook.getConnection();
			//3.
			String sql="select * from book2 where title = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, title);
			
			//4.
			rs=ps.executeQuery();
			if (rs.next()) {
				int no=rs.getInt("no");
				int price =rs.getInt("price");
				String publisher=rs.getString("publisher");
				Timestamp joindate=rs.getTimestamp("joindate");
				
				dto.setNo(no);
				dto.setTitle(title);
				dto.setPrice(price);
				dto.setPublisher(publisher);
				dto.setJoindate(joindate);
				
			}
			System.out.println("도서명으로 조회 결과 dto="+dto);
			return dto;
		} finally {
			//5.
			DBUtillBook.dbClose(rs, ps, con);
			// TODO: handle finally clause
		}
		
	}
	
	public BookDTO selectByNo(int no) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BookDTO dto=new BookDTO();
		try {
			con= DBUtillBook.getConnection();
			//3.
			String sql="select * from book2 where no = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4.
			rs=ps.executeQuery();
			if (rs.next()) {
				String title =rs.getString("title");
				int price =rs.getInt("price");
				String publisher=rs.getString("publisher");
				Timestamp joindate=rs.getTimestamp("joindate");
				//답변형 게시판 추가
				int groupNo=rs.getInt("groupno");
				int step=rs.getInt("step");
				int sortNo=rs.getInt("sortNo");
				String delFlag=rs.getString("delFlag");
				
				//자료실 추가
				String fileName=rs.getString("fileName");
				String originalFName=rs.getString("originalFileName");
				long fileSize=rs.getLong("fileSize");
				int downcount=rs.getInt("downcount");
				
				dto.setNo(no);
				dto.setTitle(title);
				dto.setPrice(price);
				dto.setPublisher(publisher);
				dto.setJoindate(joindate);
				dto.setGroupNo(groupNo);
				dto.setStep(step);
				dto.setSortNo(sortNo);
				dto.setDelFlag(delFlag);
				dto.setFileName(fileName);
				dto.setOriginalFileName(originalFName);
				dto.setFileSize(fileSize);
				dto.setDownCount(downcount);
				
			}
			System.out.println("도서명으로 조회 결과 dto="+dto);
			return dto;
		} finally {
			//5.
			DBUtillBook.dbClose(rs, ps, con);
			// TODO: handle finally clause
		}
		
	}
	
	public int deleteByTitle(String title) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BookDTO dto=new BookDTO();
		try {
			con= DBUtillBook.getConnection();
			//3.
			String sql="delete from book2"
					+ " where title=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, title);
			
			//4.
			int cnt=ps.executeUpdate();
			
			return cnt;
		} finally {
			//5.
			DBUtillBook.dbClose( ps, con);
			// TODO: handle finally clause
		}
		
	}
	
	public int deleteByNo(int no) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		
		
		BookDTO dto=new BookDTO();
		try {
			con= DBUtillBook.getConnection();
			//3.
			String sql="delete from book2"
					+ " where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4.
			int cnt=ps.executeUpdate();
			
			return cnt;
		} finally {
			//5.
			DBUtillBook.dbClose( ps, con);
			// TODO: handle finally clause
		}
		
	}
	public List<BookDTO> selectAll(String condition,String keyword) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<BookDTO> list=new ArrayList<>();
		try {
			con=DBUtillBook.getConnection();
			
			String sql="select * from book2 ";
			//검색의 경우
			if(keyword!=null && !keyword.isEmpty()) {
				sql+=" where "+condition+" like '%'|| ? ||'%'";
			}
				sql+= "order by groupno desc, sortno";
			ps=con.prepareStatement(sql);
			if (keyword!=null&& !keyword.isEmpty()) {
				ps.setString(1, keyword);				
			}
			
			rs=ps.executeQuery();
			while (rs.next()) {
				int no=rs.getInt("no");
				String title=rs.getString("title");
				int price =rs.getInt("price");
				String publisher=rs.getString("publisher");
				Timestamp joindate=rs.getTimestamp("joindate");
				
				//답변형 게시판 추가
				int groupNo=rs.getInt("groupno");
				int step=rs.getInt("step");
				int sortNo=rs.getInt("sortNo");
				String delFlag=rs.getString("delFlag");
				
				//자료실 추가
				String fileName=rs.getString("fileName");
				String originalFName=rs.getString("originalFileName");
				long fileSize=rs.getLong("fileSize");
				int downcount=rs.getInt("downcount");
				
				BookDTO dto= new BookDTO(no, title, price, publisher, joindate, groupNo, step, sortNo, delFlag, fileName, fileSize, downcount, originalFName);
				
				list.add(dto);
			}
			
			System.out.println("전체조회 결과 list.size="+list.size());

			return list;
		} finally {
			DBUtillBook.dbClose(rs, ps, con);
		}
	}

	
	public int updateBook(BookDTO dto) throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		
		try {
			con=DBUtillBook.getConnection();
			
			//3.
			String sql="update book2"
					+" set title= ?, price=?, publisher=?";
					if(dto.getFileName()!=null && !dto.getFileName().isEmpty()) {
						sql+=",fileName=?,fileSize=?,originalfilename=? ";
					}
			sql+= " where no=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			//
			if(dto.getFileName()!=null && !dto.getFileName().isEmpty()) {
				ps.setInt(4, dto.getNo());
				ps.setString(5, dto.getFileName());
				ps.setLong(6, dto.getFileSize());
				ps.setString(7, dto.getOriginalFileName());
			}else {
				ps.setInt(4, dto.getNo());
			}
			int cnt=ps.executeUpdate();
			return cnt;
		} finally {
			// TODO: handle finally clause
		}
	}
	public int reply( BookDTO dto) throws SQLException {
		//답변 처리
		Connection con=null;
		PreparedStatement ps=null;
		int cnt=0;
		try {
			//1,2
			con=DBUtillBook.getConnection();
			
			//트랜잭션 시작
			con.setAutoCommit(false);//자동 커밋 안되게 막는다
			
			//3.
			//[1] update
			String sql="update book2"
					+ " set sortno=sortno+1"
					+ " where groupno=? and sortno>?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getGroupNo());
			ps.setInt(2, dto.getSortNo());
			
			//4
			cnt=ps.executeUpdate();
			//[2] insert
			sql="insert into book2(no, title, price, publisher,"
					+ " groupno, step, sortno)"
					+ " values (book2_seq.nextval, ?,?,?,"
					+ " ?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			ps.setInt(4, dto.getGroupNo());
			ps.setInt(5, dto.getStep()+1);
			ps.setInt(6, dto.getSortNo()+1);
			
			cnt=ps.executeUpdate();
			
			//모두 성공하면 commit
			con.commit();
			
			//트랜잭션 종료
		} catch (Exception e) {
			e.printStackTrace();
			//하나라도 실패하면 rollback
			con.rollback();
		}finally {
			//다시 자동커밋되도록 셋팅
			con.setAutoCommit(true);
			DBUtillBook.dbClose(ps, con);
		}
		return cnt;
	}
	public int updateDownCount(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2
			con=DBUtillBook.getConnection();
			//3
			String sql="update book2"
					+ " set downcount=downcount+1"
					+ " where no=? ";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4
			int cnt=ps.executeUpdate();
			System.out.println("다운로드 수 증가 결과 cnt="+cnt+",매개변수 no="+no);
			
			return cnt;
			
		}finally {
			//5
		}
	}
	
}
