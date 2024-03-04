package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	//필드
	@Autowired
	private BoardDao boardDao;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//전체 리스트
	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList");
		
		//Dao에서 리스트 받아오기
		List<BoardVo> bList = boardDao.boardList();
		
		return bList;
	}
	//글쓰기 등록
	public void exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite");
		
		//Dao에 boardVo 전달하기
		boardDao.boardWrite(boardVo);
	}
	//게시글 눌렀을때
	public BoardVo exeSelectByNo(int no) {
		System.out.println("BoardService.exeSelectByNo");
		
		//Dao에 no전달하기
		BoardVo boardVo= boardDao.boardSelectByNo(no);
		return boardVo;
	}
}
