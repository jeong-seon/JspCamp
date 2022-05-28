package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.QnaBoardDao;
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
 * 								QnA 게시판 댓글 쓰기 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class QnaComment implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/qnaBoard/qnaBoardComment";
		String sid = (String) req.getSession().getAttribute("SID");
		
		// 할 일
		// 세션검사
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/camp24/member/login.cmp";
			return view;
		}
		
		// 파라미터 받고
		String sno = req.getParameter("qno");
		int qno = Integer.parseInt(sno);
		
		String spage = req.getParameter("nowPage");
		
		// 로그인 한 경우 데이터베이스에서 데이터 꺼내오기
		QnaBoardDao qDao = new QnaBoardDao();
		BoardVO bVO = qDao.getWriterInfo(sid, qno);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		
		// 뷰 부르고
		return view;
	}
}
