package com.camp24.controller.leo.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.ReBoardDao;
import com.camp24.vo.BoardVO;

public class ReBoardEdit implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/reboardEdit";
		/*
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/member/login.cmp";
		}
		*/
		
		String sid = "NEY21";
		
		//파라미터 꺼내고
		String sno = req.getParameter("rno");
		int rno = Integer.parseInt(sno);
		
		ReBoardDao rDao = new ReBoardDao();
		BoardVO bVO = rDao.getEditData(rno, sid);
		
		//데이터심고
		req.setAttribute("DATA", bVO);
		
		return view;
	}

}
