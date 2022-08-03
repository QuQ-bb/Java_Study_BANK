package com.iu.start.bankBook;

public class BankBookDTO {
	
	private Long booknum;
	private String bookname;
	private double bookrate;
	private int booksale;
	
	
	public Long getBooknum() {
		return booknum;
	}
	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public int getBooksale() {
		return booksale;
	}
	public void setBooksale(int booksale) {
		this.booksale = booksale;
	}
	
	
	

}
