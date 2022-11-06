package com.mybook.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mybook.db.DBUtillBook2;

public class BookDAO {
	private DBUtillBook2 DBUtillBook;
	
	public BookDAO() {
		DBUtillBook=DBUtillBook2.getInstance();
	}

	public int insertBook(BookDTO dto) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		int cnt=0;
		
		try {
			con=DBUtillBook.getConnection();
			
			String sql="insert into book(no, title, price, publisher)"
					+ " values (book_seq.nextval, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			
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
			String sql="select * from book where title = ?";
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
			String sql="select * from book where no = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			//4.
			rs=ps.executeQuery();
			if (rs.next()) {
				String title =rs.getString("title");
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
	
	public int deleteByTitle(String title) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BookDTO dto=new BookDTO();
		try {
			con= DBUtillBook.getConnection();
			//3.
			String sql="delete from book"
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
			String sql="delete from book"
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
			
			String sql="select * from book ";
			if(keyword!=null && !keyword.isEmpty()) {
				sql+=" where "+condition+" like '%'|| ? ||'%'";
			}
					sql+= " order by no";
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
				
				BookDTO dto= new BookDTO(no, title, price, publisher, joindate);
				
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
			String sql="update book"
					+" set title= ?, price=?, publisher=?"
					+" where no=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			ps.setInt(4, dto.getNo());
			
			int cnt=ps.executeUpdate();
			return cnt;
		} finally {
			// TODO: handle finally clause
		}
	}
}
