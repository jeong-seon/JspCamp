package com.camp24.controller.leo.board;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author	leo
 * @since	2022/05/26
 * @version	v.1.0
 * @see
 * 			com.camp24.controller.leo.ReviewBoard
 * 
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 								담당자 : leo
 *
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.leo.ReBoardDao;
import com.camp24.util.PageUtil;
import com.camp24.vo.BoardVO;

public class ReBoardList implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/reviewBoardList";
		
		int nowPage = 1;
		String spage = req.getParameter("nowPage");
		if(spage != null) {
			nowPage = Integer.parseInt(spage);
		}
		
		ReBoardDao rDao = new ReBoardDao();
		int total = rDao.getTotalCount();
		 
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<BoardVO> list1 = rDao.getReBoardList(page);
		ArrayList<BoardVO> list2 = rDao.getImageList();
		req.setAttribute("LIST", list1);
		req.setAttribute("IMAGE", list2);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
