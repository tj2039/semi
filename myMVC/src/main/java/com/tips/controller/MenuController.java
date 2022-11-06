package com.tips.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.tips.model.MenuExpert;

public class MenuController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.요청 파라미터 읽어오기
		String menu =request.getParameter("menu");
		
		//2. 비즈니스 로직 처리 - 모델에 의뢰
		MenuExpert model= new MenuExpert();
		String result= model.getTip(menu);
		
		//3. 결과저장
		request.setAttribute("result", result);
		
		//4. 뷰페이지 이동
		
		return "/tips/menuResult.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
