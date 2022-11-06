package com.tips.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.tips.model.BookExpert;
import com.tips.model.TravelExpert;

public class TravelController2 implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 요청 파라미터 읽어오기
		String city = request.getParameter("city");

		// 2. 비즈니스 로직 처리 - 모델에 의뢰
		TravelExpert model = new TravelExpert();
		String result = model.getTip(city);

		// 3. 결과 저장
		request.setAttribute("result", result);

		// 4. 뷰페이지 리턴
		return "/tips/bookResult.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
	

}
