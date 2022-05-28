package com.camp24.controller.leo.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.util.FileUtil;
import com.camp24.vo.FileVO;
import com.camp24.dao.leo.*;
import com.camp24.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

public class ReBoardWriteProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/camp24/board/reBoardList.cmp";
		
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/camp24/member/login.cmp";
		}
		
		// 파라미터 꺼내고
		
			String title = req.getParameter("title");
			String spage = req.getParameter("nowPage");
			String body = req.getParameter("body");

			BoardVO bVO = new BoardVO();
			bVO.setId(sid);
			bVO.setBody(body);
			bVO.setTitle(title);
			
			req.setAttribute("NOWPAGE", spage);
			
			ReBoardDao rDao = new ReBoardDao();

			// 데이터베이스 작업하고 결과받고
			int result = rDao.WriteRe(bVO);
			// 결과에 따라서 뷰 작성하고
			if(result == 0) {
				// 글등록에 실패한 경우
				
				// POST 방식 - redirect용 jsp 파일을 이용하는 경우
				req.setAttribute("isRedirect", false);
				req.setAttribute("VIEW", "/camp24/board/reBoardWrite.cmp");
				return "/board/redirect";
			}
		
		
		return view;
	}



}