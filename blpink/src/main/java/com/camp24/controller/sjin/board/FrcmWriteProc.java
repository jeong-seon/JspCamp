package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.FreeBoardDao;
import com.camp24.vo.BoardVO;

public class FrcmWriteProc implements CmpInter {
	
/**
 * 
 * @author	백서진
 * @since	2022/05/26
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/26	-	클래스 제작
 * 								자유게시판 댓글 쓰기 클래스 제작
 * 									담당자 : 백서진
 *
 */
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/camp24/freeBoard/freeBoardList.cmp";
		
		// 할 일
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/camp24/member/login.cmp";
			return view;
		}
		
		// 파라미터 꺼내고
		String sno = req.getParameter("mno");
		String spage = req.getParameter("nowPage");
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String supno = req.getParameter("fbno");
		
		BoardVO bVO = new BoardVO();
		bVO.setMno(Integer.parseInt(sno));
		bVO.setBody(body);
		bVO.setTitle(title);
		
		if(supno != null) {
			bVO.setFupno(Integer.parseInt(supno));
		}
		
		// 데이터베이스 작업하고
		FreeBoardDao fDao = new FreeBoardDao();
		int cnt = fDao.addFreeBoard(bVO);
		
		// 데이터 심고
		req.setAttribute("NOWPAGE", spage);
		
		// 결과에 따라서 처리하고
		if(cnt == 0 && supno != null) {
			// 댓글 등록 실패
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/camp24/freeBoard/freeBoardComment.cmp");
			view = "/freeBoard/redirect";
		} else if(cnt == 1 && supno != null) {
			// 댓글 등록 성공
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/camp24/freeBoard/freeBoardList.cmp");
			view = "/freeBoard/redirect";
		}
		req.setAttribute("NOWPAGE", spage);
		
		// 뷰 부르고
		return view;
	}

}
