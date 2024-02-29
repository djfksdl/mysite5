package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	//필드
	@Autowired
	private UserDao userDao;
	//생성자
	//메소드-gs
	//메소드-일반
	public void exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin");
		
		userDao.userSelectByIdPw(userVo);
	}
}
