package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO)throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKACCOUNT VALUES(ACCOUNT_SEQ.NEXTVAL,?,?,SYSDATE)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bankAccountDTO.getUsername());
		ps.setLong(2, bankAccountDTO.getBooknum());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
	}

}
