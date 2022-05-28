package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.FreeBoardDao;

/**
 * 
 * @author	백서진
 * @since	2022/05/27
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/27	-	클래스 제작
 * 								자유게시판 글수정 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class FreeBoardEditProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view ="/camp24/freeBoard/freeBoardList.cmp";
		
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/camp24/member/login.cmp";
		}
		
		// 파라미터 가져오고
		String sno = req.getParameter("fbno");
		int fbno = Integer.parseInt(sno);
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		
		StringBuffer buff = new StringBuffer();
		
		if(title != null) {
			buff.append(" , ftitle = '" + title + "' ");
		}
		if(body != null) {
			buff.append(" , fbody = '" + body + "' ");
		}
		
		String psql = buff.toString().substring(3);
		
		// 데이터베이스 작업하고
		FreeBoardDao fDao = new FreeBoardDao();
		int cnt = fDao.editFreeBoard(fbno, psql);
		
		// 결과값에 따라 처리하고
		if(cnt != 1) {
			// 실패한 경우
			view = "/camp24/freeBoard/freeBoardEdit.cmp?fbno=" + sno;
		}
		
		// 뷰 부르고
		return view;
	}

}
