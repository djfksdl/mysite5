package com.javaex.dao;

import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	//필드
	//생성자
	//메소드-gs
	//메소드-일반
	
	//로그인
	public void userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		System.out.println(userVo);
		//여기서부터 db사용이 되어야하기 때문에 추가셋팅 필요!
		
	}
}
