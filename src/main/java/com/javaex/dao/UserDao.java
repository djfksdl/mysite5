package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	//필드
	@Autowired
	private SqlSession sqlSession ;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		//System.out.println(userVo);
		//여기서부터 db사용이 되어야하기 때문에 추가셋팅 필요!
		
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);//UserVo로 받으면 이름 겹쳐서 안됨. 세션에 넣을꺼지까 authUser
		//System.out.println(authUser);
		
		return authUser;
		// return sqlSession.selectOne("user.selectByIdPw", userVo); 이렇게 한번만 쓰는 경우도 있음-> 단점: 찍어볼 수가 없다.
		
	}
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		int count = sqlSession.insert("user.insert", userVo);
		return count;
	}
	
	//회원정보 수정폼
	public UserVo userSelectByNo(int no) {
		System.out.println("UserDao.userSelectByNo");
		
		UserVo userVo = sqlSession.selectOne("user.selectByNo", no);
		System.out.println(userVo);
		return userVo;
	}
	
	//회원정보 수정
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate");
		
		int count = sqlSession.update("user.update", userVo);
		return count;
	}
}
