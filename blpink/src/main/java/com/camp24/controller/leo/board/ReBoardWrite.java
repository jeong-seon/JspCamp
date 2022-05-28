package com.camp24.controller.leo.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.ReBoardDao;

public class ReBoardWrite implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 꺼내고
		String spage = req.getParameter("nowPage");
	
		
		String view = "/board/reviewBoardWrite";
		return view;
	}

}
