package com.mymvc.pd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class PdWriteController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [1]pdWrite.jsp 상품 등록 화면보기
			/pd/pdWrite.do =>DispatcherServlet => PdWriteController
			=>pdWrite.jsp로 포워드
		 */
		return "/pd/pdWrite.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
