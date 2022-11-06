package com.mybook.book.model;

import java.sql.Timestamp;

public class BookDTO {
	private int no;
	private String title;
	private int price;
	private String publisher;
	private Timestamp joindate;
	private int groupNo;
	private int step;
	private int sortNo;
	private String delFlag;
	private String fileName;
	private long fileSize;
	private int downCount;
	private String originalFileName;
	
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(int no, String title, int price, String publisher,Timestamp joindate) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.joindate=joindate;
	}

	public BookDTO(int no, String title, int price, String publisher, Timestamp joindate, int groupNo, int step,
			int sortNo, String delFlag) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.joindate = joindate;
		this.groupNo = groupNo;
		this.step = step;
		this.sortNo = sortNo;
		this.delFlag = delFlag;
	}

	public BookDTO(int no, String title, int price, String publisher, Timestamp joindate, int groupNo, int step,
			int sortNo, String delFlag, String fileName, long fileSize, int downCount, String originalFileName) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.joindate = joindate;
		this.groupNo = groupNo;
		this.step = step;
		this.sortNo = sortNo;
		this.delFlag = delFlag;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.downCount = downCount;
		this.originalFileName = originalFileName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	@Override
	public String toString() {
		return "BookDTO [no=" + no + ", title=" + title + ", price=" + price + ", publisher=" + publisher
				+ ", joindate=" + joindate + ", groupNo=" + groupNo + ", step=" + step + ", sortNo=" + sortNo
				+ ", delFlag=" + delFlag + ", fileName=" + fileName + ", fileSize=" + fileSize + ", downCount="
				+ downCount + ", originalFileName=" + originalFileName + "]";
	}

	

	
}
