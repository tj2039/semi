package com.mymvc.pd.controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.pd.model.PdDTO;
import com.mymvc.pd.model.PdService;

public class PdDetailController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [4] 상품 상세보기 페이지 (pdDetail.jsp) - select
			/pd/pdDetail.do => DispatcherServlet=> PdDetailController
			=>pdDetail.jsp로 포워드
		 */		
		//1. 요청 파라미터 읽어오기
		String no=request.getParameter("no");
		
		//2. db작업
		PdService pdService = new PdService();
		PdDTO dto = null;
		try {
			dto=pdService.selectByNo(Integer.parseInt(no));			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3. 결과 저장
		request.setAttribute("dto", dto);
		
		//4. 뷰페이지 리턴		
		return "/pd/pdDetail.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
