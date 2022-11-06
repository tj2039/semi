package com.tips.model;

public class MessageModel {
	public String proMessage(String msg) {
		String result="";
		
		if(msg==null || msg.isEmpty()) {
			result="안녕하세요";
		}else if(msg.equals("name")) {
			result="홍길동입니다.";			
		}else {
			result="타입이 맞지 않습니다.";
		}
		
		return result;
	}
}
