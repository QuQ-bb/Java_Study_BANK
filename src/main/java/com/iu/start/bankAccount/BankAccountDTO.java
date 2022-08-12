package com.iu.start.bankAccount;

import java.sql.Date;

public class BankAccountDTO {
	
	private Long accountnum;
	private String username;
	private Long booknum;
	private Date accountdate;
	
	
	public Long getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(Long accountnum) {
		this.accountnum = accountnum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getBooknum() {
		return booknum;
	}
	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	

}
