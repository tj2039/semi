package com.mymvc.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.board.model.BoardService;
import com.mymvc.board.model.BoardVO;

public class WriteOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [2] 글쓰기 처리
			/board/write_ok.do=> DispatcherServlet => WriteOkController
			=>list.do로 redirect
		 */
		//1.요청 파라미터 읽어오기
		String title =request.getParameter("title");
		String name =request.getParameter("name");
		String pwd =request.getParameter("pwd");
		String email =request.getParameter("email");
		String content =request.getParameter("content");
		
		//2.db작업
		BoardService boardService=new BoardService();
		BoardVO vo= new BoardVO();
		vo.setTitle(title);;
		vo.setName(name);;
		vo.setPwd(pwd);;
		vo.setEmail(email);;
		vo.setContent(content);;
		try {
			int cnt=boardService.insertBoard(vo);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		//3.결과 저장
		//4.뷰페이지로 리턴
		return "/board/list.do";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;	//redirect
	}

}
