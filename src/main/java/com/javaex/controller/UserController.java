package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//로그인폼
	@RequestMapping(value="/user/loginform" , method={RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		return "user/loginForm";
	}
	//로그인
	//http://localhost:8080/mysite5/user/login?id=aaa&password=1234(pw주의!)
	@RequestMapping(value="/user/login" , method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {//UserVo의 디폴트 생성자에 setId,setPassword로 넣어줌.-> jsp에서 name값이 pw로 쓰면 setPw()로 되어서 값이 안나올 수 있음.
		System.out.println("UserController.login()");
		//(id pw)vo->vo는 계속 쓰일거같으니 map보다 vo로 묶는게 나을것!
		//System.out.println(userVo);// 담아지는거 꼭 확인하고 넘어가기
		
		//service에게 보낸다. -> vo(no name)받는다. -> 세션에 저장한다.
		UserVo authUser= userService.exeLogin(userVo);
		session.setAttribute("authUser", authUser); //(별명,주소)
		
		//성공하면 메인으로 리다이렉트
		
		return "redirect:/main";
//		return "/user/loginOk";
	}
	//로그아웃
	//http://localhost:8080/mysite5/user/logout
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session ) {
		System.out.println("UserController.logout()");
		
		//세션에서 주소를 가져온다(HttpSession session)
		//주소를 날린다.
		session.invalidate();
		//메인으로 리다이렉트
		return "redirect:/main";
	}
	//회원가입폼
	//http://localhost:8080/mysite5/user/joinform
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinform() {
		System.out.println("UserController.joinform");
		//회원가입 폼으로 포워드
		return "user/joinForm";
	}
	//회원가입
	//http://localhost:8080/mysite5/user/join&id=ddd&password=ddd&name=ddd&gender=woman
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {// UserVo로 묶어서 받기
		System.out.println("UserController.join");
		
		//서비스로 userVo보내기
		userService.exeJoin(userVo);
		
		//메인페이지로 리다이렉트
		return "redirect:/main";
	}
	//회원정보 수정폼
	//http://localhost:8080/mysite5/user/mform&no=3(세션에서 가져온 no)
	@RequestMapping(value="/user/mform", method= {RequestMethod.GET, RequestMethod.POST})
	public String mform(HttpSession session, Model model) {		
		System.out.println("UserController.mform");
		
		//세션에서 주소 가져오고, no 가져오기
		UserVo num = (UserVo)session.getAttribute("authUser");
		int no = num.getNo();
		
		//no가지고 서비스로 넘기기
		UserVo userVo= userService.exeMform(no);
		
		//받은 주소값을 Attribute에 넣기
		model.addAttribute("userVo", userVo);
		System.out.println(userVo);
		
		//회원정보 수정폼으로 포워드
		return"user/modifyForm";
	}
	//회원정보 수정
	//http://localhost:8080/mysite5/user/modify&password=ljh&name=ljh&gender=female& no=3(세션 no)
	@RequestMapping(value="/user/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@RequestParam(value="password") String password
						 ,@RequestParam(value="name") String name
						 ,@RequestParam(value="gender") String gender
						 ,HttpSession session) {//password=ljh&name=ljh&gender=female&no=3(세션no)
		System.out.println("UserController.modify");
		//하나씩 받는거 말고 userVo로 받고, 나중에 session으로 받은건 setter로 추가해주면 된다!예시 BoardController(글쓰기)에 있음
		
		//session에서 no꺼내서 userVo와 함께 묶기
		UserVo uVo =(UserVo)session.getAttribute("authUser");
		int num = uVo.getNo();
		
		UserVo userVo = new UserVo(num, password, name, gender);
		System.out.println(userVo);
		//서비스로 묶은거 넘기기
		userService.exeModify(userVo);
		
		//세션에 이름 바꿔준다
		((UserVo)session.getAttribute("authUser")).setName(name) ;
		
		//메인화면으로 리다이렉트
		return "redirect:/main";
	}
	
	
}
