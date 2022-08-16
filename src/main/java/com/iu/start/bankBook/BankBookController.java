package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value="list.jp" , method =RequestMethod.GET)
	public String list(Model model)throws Exception {
		
//		ModelAndView mv = new ModelAndView();
		System.out.println("bankbook list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> al = bankBookDAO.getList();
		model.addAttribute("list", al);
//		request.setAttribute("list", al);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail.jp", method =RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO,HttpServletRequest request)throws Exception {
		System.out.println("bankbook detail 실행");
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
//		mv.addObject("detail", bankBookDTO);
		request.setAttribute("detail", bankBookDTO);
	
		return mv;
	}
	
	//void return 형태로 쓸떄는 value 값에 있는 걸로 url요청을 한다
	//요청 url이  /bankbook/add  return값도 /bankbook/add로 같다면 리턴하지않고 void 를 사용할 수 있다.
	@RequestMapping(value="add.jp", method=RequestMethod.GET)
	public String add() {
		System.out.println("add get 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value="add.jp", method=RequestMethod.POST)
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
		mv.setViewName("redirect:list.jp");
		
		return mv;
	}
	
	@RequestMapping(value="update.jp", method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model)throws Exception{
		System.out.println("UPDATE GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		//booknum을 갖고 있는 detail다 가져오려고 메서드 가져와서 쓰기
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBooknum());
		System.out.println(bankBookDTO.getBookname());
		System.out.println(bankBookDTO.getBookrate());
		
		model.addAttribute("update", bankBookDTO);
	}
	
	@RequestMapping(value="update.jp" , method= RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO)throws Exception{
		System.out.println("update post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setUpdate(bankBookDTO);
		
		if(result == 1) {
			System.out.println("update 성공");
		}else {
			System.out.println("update 실패");
		}
		return "redirect:detail.jp?booknum="+bankBookDTO.getBooknum();
	}
	@RequestMapping(value="delete.jp" , method =RequestMethod.GET)
	public String  delete(BankBookDTO bankBookDTO)throws Exception{
		System.out.println("DELETE 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result =bankBookDAO.setDelete(bankBookDTO);
		
		if(result == 1) {
			System.out.println("DELETE 성공");
		}else {
			System.out.println("DELETE 실패");
		}
		
		return "redirect:list.jp";
	}

}
