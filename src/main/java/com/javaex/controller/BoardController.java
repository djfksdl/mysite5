package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
public class BoardController {
	//필드
	@Autowired
	private BoardService boardService;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//게시판 메인
	//http://localhost:8080/mysite5/board/list
	@RequestMapping(value="/board/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list");
		
		//서비스에서 리스트 받아오기
		List<BoardVo> boardList = boardService.exeList();
		
		//받은 값 넣어주기 
		model.addAttribute("boardList", boardList);
		
		//포워드
		return "/board/list";
		
	}
	
	//글쓰기폼
	//http://localhost:8080/mysite5/board/writeform
	@RequestMapping(value="/board/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeform() {
		System.out.println("BoardController.writeform");
		
		//로그인 되어있으니까 언제든 session가져올 수 있음. 따라서 no굳이 안가져와도됨.jsp에도 안숨겨도 됨.그냥 글 쓰고나서 session가져오면 되니까
		//포워드
		return "/board/writeForm";
	}
	//글쓰기- 제목,내용
	//http://localhost:8080/mysite5/board/write?title=겜블러&content=겜블러&no=세션에서 가져온 no
	@RequestMapping(value="/board/write" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo
					 ,HttpSession session) {
		System.out.println("BoardController.write");
		
		
		//세션에서 no가져오기
		UserVo bVo= (UserVo)session.getAttribute("authUser");
		int num = bVo.getNo();
		
		//boardVo session에서 가져온 no 추가
		boardVo.setUser_no(num);
		
		//서비스로 묶은 vo보내주기
		boardService.exeWrite(boardVo);
		
		//list로 리다이렉트
		return "redirect:/board/list";
		
	}
	//게시글 눌렀을때
	//http://localhost:8080/mysite5/board/read
	@RequestMapping(value="/board/read" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value="no")int no, Model model) {//파라미터에서 글 no를 가져와야함. 
		System.out.println("BoardController.read");
		
		//서비스로 no보내서 한 정보 가져오기
		BoardVo boardVo= boardService.exeSelectByNo(no);

		//attribute에 넣기
		model.addAttribute(boardVo);
		
		//포워드
		return "/board/read";
	}
	//수정폼
	//http://localhost:8080/mysite5/board/mform
	@RequestMapping(value="/board/mform",method= {RequestMethod.GET, RequestMethod.POST} )
	public void mform(@RequestParam(value="no")int no) {//no를 받아야함. 
		System.out.println("BoardController.mform");
		
		//
		
	}
	//수정
	//http://localhost:8080/mysite5/board/modify
	@RequestMapping(value="/board/modify",method= {RequestMethod.GET, RequestMethod.POST} )
	public void modify() {
		System.out.println("BoardController.modify");
	}
	//삭제
	//http://localhost:8080/mysite5/board/delete
	@RequestMapping(value="/board/delete",method= {RequestMethod.GET, RequestMethod.POST} )
	public void delete() {
		System.out.println("BoardController.delete");
	}
}
