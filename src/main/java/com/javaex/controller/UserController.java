package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	//필드
	@Autowired
	private UserService userService;
	//생성자
	//메소드-gs
	//메소드-일반
	@RequestMapping(value="/user/loginform" , method={RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		return "/user/loginForm";
	}
	@RequestMapping(value="/user/login" , method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo) {//UserVo에서 setId,setPasswordf로 넣어줌.-> jsp에서 name값이 pw로 쓰면 setPw()로 되어서 값이 안나올 수 있음.
		System.out.println("UserController.login()");
		//(id pw)vo->vo는 계속 쓰일거같으니 map보다 4:45
		//System.out.println(userVo);// 담아지는거 꼭 확인하고 넘어가기
		
		//service에게 보낸다. -> vo(no name)받는다. -> 세션에 저장한다.
		userService.exeLogin(userVo);
		
		//성공하면 메인으로 리다이렉트
		
		return "";
//		return "/user/loginOk";
	}
	
}
