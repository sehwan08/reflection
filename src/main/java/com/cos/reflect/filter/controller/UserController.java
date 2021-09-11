package com.cos.reflect.filter.controller;

import com.cos.reflect.filter.anno.RequestMapping;

public class UserController {
	
	@RequestMapping("/join")
	public String join() {
		System.out.println("join() 함수 호출 됨");
		System.out.println("----------------");
		return "/";
	}
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("login() 함수 호출 됨");
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
