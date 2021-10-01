package com.jbg.exam.demo.service;

import org.springframework.stereotype.Service;

import com.jbg.exam.demo.repository.MemberRepository;
import com.jbg.exam.deom.vo.Member;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		Member oldMember = getMemberByLoginId(loginId);
		
		if (oldMember != null) {
			return -1;
		}
		
		oldMember = getMemberByNameAndEmail(name,email);
		
		if (oldMember != null) {
			return -2;
		}
		
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		return memberRepository.getLastInsertId();
	
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

}
