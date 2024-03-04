package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//전체 리스트 불러오기-메인화면
	public List<GuestbookVo> exeList() {
		System.out.println("GuestbookService.exeList");
		
		//Dao연결하기
		List<GuestbookVo> guestList = guestbookDao.guestList();
		return guestList;
	}
	//등록
	public void exeRegister(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeRegister");
		
		//Dao로 guestbookVo전달
		guestbookDao.guestRegister(guestbookVo);
	}
	
	//삭제
	public void exeDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeDelete");
		
		//Dao로 guestbookVo전달
		guestbookDao.guestDelete(guestbookVo);
	}
}
