package com.tips.model;

public class MenuExpert {
	public String getTip(String menu) {
		String result = "";
		if (menu.equals("한식")) {
			result = "순대국";
		} else if (menu.equals("양식")) {
			result = "명란 알리오올리오";
		} else if (menu.equals("중식")) {
			result = "고추짜장면";
		} else if (menu.equals("일식")) {
			result = "초밥";
		}
		return result;
	}
}
