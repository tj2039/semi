package com.mymvc.board.model;

import java.sql.SQLException;
import java.util.List;

public class BoardService {
	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao=new BoardDAO();
	}
	
	public List<BoardVO> selectMainNotice() throws SQLException {
		return boardDao.selectMainNotice();
	}
	
	public int insertBoard(BoardVO vo) throws SQLException {
		return boardDao.insert(vo);		
	}

	public List<BoardVO> selectAll(String condition, String keyword) 
			throws SQLException {
		return boardDao.selectAll(condition, keyword);
	}

	public BoardVO selectByNo(int no) throws SQLException {
		return boardDao.selectByNo(no);
	}

	public int updateBoard(BoardVO vo) throws SQLException {
		return boardDao.updateBoard(vo);
	}

	public int deleteBoard(int no, String pwd) throws SQLException{
		return boardDao.delete(no, pwd);		
	}
	
	public int updateReadCount(int no) throws SQLException {
		return boardDao.updateReadCount(no);
	}
}
