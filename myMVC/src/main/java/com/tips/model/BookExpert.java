package com.tips.model;

public class BookExpert {
	public String getTip(String lang) {
		String result = "";
		if (lang.equals("java")) {
			result = "자바의 정석";
		} else if (lang.equals("jsp")) {
			result = "jsp 2.0 웹 프로그래밍";
		} else if (lang.equals("ajax")) {
			result = "프로개발자를 위한 Ajax 완전정복";
		} else if (lang.equals("oracle")) {
			result = "뇌를 자극하는 오라클 프로그래밍";
		}
		return result;
	}
}
