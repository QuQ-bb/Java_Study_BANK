package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value="list" , method =RequestMethod.GET)
	public String list(HttpServletRequest request)throws Exception {
		System.out.println("bankbook list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> al = bankBookDAO.getList();
		request.setAttribute("list", al);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method =RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO)throws Exception {
		System.out.println("bankbook detail 실행");
//		System.out.println("booknum =" + booknum);
//		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		 bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		
		return "bankbook/detail";
	}
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		System.out.println("add get 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO)throws Exception {
		System.out.println("add post 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result =bankBookDAO.setBankBook(bankBookDTO);
		
		if(result ==1) {
			System.out.println("삽입성공");
		}else {
			System.out.println("삽입실패");
		}
		return "bankbook/add";
	}

}
