package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.member.BankMembersDAO;
import com.iu.start.member.BankMembersDTO;

public class TestMain {

	public static void main(String[] args) {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> al = new ArrayList<BankMembersDTO>();
//		bankMembersDTO.setUsername("ID3");
//		bankMembersDTO.setPassword("PW3");
//		bankMembersDTO.setName("돌맹이");
//		bankMembersDTO.setEmail("stone@gmail.com");
//		bankMembersDTO.setPhone("010-3333-3333");
		
		try {
//			int result =bankMembersDAO.setJoin(bankMembersDTO);
//			
//			if(result > 0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
			al = bankMembersDAO.getSearchByID("ID3");
			if(al.size()>0) {
				for(int i=0; i<al.size(); i++) {
					System.out.println(al.get(i).getUsername());
				}
			}else {
				System.out.println("false");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
