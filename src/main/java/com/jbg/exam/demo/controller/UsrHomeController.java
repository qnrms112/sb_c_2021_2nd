package com.jbg.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	private int count;
	
	public UsrHomeController() {
		count = -1;
	}

	@RequestMapping("/usr/home/getCount")
	@ResponseBody
	public int getCount() {
		return count;
	}
	
	@RequestMapping("/usr/home/dosetCount")
	@ResponseBody
	public String dosetCount(int count) {
		this.count = count;
		return "count 값이 " + this.count + "값으로 초기화 되었습니다.";
	}
	
	
	
}