package com.jbg.exam.demo.vo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.jbg.exam.demo.service.MemberService;
import com.jbg.exam.demo.util.Ut;

import lombok.Getter;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Rq {

	@Getter
	private boolean isLogined;
	@Getter
	private int loginedMemberId;
	@Getter
	private Member loginedMember;

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	private Map<String, String> paramMap;

	public Rq(HttpServletRequest req, HttpServletResponse resp, MemberService memberService) {
		this.req = req;
		this.resp = resp;

		paramMap = Ut.getParamMap(req);

		this.session = req.getSession();

		boolean isLogined = false;
		int loginedMemberId = 0;
		Member loginedMember = null;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginedMemberId);
		}

		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
		this.loginedMember = loginedMember;

		this.req.setAttribute("rq", this);
	}

	public void printReplaceJs(String msg, String url) {
		resp.setContentType("text/html; charset=UTF-8");

		print(Ut.jsReplace(msg, url));
	}

	public void printHistoryBackJs(String msg) {
		resp.setContentType("text/html; charset=UTF-8");

		print(Ut.jsHistoryBack(msg));
	}

	public void print(String str) {
		try {
			resp.getWriter().append(str);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void println(String str) {
		print(str + "\n");
	}

	public void login(Member member) {
		session.setAttribute("loginedMemberId", member.getId());
	}

	public void logout() {
		session.removeAttribute("loginedMemberId");
	}

	public boolean isNotLogined() {
		return !isLogined;
	}

	public String historyBackJsOnView(String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		return "common/js";
	}
	
	public String jsHistoryBack(String resultCode, String msg) {
		msg = String.format("[%s] %s", resultCode, msg);
		return Ut.jsHistoryBack(msg);
	}

	public String jsHistoryBack(String msg) {
		return Ut.jsHistoryBack(msg);
	}

	public String jsReplace(String msg, String url) {
		return Ut.jsReplace(msg, url);
	}

	public String getCurrentUri() {
		String currentUri = req.getRequestURI();
		String queryString = req.getQueryString();

		if (queryString != null && queryString.length() > 0) {
			currentUri += "?" + queryString;
		}

		return currentUri;
	}

	public String getEncodedCurrentUri() {
		return Ut.getUriEncoded(getCurrentUri());
	}

	// 이 메서드는 rq객체가 자연스럽게 생성되게 해주는 역할을 함
	public void initOnBeforeActionInterceptor() {

	}

	public String getLoginUri() {
		return "../member/login?afterLoginUri=" + getAfterLoginUri();
	}
	
	public String getJoinUri() {
		return "../member/join?afterLoginUri=" + getAfterLoginUri();
	}

	public String getLogoutUri() {
		return "../member/doLogout?afterLogoutUri=" + getAfterLogoutUri();
	}

	public String getAfterLoginUri() {
		String requestUri = req.getRequestURI();

		switch (requestUri) {
		case "/usr/member/login":
		case "/usr/member/join":
		case "/usr/member/findloginId":
		case "/usr/member/findloginPw":
			return Ut.getUriEncoded(Ut.getStrAttr(paramMap, "afterLoginUri", ""));
		}

		return getEncodedCurrentUri();
	}

	public String getAfterLogoutUri() {
		String requestUri = req.getRequestURI();
		
		//로그아웃후 메인 이동 
		/*
		switch (requestUri) {
		case "/usr/article/write":
			return "";
		}
		*/

		return getEncodedCurrentUri();
	}
	
	public String getArticleDetailUriFormArticleList(Article article) {
		return "../article/detail?id=" + article.getId() + "&listUri=" + getEncodedCurrentUri();
	}

}
