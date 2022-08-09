package com.iu.start.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
//		
		
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			if(result == 1) {
				System.out.println("삽입성공");
			}else{
				System.out.println("삽입실패");
			}
			
		
		return "member/join";
	}
}
