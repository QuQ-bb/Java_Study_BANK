package com.iu.start.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO {
	BankMembersDTO bankMembersDTO = null;
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.sql문
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";
		
		//3.전송해줘버리기
		PreparedStatement ps = con.prepareStatement(sql);
		//4.?셋팅해주기
		ps.setString(1,bankMembersDTO.getUsername());
		ps.setString(2, bankMembersDTO.getPassword());
		ps.setString(3, bankMembersDTO.getName());
		ps.setString(4, bankMembersDTO.getEmail());
		ps.setString(5, bankMembersDTO.getPhone());

		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}

	public ArrayList<BankMembersDTO> getSearchByID(String search)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql ="SELECT USERNAME FROM BANKMEMBERS WHERE USERNAME LIKE '%'||?||'%' ORDER BY USERNAME ASC";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+search+"%");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankMembersDTO> al = new ArrayList<BankMembersDTO>();
		
		while(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			al.add(bankMembersDTO);
		}
		
		DBConnector.disConnect(rs, ps, con);
		return al;
	}


}
