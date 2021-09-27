package com.jbg.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbg.exam.demo.service.MemberService;
import com.jbg.exam.demo.util.Ut;
import com.jbg.exam.deom.vo.Member;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;

	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		
		if (Ut.empty(loginId)) {
			return "loginId(을)를 입력해주세요.";
		}
		
		if (Ut.empty(loginPw)) {
			return "loginPw(을)를 입력해주세요.";
		}
		
		if (Ut.empty(name)) {
			return "name(을)를 입력해주세요.";
		}
		
		if (Ut.empty(nickname)) {
			return "nickname(을)를 입력해주세요.";
		}
		
		if (Ut.empty(cellphoneNo)) {
			return "cellphoneNo(을)를 입력해주세요.";
		}
		
		if (Ut.empty(email)) {
			return "email(을)를 입력해주세요.";
		}
		
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if (id == -1) {
			return "해당 로그인아이디는 이미 사용중입니다.";
		}
		
		Member member = memberService.getMemberById(id);
		
		return member;
	}
	
	

}
