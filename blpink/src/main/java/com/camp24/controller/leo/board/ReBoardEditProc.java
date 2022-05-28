package com.camp24.controller.leo.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.ReBoardDao;

public class ReBoardEditProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/camp24/member/login.cmp";
		}
		
		String view = "board/redirect";
		
		//파라미터 받고
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("rno");
		String body = req.getParameter("body");
		int rno = Integer.parseInt(sno);
		
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.editReboard(rno, body);
		
		req.setAttribute("NOWPAGE", spage);
		if(cnt == 0) {
			req.setAttribute("VIEW", "/camp24/board/reBoardEdit.cmp");
		} else {
			req.setAttribute("VIEW", "/camp24/board/reBoardList.cmp");
		}
		
		 
		return view;
	}

}
