package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class BoardServiceImpl implements BoardService{
	//객체생성 DI 의존관계 주입  부모인터페이스 =자식클래스(스프링에서 set통해서 주입)
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardBean bb) {
		// name,pass,subject,content 폼에서 담아 옴
		// num,readcount,date, file,re_ref,re_lev,re_seq
		bb.setNum(boardDAO.getMaxNum()+1); // 디비 최대num +1
		bb.setReadcount(0); //조회수 
		bb.setDate(new Timestamp(System.currentTimeMillis())); //날짜
		bb.setRe_ref(boardDAO.getMaxNum()+1); //그룹번호 일반글 번호 == 그룹번호 
		bb.setRe_lev(0); // 들여쓰기
		bb.setRe_seq(0); // 답글순서
		
		boardDAO.insertBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// pageSize, pageNum 저장
		// pageNum => 정수형으로 변경
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// 10개씩 잘라서 1페이지 시작하는 행번호 구하기
//		int startRow=(currentPage-1)*pageSize+1; 디비단 -1
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
//		int endRow=currentPage*pageSize;
		return boardDAO.getBoardList(pb);
	}

	@Override
	public Integer getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public BoardBean getBoard(int num) {
		return boardDAO.getBoard(num);
	}

}




