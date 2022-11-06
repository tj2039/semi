package com.mymvc.pd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.mymvc.pd.model.PdDTO;
import com.mymvc.pd.model.PdService;

public class PdEditOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 [6] 상품 수정 처리 : update
			/pd/pdEdit_ok=> DispatcherServlet => PdEditOkController
			=>pdDetail.do 로 redirect
		 */
		//1.요청파라미터 읽어오기
		String no=request.getParameter("no");
		String pdName=request.getParameter("pdName");
		String price=request.getParameter("price");
		
		PdDTO pdDto=new PdDTO();
		pdDto.setNo(Integer.parseInt(no));
		pdDto.setPdName(pdName);
		pdDto.setPrice(Integer.parseInt(price));
		
		//2.db작업
		PdService pdService=new  PdService();
		int cnt=0;
		try {
			cnt= pdService.updatePd(pdDto);
			if(cnt>0) {
				System.out.println("상품수정 성공!!");
			}else {
				System.out.println("상품수정 실패...");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//3.결과저장
		//4.뷰페이지 리턴
		return  "/pd/pdDetail.do?no="+no;
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true; //**redirect 할때는 true
	}

}
