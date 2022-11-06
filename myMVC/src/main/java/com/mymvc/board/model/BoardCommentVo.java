package com.mymvc.board.model;

import java.sql.Timestamp;

public class BoardCommentVo {
	private int no;	
	private String name;	
	private String pwd;	
	private Timestamp regdate; 
	private String content;
	private int bdNo;
	
	public BoardCommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardCommentVo(int no, String name, String pwd, Timestamp regdate, String content, int bdNo) {
		super();
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.regdate = regdate;
		this.content = content;
		this.bdNo = bdNo;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public String getContent() {
		return content;
	}
	public int getBdNo() {
		return bdNo;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}
	@Override
	public String toString() {
		return "BoardCommentVo [no=" + no + ", name=" + name + ", pwd=" + pwd + ", regdate=" + regdate + ", content="
				+ content + ", bdNo=" + bdNo + "]";
	}	
	
}
