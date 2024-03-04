package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	//필드
	@Autowired
	private GuestbookService guestbookService;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//방명록 메인
	//http://localhost:8080/mysite5/gbc/alform
	@RequestMapping(value="/gbc/alform" , method= {RequestMethod.GET, RequestMethod.POST})
	public String alform(Model model) {
		System.out.println("GuestbookController.alform");
		
		//서비스로 가서 전체 리스트 불러오기 
		List<GuestbookVo> guestList= guestbookService.exeList();
		System.out.println("리스트 불러오기 완료:"+guestList);
		
		//model에 올려서 뿌려주기
		model.addAttribute("guestList", guestList);
		
		//포워드
		return "guestbook/addList";
	}
	
	//등록
	//http://localhost:8080/mysite5/gbc/register&name=보리&password=보리&content=보리
	@RequestMapping(value="/gbc/register", method= {RequestMethod.GET, RequestMethod.POST})
	public String register(@ModelAttribute GuestbookVo guestbookVo) {//이름,비번,내용--->현재시간은 들어가는건가?ㅇㅇ 그럴듯
		System.out.println("GuestbookController.register");
		
		//서비스에 guestbookVo넣어서 전달하기
		guestbookService.exeRegister(guestbookVo);
		
		//alform으로 리다이렉트
		return "redirect:/gbc/alform";
	}
	
	//삭제폼
	//http://localhost:8080/mysite5/gbc/dform&no(jsp에 숨기기)
	@RequestMapping(value="/gbc/dform", method= {RequestMethod.GET, RequestMethod.POST})
	public String dform() {
		System.out.println("GuestbookController.dform");
		
		//deleteForm으로 포워드
		return "guestbook/deleteForm";
	}
	//삭제
	//http://localhost:8080/mysite5/gbc/delete?no=3&password=123
	@RequestMapping(value="/gbc/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {//no와 pw받기
		System.out.println("GuestbookController.delete");
		//서비스로 guestbookVo묶은 id,pw보내기
		guestbookService.exeDelete(guestbookVo);
		//alform으로 리다이렉트
		return "redirect:/gbc/alform";
	}
	
}
