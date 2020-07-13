package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	// 기존 자바 객체생성
//	MemberService memberService=new MemberServiceImpl();
	// 자동객체생성 : xml에서 MemberServiceImpl객체생성 set메서드 호출해서 값주입
	@Inject
	private MemberService memberService;
	//가상주소 http://localhost:8080/myweb2/member/insert
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// views/member/insertForm.jsp 이동
		return "/member/insertForm";
	}
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
		System.out.println(mb.getId());
		// 디비작업  MemberServiceImple -> MemberDAOImpl 객체생성 메서드호출
		memberService.insertMember(mb);
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// views/member/loginForm.jsp 이동
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb,HttpSession session,Model model) {
		System.out.println(mb.getId());
		// 디비작업  MemberServiceImple -> MemberDAOImpl 객체생성 메서드호출
		MemberBean mb2=memberService.userCheck(mb);
		if(mb2!=null) {
			// 아이디 비밀번호 일치 세션값 생성  "id",mb.getId()
			session.setAttribute("id", mb.getId());
			return "redirect:/member/main";
		}else {
			// 아이디 없음, 비밀번호 틀림
			model.addAttribute("msg","입력하신 정보가 일치하지 않습니다.");
			// views/member/msg.jsp 이동
			return "/member/msg";
		}
	}
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// views/member/main.jsp 이동
		return "/member/main";
	}
	
	// /member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션값 초기화
		session.invalidate();
		//  가상주소  /member/main 이동
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session,Model model) {
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// MemberBean mb  = getMember(id)
		MemberBean mb=memberService.getMember(id);
		// model 담아서 
		model.addAttribute("mb",mb);
		// views/member/info.jsp 이동
		return "/member/info";
	}
	
	// /member/update
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session,Model model) {
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// MemberBean mb  = getMember(id)
		MemberBean mb=memberService.getMember(id);
		// model 담아서 
		model.addAttribute("mb",mb);
		// views/member/updateForm.jsp 이동
		return "/member/updateForm";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String updatePost(MemberBean mb,Model model) {
		System.out.println(mb.getId());
		// 디비작업  MemberServiceImple -> MemberDAOImpl 객체생성 메서드호출
		MemberBean mb2=memberService.userCheck(mb);
		if(mb2!=null) {
			// 아이디 비밀번호 일치  
			// updateMember(mb) 호출
			memberService.updateMember(mb);
			return "redirect:/member/main";
		}else {
			// 아이디 없음, 비밀번호 틀림
			model.addAttribute("msg","입력하신 정보가 일치하지 않습니다.");
			// views/member/msg.jsp 이동
			return "/member/msg";
		}
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// views/member/deleteForm.jsp 이동
		return "/member/deleteForm";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String deletePost(MemberBean mb,Model model,HttpSession session) {
		System.out.println(mb.getId());
		// 디비작업  MemberServiceImple -> MemberDAOImpl 객체생성 메서드호출
		MemberBean mb2=memberService.userCheck(mb);
		if(mb2!=null) {
			// 아이디 비밀번호 일치  
			// deleteMember(mb) 호출
			memberService.deleteMember(mb);
			//세션값 초기화
			session.invalidate();
			return "redirect:/member/main";
		}else {
			// 아이디 없음, 비밀번호 틀림
			model.addAttribute("msg","입력하신 정보가 일치하지 않습니다.");
			// views/member/msg.jsp 이동
			return "/member/msg";
		}
	}
	
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		// List<MemberBean> mbList  = getMemberList()
		List<MemberBean> mbList=memberService.getMemberList();
		// model 담아서 
		model.addAttribute("mbList",mbList);
		// views/member/list.jsp 이동
		return "/member/list";
	}
	
	
}



