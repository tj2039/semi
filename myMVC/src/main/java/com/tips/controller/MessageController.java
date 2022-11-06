package com.tips.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tips.model.MessageModel;

@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 파라미터 읽어오기
		String message = request.getParameter("message");
		
		//2. 비즈니스 로직처리
		MessageModel model =new MessageModel();
		String result= model.proMessage(message);
		
		//3. 결과 저장
		request.setAttribute("result", result);
		
		//4. 뷰페이지로 포워드
		RequestDispatcher dispatcher
			=request.getRequestDispatcher("/tips/messageView.jsp");
		dispatcher.forward(request, response);
	}

}
