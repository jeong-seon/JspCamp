package com.camp24.controller.leo.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sunw.BoardDao;
import com.camp24.vo.BoardVO;

public class ReBoardWrite implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/reviewBoardWrite";
		
		String sid = (String) req.getSession().getAttribute("SID");
		
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/camp24/member/login.cmp";
			return view;
		}
		
		BoardDao bDao = new BoardDao();
		ArrayList<BoardVO> clist = bDao.getCampList();
		
		req.setAttribute("CAMP", clist);
		
		return view;
	}

}
