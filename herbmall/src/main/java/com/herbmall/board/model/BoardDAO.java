package com.herbmall.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.herbmall.db.ConnectionPoolMgr;

public class BoardDAO {
	private ConnectionPoolMgr pool;
	
	public BoardDAO(){
		pool=new ConnectionPoolMgr();
	}
	public int insert(BoardVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3.ps
			String sql="insert into board(no,name,pwd,title,email,content)\r\n"
					+ "values(board_seq.nextval,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getContent());
			//4. exec
			int cnt=ps.executeUpdate();
			System.out.println("글 등록 결과 cnt="+cnt+", 매개변수 vo"+vo);
			
			return cnt;
		} finally {
			pool.dbClose(ps, con);
		}
	}
	public List<BoardVO> selectAll(String condition, String keyword) throws SQLException {
		/*
		 select * from board 
		 where title like '%안녕%';
		  
		 select * from board 
		 where name like '%길동%';
		 
		  select * from board 
		  where content like '%안녕%';
		 */
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardVO> list=new ArrayList<>();
		try {
			//1,2
			con=pool.getConnection();
						//3.ps
			String sql="select * from board ";
			if(keyword!=null && !keyword.isEmpty()) {
				sql+="where "+condition+" like '%' || ? ||'%'";
			}
			sql+=" order by no desc";
			ps=con.prepareStatement(sql);
			
			if(keyword!=null&& !keyword.isEmpty()) {
				ps.setString(1, keyword);
			}
			//4.exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				int readcount=rs.getInt("readcount");
				String title= rs.getString("title");
				String name= rs.getString("name");
				String pwd= rs.getString("pwd");
				String email= rs.getString("email");
				String content= rs.getString("content");
				Timestamp regdate=rs.getTimestamp("regdate");
				
				BoardVO vo= new BoardVO(no, name, pwd, title, email, regdate, readcount, content);
				
				list.add(vo);
			}
			System.out.println("글 전체 조회결과 list.size="+list.size()
							+", 매개변수 condition="+condition+", keyword="+keyword);
			return list;
		} finally {
			// TODO: handle finally clause
			pool.dbClose(rs, ps, con);
		}
	}
	public BoardVO selectByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BoardVO vo= new BoardVO();
		
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="select * from board where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			//4.exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int readcount=rs.getInt("readcount");
				String title=rs.getString("title");
				String name=rs.getString("name");
				String pwd=rs.getString("pwd");
				String email=rs.getString("email");
				String content=rs.getString("content");
				Timestamp regdate=rs.getTimestamp("regdate");
				
				vo.setContent(content);
				vo.setEmail(email);
				vo.setName(name);
				vo.setNo(no);
				vo.setPwd(pwd);
				vo.setReadcount(readcount);
				vo.setRegdate(regdate);
				vo.setTitle(title);
				
			}
			System.out.println("글 상세보기 결과 vo="+vo+", 매개변수 no="+no);
			return vo;
		} finally {
			//5
			pool.dbClose(rs, ps, con);
			//: handle finally clause
		}
	}
	public int updateBoard(BoardVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="update board"
					+ " set title=?,name=? ,email=?,content=?"
					+ " where no=? and pwd=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getContent());
			ps.setInt(5, vo.getNo());
			ps.setString(6, vo.getPwd());
			
			//4
			int cnt=ps.executeUpdate();
			System.out.println("글수정 결과 cnt="+cnt+", 매개변수 vo="+vo);
			
			return cnt;
			
		} finally {
			//5
			pool.dbClose(ps, con);
			// TODO: handle finally clause
		}
	}
	public int delete(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="delete from board"
					+ " where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			int cnt=ps.executeUpdate();
			System.out.println("글삭제 결과 cnt="+cnt+", 매개변수 no="+no);
			//4
			return cnt;
		} finally {
			//5
			pool.dbClose(ps, con);
			// TODO: handle finally clause
		}
	}
	public int delete(int no, String pwd) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="delete from board"
					+ " where no=? and pwd=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, pwd);
			
			int cnt=ps.executeUpdate();
			System.out.println("글삭제 결과 cnt="+cnt+", 매개변수 no="+no);
			//4
			return cnt;
		} finally {
			//5
			pool.dbClose(ps, con);
			// TODO: handle finally clause
		}
	}
	public int updateReadCount(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="update board"
					+ " set readcount=readcount+1"
					+ " where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			int cnt=ps.executeUpdate();
			return cnt;
			//4
		} finally {
			//5
			pool.dbClose(ps, con);
		}
	}
}
