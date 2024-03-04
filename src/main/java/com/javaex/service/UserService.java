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
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin");
		
		UserVo authUser = userDao.userSelectByIdPw(userVo);
		System.out.println(authUser);
		
		return authUser;
	}
	//회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("UserService.exeJoin");
		
		//Dao에 userVo보내기
		int count = userDao.userInsert(userVo);
		return count;
	}
	//회원정보 수정 폼
	public UserVo exeMform(int no) {
		System.out.println("UserService.exeMform");
		//Dao에 session no보내기
		UserVo userVo = userDao.userSelectByNo(no);
		return userVo;
		
	}
	//회원정보 수정
	public int exeModify(UserVo userVo) {
		System.out.println("UserService.exeModify");
		
		//Dao에 userVo넣어서 넘기기
		int count = userDao.userUpdate(userVo);
		return count;
		
	}
}
