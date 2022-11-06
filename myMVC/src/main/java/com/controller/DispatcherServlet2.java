package com.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties props;	// => Hashtables를 상속 받았기 때문에 Map의 속성 즉, Key와 Value를 갖는다.
   
	@Override
	//해당 서블릿이 요청될때 최초로 한번만 호출되는 메서드
	public void init(ServletConfig config) throws ServletException {
		//매핑파일을 읽어서 properties 컬렉션에 저장한다
		
		//web.xml에서 init-param의 값 읽어오기
		String configFile=config.getInitParameter("configFile");
		
		//매핑 파일의 실제 경로 구하기
		String realConfigFile=config.getServletContext().getRealPath(configFile);
		
		System.out.println("configFile="+configFile);
		System.out.println("realConfigFile="+realConfigFile);
		
		props=new Properties();
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(realConfigFile);
			props.load(fis);
			//=> commandPro.properties파일의 정보를 properties 컬렉션에 저장
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
		
	}

	//사용자의 요청이 들어올때마다 호출됨
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		/*
		 매핑 파일을 참고해서 직원 구해서 일 시킨다.
		 
		 [1] 매핑 파일(properties 컬렉션)에서
		 	사용자의 URI에 해당하는 직원(담당 Controller)을 구해서,
		 	직원에게 일시킨다(담당 controller의 메서드 호출)
		 [2] 직원으로부터 결과를 리턴받아서 해당 뷰페이지로 포워드 한다.
		 */
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//사용자의 URI 읽어오기 => /myMVC/tips/book.do
		String uri=request.getRequestURI();
		System.out.println("uri="+uri);
		
		//contextPath 제거하기
		String contextPath=request.getContextPath();//=> /myMVC
		if(uri.indexOf(contextPath)!=-1){
			uri=uri.substring(contextPath.length());//=> /tips/book.do
		}
		System.out.println();
		
	}
	
	
	

}
