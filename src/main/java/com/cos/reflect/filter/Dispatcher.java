package com.cos.reflect.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.reflect.filter.anno.RequestMapping;
import com.cos.reflect.filter.controller.UserController;

public class Dispatcher implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
//		System.out.println("컨텍스트패스: "+request.getContextPath());
//		System.out.println("식별자 주소: "+request.getRequestURI());
//		System.out.println("전체 주소: "+request.getRequestURL());
		
		String endPoint = request.getRequestURI().replaceAll(request.getContextPath(), "");
		System.out.println("엔드포인트-> "+endPoint);
		
		UserController userController = new UserController();
		Method[] methods = userController.getClass().getDeclaredMethods();// 그 파일에 메서드만!!
		for (Method method : methods) {
			Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping requestMapping = (RequestMapping)annotation;
			System.out.println(requestMapping.value());
			
			if(requestMapping.value().equals(endPoint)) {
				try {
					String path = (String)method.invoke(userController);
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
