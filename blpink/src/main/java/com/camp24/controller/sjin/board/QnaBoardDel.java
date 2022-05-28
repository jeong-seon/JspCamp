package com.camp24.controller.sjin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sjin.QnaBoardDao;

/**
 * 
 * @author	백서진
 * @since	2022/05/27
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/27	-	클래스 제작
 * 								QnA 게시판 글삭제 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class QnaBoardDel implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/qnaBoard/redirect";
		
		// 할 일
		// 파라미터 받고
		String sno = req.getParameter("qno");
		String spage = req.getParameter("nowPage");
		int qno = Integer.parseInt(sno);
		
		// 데이터베이스 작업
		QnaBoardDao qDao = new QnaBoardDao();
		int cnt = qDao.delQnaBoard(qno);
		
		// 데이터 심고
		req.setAttribute("VIEW", "/camp24/qnaBoard/qnaBoardList.cmp");
		req.setAttribute("NOWPAGE", spage);
		
		if(cnt == 0) {
			// 실패한 경우
			req.setAttribute("MSG", sno + "번글 삭제 작업이 실패했습니다.");
		} else {
			// 성공한 경우
			req.setAttribute("MSG", sno + "번글 삭제 작업이 성공했습니다.");
		}
		
		// 뷰 부르고
		return view;
	}

}
