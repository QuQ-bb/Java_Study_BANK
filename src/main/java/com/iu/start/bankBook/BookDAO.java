package com.iu.start.bankBook;

import java.util.ArrayList;

public interface BookDAO {
	
	
	//BANBOOK Table에 insert
	//BookNum : 현재시간을 밀리세컨즈로 변환해서 입력
	//BookSale : 1로 입력
	public int setBankBook(BankBookDTO BankBookDTO)throws Exception;

	//bankbook 모든 데이터를 조회 최신순으로
	public ArrayList<BankBookDTO> getList()throws Exception;
	
	//sale의 값을 변경
	public int setChangeSale(BankBookDTO bankBookDTO)throws Exception;
	
	//bookNum의 값으로 조회 pk키로 조회하면 1개 아니면 없는것 booknum의 값을 입력
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception;
	
}
