package com.camp24.controller.leo.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.*;

public class ReBoardDelete implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/redirect";
		
		//할일
		// 파라미터 받고(reboardList.jsp 밑에 form에서 넘어옴)
		String sno = req.getParameter("rno");
		String spage = req.getParameter("nowPage");
		int rno = Integer.parseInt(sno);
		
		//데이터베이스 작업
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.DelReview(rno);
		
		req.setAttribute("VIEW", "/camp24/board/reBoardList.cmp");
		req.setAttribute("NOWPAGE", spage);
		
		return view;
	}

}
