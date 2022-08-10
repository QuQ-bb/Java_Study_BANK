package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value="list" , method =RequestMethod.GET)
	public String list(Model model)throws Exception {
		
//		ModelAndView mv = new ModelAndView();
		System.out.println("bankbook list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> al = bankBookDAO.getList();
		model.addAttribute("list", al);
//		request.setAttribute("list", al);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method =RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO)throws Exception {
		System.out.println("bankbook detail 실행");
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
	
		return mv;
	}
	
	//void return 형태로 쓸떄는 value 값에 있는 걸로 url요청을 한다
	//요청 url이  /bankbook/add  return값도 /bankbook/add로 같다면 리턴하지않고 void 를 사용할 수 있다.
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		System.out.println("add get 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO)throws Exception {
		System.out.println("add post 실행");
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result =bankBookDAO.setBankBook(bankBookDTO);
		
		if(result ==1) {
			System.out.println("삽입성공");
		}else {
			System.out.println("삽입실패");
		}
		mv.setViewName("redirect:list");
		
		return mv;
	}

}
