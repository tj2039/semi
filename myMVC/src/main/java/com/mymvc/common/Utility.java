package com.mymvc.common;

import java.util.Date;

public class Utility {
	//자료실에서 사용할 상수
	public static final String UPLOAD_DIR = "pds_upload";
	public static final String TEST_DIR 
	= "C:\\lecture\\workspace_list\\jsp_ws\\herbmall\\src\\main\\webapp\\pds_upload";

	
	public static String displayRe(int step) {
		String result="";
		if(step>0){
			for(int j=0;j<step;j++){
				result+="&nbsp;";
			}
			result+="<img src='../images/re.gif'>";
		} 

		return result;
	}

	public static String cutTitle(String title, int len) {
		String result = title;

		if(title.length()>len) {
			result = title.substring(0, len) + "...";
		}

		return result;
	}

	public static String displayNew(Date regdate) {
		String result = "";

		Date today = new Date();

		long gap = (today.getTime()-regdate.getTime())/1000;
		gap = gap/(60*60);

		if(gap<24) {
			result = "<img src='../images/new.gif'>";
		}   
		return result;
	}

	public static String displayFile(String fileName) {
		String result = "";
		if(fileName != null && !fileName.isEmpty()){
			result += "<img src = '../images/file.gif'>";
		}

		return result;
	}

	public static String getFileInfo(String fileName, long fileSize) {
		String result ="";
		float fSize = fileSize/1000f;
		fSize=Math.round(fSize*100)/100f;
		
		if(fileName!=null && !fileName.isEmpty()) {
			result+="<img src='../images/file.gif'> "+ fileName
					+"  ("+ fSize +"KB)";
		}
		return result;
	}

}



