package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardDAO {
		//추상메서드
		public void insertBoard(BoardBean bb);
		public Integer getMaxNum();
//		public List<BoardBean> getBoardList();
		public List<BoardBean> getBoardList(PageBean pb);
		public Integer getBoardCount();
		public BoardBean getBoard(int num);
}
