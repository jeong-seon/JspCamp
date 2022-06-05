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
		
		FileUtil futil = new FileUtil(req, "/resources/upload");
		MultipartRequest multi = futil.getMulti();
		
		
		// 파라미터 꺼내고
		String title = multi.getParameter("title");
		String body = multi.getParameter("body");
		String score = multi.getParameter("score");
		String scno = multi.getParameter("clist");
		int cno = Integer.parseInt(scno);
		
		ArrayList<FileVO> list = futil.getList();

//		String spage = req.getParameter("nowPage");
		
		BoardVO bVO = new BoardVO();
		bVO.setId(sid);
		bVO.setCno(cno);
		bVO.setScore(score);
		bVO.setRbody(body);
		bVO.setRtitle(title);
		bVO.setList(list);
		
//		System.out.println("####### cno : " + cno);
		
//		req.setAttribute("NOWPAGE", spage);
		
		ReBoardDao rDao = new ReBoardDao();
		// 데이터베이스 작업하고 결과받고
//		int cnt = rDao.WriteRe(bVO);
		int cnt = rDao.insertReData(bVO);
//		System.out.println("######## cnt : " + cnt);

		// 결과에 따라서 뷰 작성하고
		if(cnt == -1 || cnt != bVO.getList().size()) {
			// 글등록에 실패한 경우
			view = "/camp24/board/reBoardWrite.cmp?nowPage=" + multi.getParameter("nowPage");
		} else {
			view = "/camp24/board/reBoardList.cmp";
		}
			
//			// POST 방식 - redirect용 jsp 파일을 이용하는 경우
//			req.setAttribute("isRedirect", false);
//			req.setAttribute("VIEW", "/camp24/board/reBoardWrite.cmp");
//			return "/board/redirect";
		
		
		return view;
	}



}