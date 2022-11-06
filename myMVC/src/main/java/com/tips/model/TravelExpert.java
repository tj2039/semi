package com.tips.model;

public class TravelExpert {
	public String getTip(String city) {
		String result = "";
		if (city.equals("강화")) {
			result = "시월애 촬영지 석모도";
		} else if (city.equals("강릉")) {
			result = "바다와 가장 가까운 역 정동진";
		} else if (city.equals("해남")) {
			result = "한반도의 땅끝 땅끝마을";
		} else if (city.equals("거제")) {
			result = "남국의 파라다이스 외도";
		}
		return result;
	}
}
