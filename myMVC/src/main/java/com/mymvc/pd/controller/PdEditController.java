package com.mymvc.pd.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.pd.model.PdDTO;
import com.mymvc.pd.model.PdService;

public class PdEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [5] 수정 화면 보여주기 (pdEdit.jsp) -select
			/pd/pdEdit=> DispatcherServlet=> PdEditController
			=>pdEdit.jsp로 포워드
		 */
		//1.요청 파라미터 읽어오기
		String no = request.getParameter("no");
		
		//2.db작업
		PdService pdService= new PdService();
		PdDTO dto= null;
		try {
			dto= pdService.selectByNo(Integer.parseInt(no));
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//3.결과 저장
		request.setAttribute("dto", dto);
		//4.뷰페이지로 리턴
	
		return "/pd/pdEdit.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
