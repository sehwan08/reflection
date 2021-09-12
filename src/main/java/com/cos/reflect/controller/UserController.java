package com.cos.reflect.controller;

import com.cos.reflect.anno.RequestMapping;
import com.cos.reflect.controller.dto.JoinDto;
import com.cos.reflect.controller.dto.LoginDto;
import com.cos.reflect.model.User;

public class UserController {
	
	@RequestMapping("/user/join")
	public String join(JoinDto dto) {
		System.out.println("join() 함수 호출 됨");
		System.out.println(dto);
		System.out.println("----------------");
		return "/";
	}
	
	@RequestMapping("/user/login")
	public String login(LoginDto dto) {
		System.out.println("login() 함수 호출 됨");
		System.out.println(dto);
		System.out.println("----------------");
		return "/";
	}
	
	@RequestMapping("/user/list")
	public String list(User user) {
		System.out.println("list() 함수 호출 됨");
		System.out.println(user);
		System.out.println("----------------");
		return "/";
	}
	
	@RequestMapping("/user")
	public String user() {
		System.out.println("user() 함수 호출 됨");
		System.out.println("----------------");
		return "/";
	}
	
	@RequestMapping("/register")
	public String register() {
		System.out.println("register() 함수 호출 됨");
		System.out.println("----------------");
		return "/register.jsp";
	}
}
