package com.jbg.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jbg.exam.deom.vo.Rq;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		Rq rq = new Rq(req);
		
		req.setAttribute("rq", rq);

		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}