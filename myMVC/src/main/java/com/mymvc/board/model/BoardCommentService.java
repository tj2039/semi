package com.mymvc.board.model;

import java.sql.SQLException;
import java.util.List;

public class BoardCommentService {
	private BoardCommentDAO boardCommentDao;
	
	public BoardCommentService() {
		 boardCommentDao=new BoardCommentDAO();
	}
	public int insertCommnent(BoardCommentVo vo) throws SQLException {
		return boardCommentDao.insertCommnent(vo);
	}
	public List<BoardCommentVo> selectCommnent(int bdno) throws SQLException {
		return boardCommentDao.selectCommnent(bdno);
	}
	public int countCommnent(int bdNo) throws SQLException {
		return boardCommentDao.countCommnent(bdNo);
	}
}
