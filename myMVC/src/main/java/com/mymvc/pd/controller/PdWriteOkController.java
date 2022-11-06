package com.mymvc.pd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.pd.model.PdDTO;
import com.mymvc.pd.model.PdService;

public class PdWriteOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [2]상품 등록 처리 - insert (message 보여주지 않고 다른 페이지로 이동) /pd/pdWrite_ok.do =>
			 DispatcherServlet => PdWrite_okController 
			 => pdList.do 로 redirect
		 */
		//1. 요청 파라미터 읽어오기
		String pdName=request.getParameter("pdName");
		String price=request.getParameter("price");
		
		//2. db작업
		PdService pdService=new PdService();
		PdDTO dto=new PdDTO();
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));
		try {
			int cnt=pdService.insertPd(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3. 결과 저장
		//4. 이동할 페이지 리턴
		return "/pd/pdList.do";
	}

	@Override
	public boolean isRedirect() {
		return true;	//redirect
	}

}
