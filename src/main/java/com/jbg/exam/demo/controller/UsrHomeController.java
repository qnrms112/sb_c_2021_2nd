package com.jbg.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller
public class UsrHomeController {

	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
	
	@RequestMapping("/usr/home/getInt")
	@ResponseBody
	public int getInt() {
		return 10;
	}
	
	@RequestMapping("/usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 10.5f;
	}
	
	@RequestMapping("/usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 10.5;
	}
	
	@RequestMapping("/usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return true;
	}
	
	@RequestMapping("/usr/home/getCharacter")
	@ResponseBody
	public char getCharacter() {
		return 'a';
	}
	
}



