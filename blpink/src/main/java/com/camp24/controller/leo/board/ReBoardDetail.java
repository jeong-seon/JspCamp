package com.camp24.controller.leo.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.ReBoardDao;
import com.camp24.vo.BoardVO;

public class ReBoardDetail implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/reviewBoardDetail";
		
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("bno");
		int rno = 0;
		if(sno != null) {
			rno = Integer.parseInt(sno);
		}
		//디테일 띄우기 위한 값
		rno = 100001;
		
		ReBoardDao rDao = new ReBoardDao();
		BoardVO bVO = rDao.getBoardDetail(rno);
		
		
		req.setAttribute("DATA", bVO);
		req.setAttribute("LIST", bVO.getList());
		req.setAttribute("NOWPAGE", spage);
		return view;
	}

}
