package com.iu.start.bankBook;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

public class BookTestMain {

	@Autowired
	public static void main(String[] args) {

		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> al = new ArrayList<BankBookDTO>();
		Calendar ca = Calendar.getInstance();
		
		
		bankBookDTO.setBooknum(ca.getTimeInMillis());
//		bankBookDTO.setBookname("예금통장");
//		bankBookDTO.setBookrate(2.8);
		
		
		try {
			//삽입하기
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			if(result >0) {
//				System.out.println("INSERT 성공");
//			}else {
//				System.out.println("INSERT 실패");
//			}
			
			//리스트 뽑아오기
//			al = bankBookDAO.getList();
//			for(int i= 0; i<al.size(); i++) {
//				System.out.println(al.get(i).getBooknum());
//				System.out.println(al.get(i).getBookname());
//				System.out.println(al.get(i).getBookrate());
//				System.out.println(al.get(i).getBooksale());
//				System.out.println("=========================");
//			}
			
			bankBookDTO.setBooknum(3L);
			
			int result = bankBookDAO.setChangeSale(bankBookDTO);
			if(result >0) {
				System.out.println("UPDATE 성공");
			}else {
				System.out.println("UPDATE 실패");
			}
			
//			bankBookDTO.setBooknum(8L);
//			
//			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
//			
//			if(bankBookDTO != null) {
//				System.out.println(bankBookDTO.getBooknum()+"\t");
//				System.out.println(bankBookDTO.getBookname()+"\t");
//				System.out.println(bankBookDTO.getBookrate()+"\t");
//			}else {
//				System.out.println("존재하는 값이 없습니다.");
//			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
