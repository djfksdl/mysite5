package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//전체 리스트
	public List<BoardVo> boardList() {
		System.out.println("BoardDao.boardList");
		//sql에서 selectList로 받아오기
		List<BoardVo> bList = sqlSession.selectList("board.selectList");
		System.out.println(bList);
		
		//뿌리기위해 받은 list return해주기
		return bList;
		
	}
	//글쓰기 등록
	public void boardWrite(BoardVo boardVo) {
		System.out.println("BoardDao.boardWrite");
		
		//sqlSession에서 insert
		sqlSession.insert("board.insert",boardVo);
	}
	//게시글 눌렀을때
	public BoardVo boardSelectByNo(int no) {
		System.out.println("BoardDao.boardSelectByNo");
		
		//sqlSession에서 selectOnegotj vo로 가져오기
		BoardVo boardVo = sqlSession.selectOne("board.selectByNo", no);
		
		return boardVo;
	}
	//수정
	public void boardUpdate(BoardVo boardVo) {
		System.out.println("BoardDao.boardUpdate");
		
		//sqlSession에서 update문
		sqlSession.update("board.update", boardVo);
	}
	//삭제
	public void boardDelete(int no) {
		System.out.println("BoardDao.boardDelete");
		
		//sqlSession에서 delete문
		sqlSession.delete("board.delete", no);
	}
}
