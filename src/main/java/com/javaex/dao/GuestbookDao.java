package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자
	//메소드-gs
	//메소드-일반
	//전체 리스트 불러오기-메인화면
	public List<GuestbookVo> guestList() {
		System.out.println("GuestbookDao.guestList");
		
		//sqlSession에서 전체 리스트 받아오기
		List<GuestbookVo> gList= sqlSession.selectList("guestbook.selectList");
		System.out.println(gList);
		
		//리스트 리턴해서 뿌리기
		return gList;
		
	}
	//등록
	public void guestRegister(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestRegister");
		
		//sqlSession에서 insert 쿼리문 
		sqlSession.insert("guestbook.insert", guestbookVo);
	}
	
	//삭제
	public void guestDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestDelete");
		
		//sqlSession에서 delete쿼리문
		sqlSession.delete("guestbook.delete",guestbookVo );
		
		
	}
}
