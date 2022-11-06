package com.mymvc.pd.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.pd.model.PdService;

public class PdDeleteController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [7]상품 삭제 처리 - delete
			/pd/pdDelete.do=> DispatcherServlet => PdDeleteController
			=> 1)pdList.do 로 redirect 
			또는
			   2)메시지를 보여주는 경우
				message.jsp로 forward
		 */
		//1. 요청 파라미터 읽어오기
		String no = request.getParameter("no");
		
		//2. db작업
		PdService pdService=new PdService();
		
		String msg="상품 삭제 실패", url="/pd/pdDetail.do?no="+no;
		
		
		try {
			int cnt=pdService.deletePd(Integer.parseInt(no));
			if(cnt>0) {
				msg="상품 삭제 성공";
				url="/pd/pdList.do";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.결과저장
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		//4.뷰페이지로 리턴
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
