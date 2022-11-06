package com.mymvc.board.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.board.model.BoardService;
import com.mymvc.board.model.BoardVO;
import com.mymvc.common.PagingVO;

public class ListController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [3] 글 목록 페이지(list.jsp) - select
			/board/list.do =>DispatcherServlet => ListController
			=>list.jsp로 포워드
		 */
		//1.요청 파라미터 읽어오기
		String condition=request.getParameter("searchCondition");
		String keyword=request.getParameter("searchKeyword");
		//2.db작업
		BoardService boardService=new BoardService();
		List<BoardVO>list=null;
		try {
			list=boardService.selectAll(condition, keyword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//paging 처리 관련

		int currentPage=1;
		String strCurPage = request.getParameter("currentPage");
		if(strCurPage!=null) {
			currentPage=Integer.parseInt(strCurPage);
		}
		
		int totalRecord=0;
		if(list!=null) {
			totalRecord=list.size()
;		}
		int pageSize=5; 
		int blockSize=10;
		PagingVO pageVo= new PagingVO(currentPage, totalRecord, pageSize, blockSize);
		
		//3.결과 저장
		request.setAttribute("list", list);
		request.setAttribute("pageVo", pageVo);
		//4.뷰페이지로 이동
		return "/board/list.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
