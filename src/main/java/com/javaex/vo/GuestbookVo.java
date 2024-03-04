package com.javaex.vo;

public class GuestbookVo {
	//필드
	private int no;
	private String name;
	private String password;
	private String reg_date;
	private String content;
	
	//생성자
	public GuestbookVo() {
		super();
	}

	public GuestbookVo(int no, String name, String password, String reg_date, String content) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.reg_date = reg_date;
		this.content = content;
	}
	
	//메소드-gs
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//메소드-일반
	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", reg_date=" + reg_date
				+ ", content=" + content + "]";
	}
	
}
