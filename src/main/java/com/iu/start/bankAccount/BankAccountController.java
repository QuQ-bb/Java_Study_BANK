package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.member.BankMembersDTO;

@Controller
@RequestMapping(value="/bankAccount/*")
public class BankAccountController {

	private BankAccountDAO bankAccountDAO;
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value="add.jp", method=RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO,HttpSession session,Model model)throws Exception{
		System.out.println("Account Get 실행");
		System.out.println(bankAccountDTO.getBooknum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUsername(bankMembersDTO.getUsername());
		System.out.println(bankAccountDTO.getUsername());
		int result = bankAccountDAO.add(bankAccountDTO);
		if(result==1) {
			System.out.println("Account Join 성공");
		}else {
			System.out.println("Account Join 실패");
		}
		
		return "redirect:../bankbook/list.jp";
		
	}
	@RequestMapping(value="add.jp", method= RequestMethod.POST)
	public ModelAndView add(BankAccountDTO bankAccountDTO)throws Exception{
		System.out.println("Account Post 실행");
		ModelAndView mv= new ModelAndView();
//		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		
		int result = bankAccountDAO.add(bankAccountDTO);
		
		mv.setViewName("redirect:../bankbook/list.jp");
		mv.addObject("ac", bankAccountDAO);
		
		
		
		return mv;
	}
}
