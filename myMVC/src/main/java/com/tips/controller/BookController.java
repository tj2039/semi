package com.tips.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tips.model.BookExpert;


//@WebServlet("/bookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestProcess(request, response);
	}

	private void requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");

		// 1.
		request.setCharacterEncoding("utf-8");
		String lang=request.getParameter("lang");
		
		// 2
		BookExpert model = new BookExpert();
		String result = model.getTip(lang);

		// 3
		request.setAttribute("result", result);
		// 4
		RequestDispatcher dispatcher = request.getRequestDispatcher("/tips/bookResult.jsp");
		dispatcher.forward(request, response);
	}

}
