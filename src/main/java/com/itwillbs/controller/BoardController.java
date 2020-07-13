package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.MemberBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	//객체생성 DI 의존관계 주입  부모인터페이스 =자식클래스(스프링에서 set통해서 주입)
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String insert() {
		// views/board/writeForm.jsp 이동
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String insertPost(BoardBean bb) {
		
		boardService.insertBoard(bb);
		return "redirect:/board/list";
	}
	
	// http://localhost:8080/myweb/board/list
	// http://localhost:8080/myweb/board/list?pageNum=
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model,HttpServletRequest request) {
		// PageBean pb 객체생성 
		PageBean pb=new PageBean();
		// 한화면에 보여줄 가져올 글 개수 설정 
		pb.setPageSize(10);
		// 현페이지 번호 가져오기  pageNum 파라미터 가져오기
		String pageNum=request.getParameter("pageNum");
		// 현페이지 번호가 없으면 "1"페이지로 설정
		if(pageNum==null) {
			pb.setPageNum("1");
		}else {
			pb.setPageNum(pageNum);
		}
		// List<BoardBean> boardList = getBoardList
		List<BoardBean> boardList= boardService.getBoardList(pb);
		// count  setCount() 호출시   pageCount  pageBlock startPage endPage 값 설정 
		pb.setCount(boardService.getBoardCount());
		// model 저장
		model.addAttribute("boardList",boardList);
		model.addAttribute("pb",pb);
		// views/board/list.jsp 이동
		return "/board/list";
	}
	
	// /board/content?num=${bb.num}&pageNum=${pb.pageNum}
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(Model model,HttpServletRequest request) {
		// num  pageNum  파라미터 가져오기
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		//조회수 증가
		
		// BoardBean bb  = getBoard(num)
		BoardBean bb=boardService.getBoard(num);
		
		// model 저장  bb, pageNum 
		model.addAttribute("bb",bb);
		model.addAttribute("pageNum",pageNum);
		
		// views/board/content.jsp 이동
		return "/board/content";
	}
	
}






