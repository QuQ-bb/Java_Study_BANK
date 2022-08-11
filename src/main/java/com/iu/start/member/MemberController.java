package com.iu.start.member;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 이 클래스는 Controller역할, 
//container(생명주기 관리)에게 이 클래스의 객체를 생성 위임 (== 네가 만들어주셈 뿌!!!!!)
@Controller	
@RequestMapping(value="/member/*")
public class MemberController {
	
	// annotation
	// @ : 설명 + 실행 하라는 것을 내포중
	
	// /member/login
	@RequestMapping(value=" login")  //요청에 대한 mapping
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	@RequestMapping(value=" login", method=RequestMethod.POST)  //요청에 대한 mapping
	public String login(BankMembersDTO bankMembersDTO,Model model)throws Exception {
		System.out.println("로그인 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		bankMembersDTO =  bankMembersDAO.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO.getUsername());
		System.out.println(bankMembersDTO.getName());
		if(bankMembersDTO != null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		model.addAttribute("login", bankMembersDTO);
		//"redirect: 다시접속할 URL주소(절대경로,상대경로);
		return "redirect:/";
	}

	//Controller에 넣는 value는 절대경로로 작성해야함
	
	// join /member/join GET 
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 get 실행");
		
		return "member/join";
	}
	
	//POST
	@RequestMapping(value ="join" , method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO)throws Exception { //달라 4달라
		System.out.println("회원가입 post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			if(result == 1) {
				System.out.println("삽입성공");
			}else{
				System.out.println("삽입실패");
			}
		
		return "redirect:login";
	}
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public void getSearchByID() {
		System.out.println("search get 실행");
		//리턴파일 ModelAndView일 때
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("member/search");
		//return mv; 
		//리턴타입 String으로 할 시에
		//return "member.search";
		
	}
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public ModelAndView getSearchByID(String username)throws Exception {
		System.out.println("search post 실행");
		ModelAndView mv = new ModelAndView();
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> al = bankMembersDAO.getSearchByID(username);
		mv.setViewName("member/list");
		mv.addObject("search", al);
		
			System.out.println("username="+username);
		
		return mv;
	}
}
