package com.mymvc.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.mymvc.db.ConnectionPoolMgr2;

public class BoardCommentDAO {
private ConnectionPoolMgr2 pool;
	
	public BoardCommentDAO(){
		pool=new ConnectionPoolMgr2();
	}
	public int insertCommnent(BoardCommentVo vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=pool.getConnection();
			
			String sql="insert into comments(no,name,pwd,content,bdNo)"
					+ " values(comments_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getContent());
			ps.setInt(4, vo.getBdNo());
			
			int cnt=ps.executeUpdate();
			System.out.println("댓글 추가 cnt="+cnt);
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public List< BoardCommentVo> selectCommnent(int bdno) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List< BoardCommentVo> list=null;
		try {
			con=pool.getConnection();
			
			String sql="select * from comments where bdno=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bdno);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				 int no=rs.getInt("no");	
				 String name=rs.getString("name");	
				 String pwd	=rs.getString("pwd");	
				 Timestamp regdate=rs.getTimestamp("regdate"); 
				 String content=rs.getString("content");
				 
				 BoardCommentVo vo=new BoardCommentVo(no, name, pwd, regdate, content, bdno);
				 
				 list.add(vo);
			}
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int countCommnent(int bdno) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		int cnt=0;
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			ps.setInt(2, bdno);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				 cnt=rs.getInt(0);
			}
			
			return cnt;
		}finally {
			pool.dbClose(rs,ps, con);
		}
	}
}
