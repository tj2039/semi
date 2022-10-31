package com.hebmall.common;

import java.sql.Timestamp;

import java.util.Date;

import com.herbmall.reboard.model.ReBoardVO;


public class utillity {
	//자료실에서 사용할 상수
	public static final String UPLOAD_DIR= "pds_upload";
	public static final String TEST_DIR
		= "C:\\lecture\\workspace_list\\jsp_ws\\herbmall\\src\\main\\webapp\\pds_upload";
	
	public static String displayRe(int step) {
		String result="";
		if(step > 0){
			for(int j=0;j<step;j++){
			result+="&nbsp;";
			} 
          result="<img src = '../images/re.gif'>";
       }
		return result;
	}
	public static String cutTitle(String title, int len)	{
		String result="";
		if(title.length()>len) {
			result=title.substring(0, len)+"...";
		}else {
			result=title;
		}
		
		return result;
	}
	public static String displayNew(Date regdate) {
		String result="";
		Date d=new Date();
		long gap=d.getTime()-regdate.getTime();
		gap=gap/1000;	//초
		gap=gap/(60*60);	//일
		if(gap<24) {
			result="<img src='../images/new.gif'>";
		}
		return result;
	}
	public static String displayFile(String fileName) {
		String result="";
		if(fileName!=null && !fileName.isEmpty()) {
			result="<img src='../images/file.gif'>";
		}
		return result;	
	}
	
	public static String getFileInfo(ReBoardVO vo) {
		String result="";
		float fSize= vo.getFileSize()/1000f;
		fSize=Math.round(fSize*100)/100f;
		
		if (vo.getFileName()!=null && !vo.getFileName().isEmpty()) {
			result= " <img src='../images/file.gif'>&nbsp;"
					+vo.getOriginalFileName()+"&nbsp;("+fSize+"KB)";
		}
		return result;
	}
}
