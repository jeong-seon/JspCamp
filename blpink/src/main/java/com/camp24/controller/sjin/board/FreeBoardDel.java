package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.FreeBoardDao;

public class FreeBoardDel implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/freeBoard/redirect";
		
		// 할 일
		// 파라미터 받고
		String sno = req.getParameter("fbno");
		String spage = req.getParameter("nowPage");
		int fbno = Integer.parseInt(sno);
		
		// 데이터베이스 작업
		FreeBoardDao fDao = new FreeBoardDao();
		int cnt = fDao.delFreeBoard(fbno);
		
		req.setAttribute("VIEW", "/camp24/freeBoard/freeBoardList.cmp");
		req.setAttribute("NOWPAGE", spage);
		
		if(cnt == 0) {
			// 실패한 경우
			req.setAttribute("MSG", sno + "번글 삭제 작업이 실패했습니다.");
		} else {
			// 성공한 경우
			req.setAttribute("MSG", sno + "번글 삭제 작업이 성공했습니다.");
		}
		return view;
	}

}
