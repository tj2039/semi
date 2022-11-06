package com.mymvc.pd.model;

import java.sql.Timestamp;

/*
 DTO(Data Transfer Object), VO(Value Object)
- 객체를 표현한 한 단위
- 데이터를 전달하는 단위
  - table의 컬럼들이 멤버변수가 된다
*/
public class PdDTO {
	private int no;
	private String pdName; //컴
	private int price; //150
	private Timestamp regdate;
	
	public PdDTO() {
		super();
	}

	public PdDTO(int no, String pdName, int price, Timestamp regdate) {
		super();
		this.no = no;
		this.pdName = pdName;
		this.price = price;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PdDTO [no=" + no + ", pdName=" + pdName + ", price=" + price + ", regdate=" + regdate + "]";
	}
	
	
}
