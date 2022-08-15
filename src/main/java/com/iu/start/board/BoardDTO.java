package com.iu.start.board;

import java.sql.Date;

public class BoardDTO {

	private Long boardNum; // 글번호
	private String boardTitle; // 글제목
	private String boardContent; // 글내용
	private String username; // 글작성자
	private Date reporting_date; // 작성일
	private Long hit; // 조회수

	public Long getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getReporting_date() {
		return reporting_date;
	}

	public void setReporting_date(Date reporting_date) {
		this.reporting_date = reporting_date;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	

}
