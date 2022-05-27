package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.FreeBoardDao;
import com.camp24.vo.BoardVO;

/**
 * 
 * @author	백서진
 * @since	2022/05/24
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/24	-	클래스 제작
 * 								자유게시판 글등록 처리 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class FreeBoardWriteProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/camp24/freeBoard/freeBoardList.cmp";
		
		// 할 일
		// 세션검사
		/*
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/camp24/member/login.cmp";
		}*/
		
		// 파라미터 꺼내고
		String sno = req.getParameter("mno");
		int mno = Integer.parseInt(sno);
		
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String spage = req.getParameter("nowPage");
		
		BoardVO bVO = new BoardVO();
		bVO.setTitle(title);
		bVO.setBody(body);
		bVO.setMno(mno);
		
		// 데이터베이스 작업하고
		FreeBoardDao fDao = new FreeBoardDao();
		int cnt = fDao.addFreeBoard(bVO);
		
		req.setAttribute("NOWPAGE", spage);
		
		// 결과에 따라서 처리하고
		if(cnt == 0) {
			// get 방식
			// view = "/camp24/freeBoard/freeBoardWrite.cmp?nowPage=" + spage;
			
			// post 방식 - forward 처리
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/camp24/freeBoard/freeBoardWrite.cmp");
			view = "/freeBoard/redirect";
		}
		
		return view;
	}

}
