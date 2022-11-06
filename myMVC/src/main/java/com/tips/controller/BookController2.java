package com.tips.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.tips.model.BookExpert;

public class BookController2 implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1
		String lang=request.getParameter("lang");

		//2
		BookExpert model = new BookExpert();
		String result=model.getTip(lang);

		//3
		request.setAttribute("result", result);

		//4
		return "/tips/bookResult.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
