package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * 								자유게시판 글쓰기 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class FreeBoardWrite implements CmpInter {
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/freeBoard/freeBoardWrite";
		
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/camp24/member/login.cmp";
			return view;
		}

		// 로그인 한 경우이므로 데이터베이스에서 데이터 꺼내오기
		FreeBoardDao fDao = new FreeBoardDao();
		BoardVO bVO = fDao.getWriterInfo(sid);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		
		 
		return view;
	}
}
