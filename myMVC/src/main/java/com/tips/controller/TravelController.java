package com.tips.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tips.model.TravelExpert;

//@WebServlet("/TravelController")
public class TravelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	private void requestProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		//1. 요청 파라미터 읽어오기
		request.setCharacterEncoding("utf-8");
		String city=request.getParameter("city");
		
		//2. 비즈니스 로직 처리 - 모델에 의뢰
		TravelExpert model = new TravelExpert();
		String result=model.getTip(city);
		
		//3. 결과 저장
		request.setAttribute("result", result);
		
		//4. 뷰로 포워드
		RequestDispatcher dispatcher
			=request.getRequestDispatcher("/tips/travelResult.jsp");
		dispatcher.forward(request, response);
		
		/*
		[1] include 지시자, 액션 태그
		[2] forward 액션태그, RequestDispatcher
		[3] web.xml
		=> 절대참조시 컨텍스트 경로가 자동으로 포함됨 	*/
		
		  /*<servlet>
		  	<servlet-name>travelController</servlet-name>
		  	<servlet-class>com.tips.controller.TravelController</servlet-class>
		  </servlet>
		  <servlet-mapping>
		  	<servlet-name>travelController</servlet-name>
		  	<url-pattern>/travel.do</url-pattern>
		  </servlet-mapping>
		  
		  BookController
		  <servlet>
		  	<servlet-name>bookController</servlet-name>
		  	<servlet-class>com.tips.controller.BookController</servlet-class>
		  </servlet>
		  <servlet-mapping>
		  	<servlet-name>bookController</servlet-name>
		  	<url-pattern>/book.do</url-pattern>
		  </servlet-mapping>
		</web-app>*/ 
	}

}
