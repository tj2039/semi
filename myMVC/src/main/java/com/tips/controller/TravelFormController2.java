package com.tips.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.tips.model.TravelExpert;

public class TravelFormController2 implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 /tips/TravelForm2.do=> TravelFormController2
		 =>  TravelForm.jsp(view)
		 
		 */
		return "/tips/TravelForm.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
