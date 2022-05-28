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

public class FreeBoardEdit implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/freeBoard/freeBoardEdit";
		
		// 할 일
		// 로그인 검사
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/camp24/member/login.cmp";
			req.setAttribute("isRedirect", true);
			return view;
		}
		
		String sno = req.getParameter("fbno");
		int fbno = Integer.parseInt(sno);
		
		// 데이터베이스에서 내 정보 꺼내오고
		FreeBoardDao fDao = new FreeBoardDao();
		BoardVO bVO = fDao.getWriterInfo(sid, fbno);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		
		// 뷰 부르고
		return view;
	}

}
