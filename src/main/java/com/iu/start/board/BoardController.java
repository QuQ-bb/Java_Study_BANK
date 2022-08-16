package com.iu.start.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	//글작성
	@RequestMapping(value="add.jp", method = RequestMethod.GET)
	public void add(HttpSession session)throws Exception{
		System.out.println("Add get 실행");
		session.getAttribute("member");
	}
	
	@RequestMapping(value="add.jp", method=RequestMethod.POST)
	public String add(BoardDTO boardDTO)throws Exception{
		System.out.println("Add post 실행");
		
//		session.getAttribute(boardDTO.getWriter());
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.add(boardDTO);
		if(result ==1) {
			System.out.println("ADD 성공");
		}else {
			System.out.println("ADD 실패");
		}
		
		return "redirect:list.jp";
	}
	
	//글리스트
	@RequestMapping(value="list.jp", method=RequestMethod.GET)
	public String list(Model model)throws Exception{
		System.out.println("boad list 실행");
		ArrayList<BoardDTO> al = new ArrayList<BoardDTO>();
		BoardDAO boardDAO = new BoardDAO();
			al = boardDAO.list();
			model.addAttribute("list", al);
			
			return "board/list";
	}
	
	//글 상세
	@RequestMapping(value="detail.jp" , method= RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO,ModelAndView mv,HttpSession session)throws Exception{
		System.out.println("Detail 실행");
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.hitUpdate(boardDTO);
		if(result ==1) {
			System.out.println("HIT 증가");
		}else {
			System.out.println("HIT 안증가");
		}
		boardDTO = boardDAO.detail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("detail", boardDTO);
		session.getAttribute("member");
		
		return mv;
		
	}
	
	//글 수정
	@RequestMapping(value="update.jp",method= RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO,ModelAndView mv)throws Exception{
		System.out.println("UPDATE GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO = boardDAO.detail(boardDTO);
		mv.setViewName("/board/update");
		mv.addObject("update", boardDTO);
		
		return mv;
	}
	@RequestMapping(value="update.jp",method=RequestMethod.POST)
	public String update(BoardDTO boardDTO)throws Exception{
		System.out.println("UPDATE POST 실행");
		 System.out.println("num="+boardDTO);
		BoardDAO boardDAO =new BoardDAO();
//		  boardDTO = boardDAO.detail(boardDTO);
		  System.out.println("UPDATE POST 1");
		 int result = boardDAO.update(boardDTO);
		 System.out.println("UPDATE POST 2");
		 System.out.println("num="+boardDTO.getBoardNum());
		 
		 if(result ==1 ) {
			 System.out.println("UPDATE 성공");
		 }else {
			 System.out.println("UPDATE 실패");
		 }
		 return "redirect:detail.jp?boardNum="+boardDTO.getBoardNum();
	}
	
	//글삭제
	@RequestMapping(value="delete.jp", method=RequestMethod.GET)
	public String delete(BoardDTO boardDTO)throws Exception{
		System.out.println("DELETE 실행");
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.delete(boardDTO);
		
		if(result ==1) {
			System.out.println("DELETE 성공");
		}else {
			System.out.println("DELETE 실패");
		}
		
		return "redirect:list.jp";
	}
	//조회수 증가
//	@RequestMapping(value="detail.jp", method=RequestMethod.GET)
//	public void hitUpdate(BoardDTO boardDTO)throws Exception{
//		System.out.println("HIT 실행");
//		BoardDAO boardDAO = new BoardDAO();
//		
//		int result = boardDAO.hitUpdate(boardDTO);
//		if(result ==1) {
//			System.out.println("HIT 증가");
//		}else {
//			System.out.println("HIT 안증가");
//		}
//		
//	}

}
