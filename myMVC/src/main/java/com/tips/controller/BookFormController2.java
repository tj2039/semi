package com.tips.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class BookFormController2 implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 /tips/bookForm.do=> BookFormController2
		 =>  bookForm.jsp
		 
		 */
		return "/tips/bookForm.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
