package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO{
	
	BankBookDTO bankBookDTO = null;
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		Connection con  = DBConnector.getConnection();
		String sql ="DELETE BANKBOOK WHERE BOOKNUM =?";
		PreparedStatement ps = con.prepareStatement(sql);
		 ps.setLong(1, bankBookDTO.getBooknum());
		 
		 int result = ps.executeUpdate();
		 
		 DBConnector.disConnect(ps, con);
		
		return result;
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception {
		//db 연결
		Connection con = DBConnector.getConnection();
		//sql 작성
		String sql = "UPDATE BANKBOOK SET BOOKNAME = ? ,BOOKRATE = ? WHERE BOOKNUM= ? ";
		//미리전송
		PreparedStatement ps = con.prepareStatement(sql);
		//물음표 값 셋팅!!!! 이거 잘 기억이 안나 시봉봉
		ps.setString(1, bankBookDTO.getBookname());
		ps.setDouble(2, bankBookDTO.getBookrate());
		ps.setLong(3, bankBookDTO.getBooknum());
		//
		int result  = ps.executeUpdate(); 
		
		DBConnector.disConnect(ps, con);
		
		return result;
		
	}
	
	public int setBankBook(BankBookDTO bankbookDTO)throws Exception{
		Calendar ca = Calendar.getInstance();
		Connection con = DBConnector.getConnection();
		String sql ="INSERT INTO BANKBOOK VALUES(?,?,?,1)";
		PreparedStatement ps = con.prepareStatement(sql);
		//?값 세팅해주기
		ps.setLong(1, ca.getTimeInMillis());
		ps.setString(2, bankbookDTO.getBookname());
		ps.setDouble(3, bankbookDTO.getBookrate());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}
	
	
	public ArrayList<BankBookDTO> getList()throws Exception{
		Connection con = DBConnector.getConnection();
		String sql =" SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<BankBookDTO> al = new ArrayList<BankBookDTO>();
		
		while(rs.next()) {
			bankBookDTO = new BankBookDTO();
			
			bankBookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBooksale(rs.getInt("BOOKSALE"));
			al.add(bankBookDTO);
		}
		
		DBConnector.disConnect(rs, ps, con);
		return al;
	}
	
	
	public int setChangeSale(BankBookDTO bankBookDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		int sale =1;
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM =?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(bankBookDTO.getBooksale() == 1) {
			sale = 0;
		}
		//?값 세팅
		ps.setInt(1, sale);
		ps.setLong(2, bankBookDTO.getBooknum());
		
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception{
		BankBookDTO bankBookDTO2 = null;
		
		Connection con = DBConnector.getConnection();
		String sql ="SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, bankBookDTO.getBooknum());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			
			bankBookDTO2.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBooksale(rs.getInt("BOOKSALE"));
			
		}
		DBConnector.disConnect(rs, ps, con);
		
		return bankBookDTO2;
	}

}
