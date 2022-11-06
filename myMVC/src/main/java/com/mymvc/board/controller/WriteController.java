package com.mymvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class WriteController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [1] 글쓰기 화면 보여주기
			/board/write.do=> DispatcherServlet =>writeController
			=>write.jsp로 포워드
		 */
		//1.요청 파라미터 읽어오기
		
		//2.db작업
		
		//3.결과저장
		
		//4.뷰페이지 리턴
		
		return "/board/write.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
